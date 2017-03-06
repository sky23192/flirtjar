package fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.app.flirtjar.App;
import com.app.flirtjar.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wallet.Wallet;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import api.RetrofitCallback;
import apimodels.Cards;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;
import utils.Constants;
import utils.SharedPreferences;

/**
 * Created by rutvik on 2/5/2017 at 4:13 PM.
 */

public class FragmentJar extends Fragment implements GoogleApiClient.OnConnectionFailedListener
{

    public static final String TAG = App.APP_TAG + FragmentJar.class.getSimpleName();
    private final Handler mHandler = new Handler();
    @BindView(R.id.ibtn_like)
    ImageButton ibtnLike;
    @BindView(R.id.ibtn_dislike)
    ImageButton ibtnDislike;
    @BindView(R.id.ibtn_super_like)
    ImageButton ibtnSuperLike;
    @BindView(R.id.ib_return)
    ImageButton ibReturn;
    @BindView(R.id.ibtn_gift)
    ImageButton ibtnGift;
    private SwipePlaceHolderView mSwipeView;
    private Context mContext;
    private Cards cards;
    final RetrofitCallback<Cards> onGetCards = new RetrofitCallback<Cards>()
    {

        @Override
        public void onResponse(Call<Cards> call, final Response<Cards> response)
        {
            super.onResponse(call, response);
            if (response.isSuccessful())
            {
                if (cards == null)
                {
                    cards = response.body();
                } else
                {
                    cards.getResult().addAll(response.body().getResult());
                }

                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        /*for (Cards.ResultBean singleCard : cards.getResult())
                        {
                            mSwipeView.addView(new FlirtjarCard(getActivity(), singleCard, mSwipeView));
                        }*/
                    }
                });


            }
        }
    };
    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog mProgressDialog;

    public static FragmentJar newInstance()
    {
        return new FragmentJar();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // [START basic_google_api_client]
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(Wallet.API, new Wallet.WalletOptions.Builder()
                        .setEnvironment(Constants.WALLET_ENVIRONMENT)
                        .build())
                .enableAutoManage(getActivity(), this)
                .build();
        // [END basic_google_api_client]

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_jar, container, false);

        ButterKnife.bind(this, view);

        mSwipeView = (SwipePlaceHolderView) view.findViewById(R.id.swipeview);
        mContext = getContext();


        final String token = SharedPreferences.getFlirtjarUserToken(getActivity());

        //API.JarModule.getCards(1, token, onGetCards);

        /*view.findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });*/

        /*view.findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });*/

        setupSwipeView();

        return view;
    }


    public void setupSwipeView()
    {
        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.flirtjar_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.flirtjar_swipe_out_msg_view));

        mSwipeView.removeAllViews();


        for (Profile profile : Utils.loadProfiles(getActivity()))
        {
            mSwipeView.addView(new FlirtjarCard(mContext, profile, mSwipeView));
        }


    }


    @OnClick(R.id.ibtn_like)
    public void like()
    {
        mSwipeView.doSwipe(true);
    }

    @OnClick(R.id.ibtn_dislike)
    public void dislike()
    {
        mSwipeView.doSwipe(false);
    }

    @OnClick(R.id.ib_return)
    public void putBack()
    {
        mSwipeView.undoLastSwipe();
    }

    @OnClick(R.id.ibtn_super_like)
    public void superLike()
    {
        Toast.makeText(mContext, "Superliked", Toast.LENGTH_SHORT).show();
        mSwipeView.doSwipe(true);
    }

    @OnClick(R.id.ibtn_gift)
    public void sendGift()
    {
        showProgressDialog();
        Wallet.Payments.isReadyToPay(mGoogleApiClient).setResultCallback(
                new ResultCallback<BooleanResult>()
                {
                    @Override
                    public void onResult(@NonNull BooleanResult booleanResult)
                    {
                        hideProgressDialog();

                        if (booleanResult.getStatus().isSuccess())
                        {
                            if (booleanResult.getValue())
                            {
                                // Show Android Pay buttons and hide regular checkout button
                                // [START_EXCLUDE]
                                Log.d(TAG, "isReadyToPay:true");

                                /*findViewById(R.id.button_regular_checkout)
                                        .setVisibility(View.GONE);*/
                                // [END_EXCLUDE]
                            } else
                            {
                                // Hide Android Pay buttons, show a message that Android Pay
                                // cannot be used yet, and display a traditional checkout button
                                // [START_EXCLUDE]
                                Log.d(TAG, "isReadyToPay:false:" + booleanResult.getStatus());
                                /*findViewById(R.id.layout_android_pay_checkout)
                                        .setVisibility(View.GONE);
                                findViewById(R.id.android_pay_message)
                                        .setVisibility(View.VISIBLE);
                                findViewById(R.id.button_regular_checkout)
                                        .setVisibility(View.VISIBLE);*/
                                // [END_EXCLUDE]
                            }
                        } else
                        {
                            // Error making isReadyToPay call
                            Log.e(TAG, "isReadyToPay:" + booleanResult.getStatus());
                        }
                    }
                });
        // [END is_ready_to_pay]
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult)
    {
        Log.e(TAG, "onConnectionFailed:" + connectionResult.getErrorMessage());
        Toast.makeText(getActivity(), "Google Play Services error", Toast.LENGTH_SHORT).show();
    }


    private void showProgressDialog()
    {
        if (mProgressDialog == null)
        {
            mProgressDialog = new ProgressDialog(getActivity());
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

}
