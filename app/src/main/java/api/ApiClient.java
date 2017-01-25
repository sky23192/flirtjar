package api;

import com.app.flirtjar.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rutvik on 1/22/2017 at 11:14 PM.
 */

public class ApiClient
{
    private static Retrofit retrofit = null;

    public static Retrofit getClient()
    {
        HttpLoggingInterceptor loggingInterceptor =
                new HttpLoggingInterceptor();

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }


}
