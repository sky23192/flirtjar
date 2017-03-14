package fcm;

import android.preference.PreferenceManager;
import android.util.Log;

import com.app.flirtjar.App;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import utils.Constants;


/**
 * Created by rutvik on 12/30/2016 at 3:18 PM.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService
{
    private static final String TAG = App.APP_TAG + MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh()
    {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.i(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        PreferenceManager.getDefaultSharedPreferences(App.getInstance())
                .edit()
                .putString(Constants.FCM_DEVICE_TOKEN, refreshedToken)
                .apply();
    }

}
