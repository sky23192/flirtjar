package utils;

import android.util.Log;

/**
 * Created by rutvik on 2/13/2017 at 11:10 AM.
 */

public class Logger
{

    static boolean showLogs = true;

    public static void log(String tag, String message)
    {
        if (showLogs)
        {
            Log.i(tag, message);
        }
    }

}
