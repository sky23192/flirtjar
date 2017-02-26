package com.app.flirtjar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.ProfileTracker;

import java.net.HttpURLConnection;

import api.API;
import api.RetrofitCallback;
import apimodels.CreateUser;
import apimodels.CreatedUser;
import apimodels.User;
import apimodels.Views;
import butterknife.BindView;
import butterknife.ButterKnife;
import fragments.FragmentChat;
import fragments.FragmentJar;
import fragments.FragmentMap;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import retrofit2.Call;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import utils.Constants;
import utils.Dialog;
import utils.Logger;
import utils.SharedPreferences;

public class ActivityNavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener
{

    private static final String TAG = App.APP_TAG + ActivityNavDrawer.class.getSimpleName();
    private final Handler mHandler = new Handler();
    FragmentManager fragmentManager;
    @BindView(R.id.tv_navLogoText)
    TextView tvNavLogoText;
    @BindView(R.id.btn_nearby)
    ImageButton btnNearby;
    @BindView(R.id.btn_jar)
    ImageButton btnJar;
    @BindView(R.id.btn_chat)
    ImageButton btnChat;
    @BindView(R.id.ll_nearby)
    LinearLayout llNearby;
    @BindView(R.id.ll_jar)
    LinearLayout llJar;
    @BindView(R.id.ll_chat)
    LinearLayout llChat;
    TextView tvUsername;
    ImageView ivProfilePicture;
    int currentPage = 1;
    ActionBarDrawerToggle toggle;
    View navigationViewHeader;
    TextView tvLikeCount;
    TextView tvVisitedCount;
    TextView tvSuperlikeCount;
    TextView tvSkipCount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        ButterKnife.bind(this);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Righteous-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        final Typeface pacifico = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");

        tvNavLogoText.setTypeface(pacifico);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");

        fragmentManager = getSupportFragmentManager();

        btnJar.setSelected(true);

        llNearby.setOnClickListener(this);
        llJar.setOnClickListener(this);
        llChat.setOnClickListener(this);


        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationViewHeader = navigationView.getHeaderView(0);

        navigationViewHeader.findViewById(R.id.ib_settings)
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        startActivity(new Intent(ActivityNavDrawer.this, ActivitySetting.class));
                    }
                });

        tvLikeCount = (TextView) navigationViewHeader.findViewById(R.id.tv_likeCount);
        tvVisitedCount = (TextView) navigationViewHeader.findViewById(R.id.tv_visitedCount);
        tvSuperlikeCount = (TextView) navigationViewHeader.findViewById(R.id.tv_superlikeCount);
        tvSkipCount = (TextView) navigationViewHeader.findViewById(R.id.tv_skipCount);

        tvUsername = (TextView) navigationView.getHeaderView(0)
                .findViewById(R.id.tv_username);

        ivProfilePicture = (ImageView) navigationView.getHeaderView(0)
                .findViewById(R.id.iv_profilePicture);

        toggle.setDrawerIndicatorEnabled(false);

        toggle.setHomeAsUpIndicator(R.drawable.ic_account_circle_white_24dp);

        toggle.setToolbarNavigationClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (drawer.isDrawerVisible(GravityCompat.START))
                {
                    drawer.closeDrawer(GravityCompat.START);
                } else
                {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        getFacebookAuthToken();

        fragmentManager.beginTransaction()
                .replace(R.id.fl_fragmentContainer, FragmentJar.newInstance())
                .commitAllowingStateLoss();

    }

    private void getFacebookAuthToken()
    {
        if (AccessToken.getCurrentAccessToken() == null)
        {
            Intent i = new Intent(this, ActivityLogin.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
        getFacebookProfileDetails();
    }

    private void getFacebookProfileDetails()
    {
        FacebookProfileTracker fpt = new FacebookProfileTracker();
        fpt.startTracking();

        Glide.with(this)
                .load(Profile.getCurrentProfile().getProfilePictureUri(200, 200))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(ivProfilePicture);

        Glide.with(this)
                .load(Profile.getCurrentProfile().getProfilePictureUri(80, 80))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(new SimpleTarget<GlideDrawable>()
                {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation)
                    {
                        toggle.setHomeAsUpIndicator(resource);
                    }
                });

        tvUsername.setText(Profile.getCurrentProfile().getFirstName());


        final String flirtjarUserToken = SharedPreferences.getFlirtjarUserToken(this);

        if (flirtjarUserToken == null)
        {
            createNewFlirtjarUser(Profile.getCurrentProfile());
        } else
        {
            setupBottomBar(1);
            getCurrentUser(flirtjarUserToken);
        }

    }


    private void getCurrentUser(final String flirtjarUserToken)
    {
        final RetrofitCallback<User> onGetUser = new RetrofitCallback<User>()
        {
            @Override
            public void onResponse(Call<User> call, Response<User> response)
            {
                super.onResponse(call, response);
                if (response.isSuccessful())
                {
                    App.getInstance().setUser(response.body());
                    getViews(App.getInstance().getUser().getResult().getId(),
                            flirtjarUserToken);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t)
            {
                super.onFailure(call, t);
            }
        };

        API.User.getCurrentUser(flirtjarUserToken, onGetUser);
    }

    private void getViews(int userId, String flirtjarUserToken)
    {
        final RetrofitCallback<Views> onGetViews = new RetrofitCallback<Views>()
        {
            @Override
            public void onResponse(Call<Views> call, final Response<Views> response)
            {
                super.onResponse(call, response);
                if (response.isSuccessful())
                {
                    mHandler.post(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            tvLikeCount.setText(response.body().getResult().getLikes() + " >");
                            tvVisitedCount.setText(response.body().getResult().getPk() + " >");
                            tvSuperlikeCount.setText(response.body().getResult().getSuperlikes() + " >");
                            tvSkipCount.setText(response.body().getResult().getSkipped() + " >");

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Views> call, Throwable t)
            {
                super.onFailure(call, t);
            }
        };

        API.Profile.getViews(userId + "", flirtjarUserToken, onGetViews);
    }

    private void createNewFlirtjarUser(Profile profile)
    {
        Dialog.showLoadingDialog(this, "Please Wait...", "Creating account...", false, false, null);
        CreateUser user = new CreateUser();
        user.setOauthId(AccessToken.getCurrentAccessToken().getUserId());
        user.setFirstName(profile.getFirstName());
        user.setLastName(profile.getLastName());

        final RetrofitCallback<CreatedUser> onUserCreated = new RetrofitCallback<CreatedUser>()
        {
            @Override
            public void onResponse(Call<CreatedUser> call, Response<CreatedUser> response)
            {
                super.onResponse(call, response);
                Dialog.hideLoadingDialog();

                if (response.code() == HttpURLConnection.HTTP_CREATED || response.isSuccessful())
                {
                    PreferenceManager.getDefaultSharedPreferences(ActivityNavDrawer.this)
                            .edit()
                            .putString(Constants.FLIRTJAR_USER_TOKEN, response.body().getResult().getToken())
                            .apply();
                    Toast.makeText(ActivityNavDrawer.this, "User created successfully", Toast.LENGTH_SHORT).show();

                    setupBottomBar(1);

                } else
                {
                    Toast.makeText(ActivityNavDrawer.this, "Failed to create user", Toast.LENGTH_SHORT).show();

                    if (response.body() != null)
                    {
                        /*for (String error : response.body().getErrors())
                        {
                            Toast.makeText(ActivityNavDrawer.this, error, Toast.LENGTH_SHORT).show();
                        }*/
                    }

                }
            }

            @Override
            public void onFailure(Call<CreatedUser> call, Throwable t)
            {
                super.onFailure(call, t);
                Log.i(TAG, t.getMessage());
                Toast.makeText(ActivityNavDrawer.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Dialog.hideLoadingDialog();
            }
        };

        API.User.createUser(user, onUserCreated);
    }

    private void setupBottomBar(int position)
    {
        switch (position)
        {
            case 0:
                if (currentPage != position)
                {
                    currentPage = position;
                    fragmentManager.beginTransaction()
                            .replace(R.id.fl_fragmentContainer, new FragmentMap())
                            .commitAllowingStateLoss();
                }
                break;

            case 1:
                if (currentPage != position)
                {
                    final FragmentJar fj = FragmentJar.newInstance();
                    currentPage = position;
                    fragmentManager.beginTransaction()
                            .replace(R.id.fl_fragmentContainer, fj)
                            .commitNow();

                }
                break;

            case 2:
                if (currentPage != position)
                {
                    currentPage = position;
                    fragmentManager.beginTransaction()
                            .replace(R.id.fl_fragmentContainer, FragmentChat.newInstance())
                            .commitAllowingStateLoss();
                }
                break;

        }
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)
        {
            // Handle the camera action
        } else if (id == R.id.nav_gallery)
        {

        } else if (id == R.id.nav_slideshow)
        {

        } else if (id == R.id.nav_manage)
        {

        } else if (id == R.id.nav_share)
        {

        } else if (id == R.id.nav_send)
        {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.ll_nearby:
                setupBottomBar(0);
                btnNearby.setSelected(true);
                btnJar.setSelected(false);
                btnChat.setSelected(false);
                break;

            case R.id.ll_jar:
                setupBottomBar(1);
                btnNearby.setSelected(false);
                btnJar.setSelected(true);
                btnChat.setSelected(false);
                break;

            case R.id.ll_chat:
                setupBottomBar(2);
                btnNearby.setSelected(false);
                btnJar.setSelected(false);
                btnChat.setSelected(true);
                break;
        }
    }

    @Override
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    class FacebookProfileTracker extends ProfileTracker
    {
        @Override
        protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile)
        {
            Logger.log(TAG, currentProfile.getFirstName());
            Logger.log(TAG, currentProfile.getLastName());
            Logger.log(TAG, currentProfile.getProfilePictureUri(200, 200).toString());
        }
    }

}
