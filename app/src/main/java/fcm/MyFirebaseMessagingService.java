package fcm;

import android.util.Log;

import com.app.flirtjar.App;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by rutvik on 12/30/2016 at 3:13 PM.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService
{
    private static final String TAG = App.APP_TAG + MyFirebaseMessagingService.class.getSimpleName();

    @Override
    public void onMessageReceived(RemoteMessage message)
    {
        String from = message.getFrom();
        Map data = message.getData();

        Log.i(TAG, "DATA: " + data.toString() + " FROM: " + from);

        new NotificationHandler(this, message)
                .handleNotification();

    }


}
