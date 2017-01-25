package api;

import apimodels.CreateUser;
import apimodels.CreatedUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by rutvik on 1/22/2017 at 11:13 PM.
 */

public interface ApiInterface
{

    //DECLARE ALL API METHODS HERE

    @POST
    Call<CreatedUser> createUser(@Url String url,
                                 @Body CreateUser createUser);

}
