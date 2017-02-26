package api;

import java.util.List;

import apimodels.Cards;
import apimodels.CreateUser;
import apimodels.CreatedUser;
import apimodels.NearByUser;
import apimodels.UpdateUser;
import apimodels.Views;
import retrofit2.Call;
import utils.Constants;

/**
 * Created by rutvik on 1/22/2017 at 11:13 PM.
 */

public class API
{

    public static class User
    {
        private static ApiInterface.Users users =
                ApiClient.getClient().create(ApiInterface.Users.class);

        public static Call<CreatedUser> createUser(final CreateUser userInfo,
                                                   final RetrofitCallback<CreatedUser> callback)
        {
            Call<CreatedUser> call = users.createUser(userInfo, Constants.CONTENT_TYPE_JSON);
            call.enqueue(callback);
            return call;
        }

        public static Call<UpdateUser> updateUserDetails(final UpdateUser userInfo,
                                                         final String token,
                                                         final RetrofitCallback<UpdateUser> callback)
        {
            Call<UpdateUser> call = users.updateUserDetails(userInfo, Constants.CONTENT_TYPE_JSON,
                    token);
            call.enqueue(callback);
            return call;
        }

        public static Call<apimodels.User> getCurrentUser(final String token,
                                                          final RetrofitCallback<apimodels.User> callback)
        {
            Call<apimodels.User> call = users.getCurrentUser(token);
            call.enqueue(callback);
            return call;
        }

        public static Call<apimodels.User> getUser(final String userId,
                                                   final RetrofitCallback<apimodels.User> callback)
        {
            Call<apimodels.User> call = users.getUser(userId);
            call.enqueue(callback);
            return call;
        }

    }

    public static class Profile
    {
        private static ApiInterface.Profile profile =
                ApiClient.getClient().create(ApiInterface.Profile.class);

        public static Call<Cards> getCards(final int page,
                                           final String token,
                                           final RetrofitCallback<Cards> callback)
        {
            Call<Cards> call = profile.getCards(page, token);
            call.enqueue(callback);
            return call;
        }

        public static Call<Views> getViews(final String userId,
                                           final String token,
                                           final RetrofitCallback<Views> callback)
        {
            Call<Views> call = profile.getViews(userId, token);
            call.enqueue(callback);
            return call;
        }

    }

    public static class Location
    {

        private static ApiInterface.Location location =
                ApiClient.getClient().create(ApiInterface.Location.class);

        public static Call<List<NearByUser>> getNearByUsers(int distance,
                                                            ApiInterface.Location.LocationUnit unit,
                                                            String token,
                                                            RetrofitCallback<List<NearByUser>> callback)
        {
            Call<List<NearByUser>> call = location
                    .getNearByUsers(distance,
                            unit.getValue(),
                            token);
            call.enqueue(callback);
            return call;
        }

    }


}
