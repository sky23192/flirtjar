package api;

import android.support.annotation.CallSuper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rutvik on 1/22/2017 at 11:14 PM.
 */

public class RetrofitCallback<T> implements Callback<T>
{
    @CallSuper
    @Override
    public void onResponse(Call<T> call, Response<T> response)
    {

    }

    @CallSuper
    @Override
    public void onFailure(Call<T> call, Throwable t)
    {

    }
}
