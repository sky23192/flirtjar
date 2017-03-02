package fragments;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.flirtjar.App;
import com.app.flirtjar.R;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import api.RetrofitCallback;
import apimodels.Cards;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;
import utils.SharedPreferences;

/**
 * Created by rutvik on 2/5/2017 at 4:13 PM.
 */

public class FragmentJar extends Fragment
{

    public static final String TAG = App.APP_TAG + FragmentJar.class.getSimpleName();
    private final Handler mHandler = new Handler();
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

    public static FragmentJar newInstance()
    {
        return new FragmentJar();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
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

        Log.i(TAG, token);

        Toast.makeText(mContext, token, Toast.LENGTH_SHORT).show();

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

        mHandler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                for (Profile profile : Utils.loadProfiles(getActivity()))
                {
                    mSwipeView.addView(new FlirtjarCard(mContext, profile, mSwipeView));
                }
            }
        }, 5000);


    }

}
