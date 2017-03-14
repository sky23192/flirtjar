package utils;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by rutvik on 3/9/2017 at 12:00 AM.
 */

public class RetroParser
{

    public static void parseAndShowErrors(final Context context, final String errorBodyString)
    {
        try
        {
            JSONObject jObjError = new JSONObject(errorBodyString);
            JSONArray arr = jObjError.getJSONArray("errors");
            for (int i = 0; i < arr.length(); i++)
            {
                Toast.makeText(context, arr.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
