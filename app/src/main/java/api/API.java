package api;

import apimodels.CreateUser;
import apimodels.CreatedUser;
import retrofit2.Call;

/**
 * Created by rutvik on 1/22/2017 at 11:13 PM.
 */

public class API
{

    private static API api = new API();

    private ApiInterface apiInterface;

    private API()
    {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public static API getInstance()
    {
        return api;
    }

    //DEFINE ALL API METHODS HERE

    public Call<CreatedUser> createUser(final CreateUser userInfo,
                                        final RetrofitCallback<CreatedUser> callback)
    {
        Call<CreatedUser> call = apiInterface.createUser("users/", userInfo);

        call.enqueue(callback);

        return call;
    }

}
