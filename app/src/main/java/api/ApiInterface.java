package api;

import java.util.List;

import apimodels.Cards;
import apimodels.Coins;
import apimodels.CreateUser;
import apimodels.CreatedUser;
import apimodels.Gift;
import apimodels.MatchedProfiles;
import apimodels.NearByUser;
import apimodels.NotificationDeviceDetails;
import apimodels.OnAddPicturesResponse;
import apimodels.OtherPictures;
import apimodels.Picture;
import apimodels.ReceivedGifts;
import apimodels.SendChatMessage;
import apimodels.SendGift;
import apimodels.UpdateUser;
import apimodels.User;
import apimodels.Views;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import utils.Constants;

/**
 * Created by rutvik on 1/22/2017 at 11:13 PM.
 */

public interface ApiInterface
{

    //DECLARE ALL API METHODS HERE


    interface Users
    {
        @POST("users/")
        Call<CreatedUser> createUser(@Body CreateUser createUser,
                                     @Header(Constants.CONTENT_TYPE) String contentType);

        @PUT("users/me/")
        Call<UpdateUser> updateUserDetails(@Body CreateUser user,
                                           @Header(Constants.CONTENT_TYPE) String contentType,
                                           @Header(Constants.AUTHORIZATION) String token);

        @GET("users/{id}/")
        Call<User> getUser(@Path("id") String id);

        @GET("users/me/")
        Call<User> getCurrentUser(@Header(Constants.AUTHORIZATION) String token);

    }

    interface Profile
    {
        @GET("profile/cards/")
        Call<Cards> getCards(@Query("page") int page,
                             @Header(Constants.AUTHORIZATION) String token);

        @GET("profile/currency/")
        Call<Coins> getCurrency(@Header(Constants.AUTHORIZATION) String token);

        @GET("profile/gifts/")
        Call<ReceivedGifts> getReceivedGifts(@Header(Constants.AUTHORIZATION) String token);

        @POST("profile/gifts/")
        Call<SendGift> sendGift(@Body SendGift.ResultBean gift,
                                @Header(Constants.CONTENT_TYPE) String contentType,
                                @Header(Constants.AUTHORIZATION) String token);

        @GET("profile/match/")
        Call<MatchedProfiles> getMatchedProfiles(@Query("page") int page,
                                                 @Header(Constants.AUTHORIZATION) String token);

        @GET("profile/pictures/")
        Call<OtherPictures> getOtherPictures(@Query("page") int page,
                                             @Header(Constants.AUTHORIZATION) String token);

        @POST("profile/pictures/")
        Call<OnAddPicturesResponse> addPictures(@Body List<Picture> pictures,
                                                @Header(Constants.CONTENT_TYPE) String contentType,
                                                @Header(Constants.AUTHORIZATION) String token);

        @GET("profile/view/user/{id}/")
        Call<Views> getViews(@Path("id") String userId,
                             @Header(Constants.AUTHORIZATION) String token);


    }


    interface Location
    {
        @GET("location/nearby/{distance}/{unit}/")
        Call<NearByUser> getNearByUsers(@Path("distance") int distance,
                                        @Path("unit") String unit,
                                        @Header(Constants.AUTHORIZATION) String token);

        enum LocationUnit
        {
            kilometer("km"), meter("m");
            String value;

            private LocationUnit(String value)
            {
                this.value = value;
            }

            public String getValue()
            {
                return value;
            }
        }


    }

    interface Notifications
    {
        @GET("notifications/")
        Call<ResponseBody> getNotifications(@Query("page") int page,
                                            @Header(Constants.AUTHORIZATION) String token);

        @PUT("notifications/{id}/markread/")
        Call<ResponseBody> markRead(@Path("id") String id,
                                    @Header(Constants.AUTHORIZATION) String token);

        @POST("notifications/device/")
        Call<ResponseBody> registerNotificationDevice(@Body NotificationDeviceDetails deviceDetails,
                                                      @Header(Constants.CONTENT_TYPE) String contentType,
                                                      @Header(Constants.AUTHORIZATION) String token);
    }

    interface Gifts
    {
        @GET("gifts/")
        Call<Gift> getGifts(@Query("page") int page,
                            @Header(Constants.AUTHORIZATION) String token);
    }

    interface Chat
    {
        @GET("chat/")
        Call<ResponseBody> getChatMessages(@Query("user_from") int userId,
                                           @Header(Constants.AUTHORIZATION) String token);

        @POST("chat/")
        Call<ResponseBody> sendChatMessage(@Body SendChatMessage chatMessage,
                                           @Header(Constants.AUTHORIZATION) String token);
    }

}
