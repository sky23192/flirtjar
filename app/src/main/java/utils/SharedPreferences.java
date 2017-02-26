package utils;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by rutvik on 2/22/2017 at 9:16 AM.
 */

public class SharedPreferences
{

    public static String getFlirtjarUserToken(Context context)
    {
        final String token = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(Constants.FLIRTJAR_USER_TOKEN, null);
        if (token == null)
        {
            return null;
        } else
        {
            return "Token " + token;
        }
    }

}
