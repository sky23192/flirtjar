package com.app.flirtjar;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import utils.SharedPreferences;


public class ActivityLogin extends Activity implements FacebookCallback<LoginResult>
{

    @BindView(R.id.btn_fbLogin)
    LoginButton btnFbLogin;

    @BindView(R.id.layout_dots)
    LinearLayout dotsLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    CallbackManager callbackManager;
    ProgressDialog mProgressDialog;
    private MyViewPagerAdapter myViewPagerAdapter;
    private TextView[] dots;
    //  viewpager change listener
    private int[] layouts;
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener()
    {

        @Override
        public void onPageSelected(int position)
        {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1)
            {
                // last page. make button text to GOT IT

            } else
            {
                // still pages are left
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
        {

        }

        @Override
        public void onPageScrollStateChanged(int arg0)
        {

        }
    };
    private ProfileTracker mProfileTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);


        btnFbLogin.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        // Hide Status Bar
        if (Build.VERSION.SDK_INT < 16)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else
        {
            View decorView = getWindow().getDecorView();
            // Hide Status Bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }


        PermissionListener permissionlistener = new PermissionListener()
        {
            @Override
            public void onPermissionGranted()
            {

            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions)
            {
                Log.d("DENIED PERMISSION", deniedPermissions.toString());
            }


        };
        new TedPermission(this)
                .setPermissionListener(permissionlistener)
                .setPermissions(Manifest.permission.CALL_PHONE,
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_WIFI_STATE)
                .check();


        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.welcome_slide1,
                R.layout.welcome_slide2,
                R.layout.welcome_slide3,
                R.layout.welcome_slide4};

        // adding bottom dots
        addBottomDots(0);

        // making notification bar transparent
        //        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        callbackManager = CallbackManager.Factory.create();

        btnFbLogin.setReadPermissions(Arrays.asList("email",
                "public_profile",
                "user_about_me",
                "user_birthday",
                "user_location",
                "user_photos",
                "user_relationships",
                "user_relationship_details",
                "user_relationship_details",
                "user_friends"));

        btnFbLogin.registerCallback(callbackManager, this);


    }

    private void addBottomDots(int currentPage)
    {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0)
        {
            dots[currentPage].setTextColor(colorsActive[currentPage]);
        }
    }

    private int getItem(int i)
    {
        return viewPager.getCurrentItem() + i;
    }

    @Override
    public void onSuccess(LoginResult loginResult)
    {
        SharedPreferences.setFacebookUserToken(this, loginResult.getAccessToken().getToken());

        if (Profile.getCurrentProfile() == null)
        {
            showProgressDialog();
            mProfileTracker = new ProfileTracker()
            {
                @Override
                protected void onCurrentProfileChanged(Profile profile, Profile profile2)
                {
                    hideProgressDialog();
                    // profile2 is the new profile
                    Intent i = new Intent(ActivityLogin.this, ActivityNavDrawer.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    mProfileTracker.stopTracking();
                }
            };
            // no need to call startTracking() on mProfileTracker
            // because it is called by its constructor, internally.
        } else
        {
            Intent i = new Intent(this, ActivityNavDrawer.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }


    }

    @Override
    public void onCancel()
    {
        Toast.makeText(this, "CANCELED", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(FacebookException error)
    {
        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void changeFontForAllTextViews(LinearLayout layout)
    {
        final Typeface pacifico = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");
        final Typeface montserrat = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");

        for (int i = 0; i < layout.getChildCount(); i++)
        {
            View v = layout.getChildAt(i);
            if (v instanceof TextView)
            {
                ((TextView) v).setTypeface(pacifico);
                if (v.getId() == R.id.tv_lbl32)
                {
                    ((TextView) v).setTypeface(montserrat);
                }
            }
        }
    }

    private void showProgressDialog()
    {
        if (mProgressDialog == null)
        {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setMessage("Loading...");
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog()
    {
        if (mProgressDialog != null && mProgressDialog.isShowing())
        {
            mProgressDialog.hide();
        }
    }

    @Override
    protected void onDestroy()
    {
        hideProgressDialog();
        super.onDestroy();
    }

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter
    {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter()
        {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);

            LinearLayout layout = (LinearLayout) view.findViewById(R.id.ll_welcomeSlide);

            if (layout != null)
            {
                changeFontForAllTextViews(layout);
            }

            container.addView(view);

            return view;
        }

        @Override
        public int getCount()
        {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj)
        {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
