package api;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.RetroParser;

/**
 * Created by rutvik on 1/22/2017 at 11:14 PM.
 */

public abstract class RetrofitCallback<T> implements Callback<T>
{

    final Context context;

    public RetrofitCallback(Context context)
    {
        this.context = context;
    }

    @CallSuper
    @Override
    public void onResponse(Call<T> call, Response<T> response)
    {
        if (!response.isSuccessful() && response.errorBody() != null)
        {
            try
            {
                RetroParser.parseAndShowErrors(context, response.errorBody().string());
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @CallSuper
    @Override
    public void onFailure(Call<T> call, Throwable t)
    {
        Toast.makeText(context, "FAILURE: " + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
