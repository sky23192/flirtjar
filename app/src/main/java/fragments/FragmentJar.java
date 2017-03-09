package fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.flirtjar.App;
import com.app.flirtjar.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import api.API;
import api.RetrofitCallback;
import apimodels.Cards;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;
import util.IabHelper;
import util.IabResult;
import util.Inventory;
import util.Purchase;
import utils.BillingDetailsConstants;
import utils.SharedPreferences;

/**
 * Created by rutvik on 2/5/2017 at 4:13 PM.
 */

public class FragmentJar extends Fragment
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

    @BindView(R.id.iv_loadingGif)
    ImageView ivLoadingGif;

    IabHelper mIabHelper;
    IabHelper.OnConsumeFinishedListener onConsumeFinishedListener =
            new IabHelper.OnConsumeFinishedListener()
            {
                @Override
                public void onConsumeFinished(Purchase purchase, IabResult result)
                {
                    if (result.isSuccess())
                    {

                    } else
                    {

                    }
                }
            };
    IabHelper.QueryInventoryFinishedListener queryInventoryFinishedListener =
            new IabHelper.QueryInventoryFinishedListener()
            {
                @Override
                public void onQueryInventoryFinished(IabResult result, Inventory inv)
                {
                    if (result.isFailure())
                    {

                    } else
                    {
                        mIabHelper.consumeAsync(inv.getPurchase(BillingDetailsConstants.ITEM_SKU),
                                onConsumeFinishedListener);
                    }
                }
            };
    IabHelper.OnIabPurchaseFinishedListener onIabPurchaseFinishedListener =
            new IabHelper.OnIabPurchaseFinishedListener()
            {
                @Override
                public void onIabPurchaseFinished(IabResult result, Purchase purchase)
                {
                    if (result.isFailure())
                    {
                        return;
                    } else if (purchase.getSku().equals(BillingDetailsConstants.ITEM_SKU))
                    {
                        consumeItem();

                    }
                }
            };
    Call<Cards> call;
    private SwipePlaceHolderView mSwipeView;
    private Context mContext;
    private Cards cards;
    private ProgressDialog mProgressDialog;

    public static FragmentJar newInstance()
    {
        return new FragmentJar();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mIabHelper = new IabHelper(getActivity(), BillingDetailsConstants.base64EncodedPublicKey);

        mIabHelper.startSetup(new IabHelper.OnIabSetupFinishedListener()
        {
            @Override
            public void onIabSetupFinished(IabResult result)
            {
                if (result.isSuccess())
                {
                    Log.i(TAG, "IN APP BILLING SETUP OK");
                } else
                {
                    Log.i(TAG, "IN APP BILLING SETUP FAILED");
                }
            }
        });

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

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(ivLoadingGif);
        Glide.with(this).load(R.raw.loading_cards).into(imageViewTarget);

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        final String token = SharedPreferences.getFlirtjarUserToken(getActivity());

        final RetrofitCallback<Cards> onGetCards = new RetrofitCallback<Cards>(getActivity())
        {

            @Override
            public void onResponse(Call<Cards> call, final Response<Cards> response)
            {
                super.onResponse(call, response);
                if (response.isSuccessful())
                {
                    if (response.body().getResult() != null)
                    {
                        if (response.body().getResult().size() > 0)
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
                                    for (Cards.ResultBean singleCard : cards.getResult())
                                    {
                                        mSwipeView.addView(new FlirtjarCard(getActivity(), singleCard, mSwipeView));
                                    }
                                }
                            });
                        }
                    }
                }
            }
        };

        call = API.Profile.getCards(1, token, onGetCards);

    }

    public void setupSwipeView()
    {
        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setIsUndoEnabled(true)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setSwipeRotationAngle(5)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.flirtjar_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.flirtjar_swipe_out_msg_view));
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
        mIabHelper.launchPurchaseFlow(getActivity(), BillingDetailsConstants.ITEM_SKU
                , 10001, onIabPurchaseFinishedListener, "mypurchasetoken");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (!mIabHelper.handleActivityResult(requestCode, resultCode, data))
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void consumeItem()
    {
        mIabHelper.queryInventoryAsync(queryInventoryFinishedListener);
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

    @Override
    public void onDestroy()
    {
        if (mIabHelper != null)
        {
            mIabHelper.dispose();
            mIabHelper = null;
        }
        if (call != null)
        {
            call.cancel();
        }
        super.onDestroy();
    }
}
