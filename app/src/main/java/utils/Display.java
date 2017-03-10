package utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by rutvik on 3/10/2017 at 9:33 AM.
 */

public class Display
{
    public static int calculateNoOfColumns(Context context)
    {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 100);
        return noOfColumns;
    }
}
