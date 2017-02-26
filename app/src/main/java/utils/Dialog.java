package utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by rutvik on 2/21/2017 at 11:03 PM.
 */

public class Dialog
{

    private static ProgressDialog progressDialog;

    public static void showLoadingDialog(Context context, String title, String msg, boolean cancellable,
                                         boolean cancellableOnTouchOutside, DialogInterface.OnCancelListener onCancelListener)
    {
        if (progressDialog != null)
        {
            if (progressDialog.isShowing())
            {
                progressDialog.dismiss();
            }
            progressDialog = null;
        }

        progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle(title);
        progressDialog.setMessage(msg);
        progressDialog.setCanceledOnTouchOutside(cancellableOnTouchOutside);
        if (cancellable)
        {
            progressDialog.setOnCancelListener(onCancelListener);
        }
        progressDialog.show();

    }

    public static void hideLoadingDialog()
    {
        if (progressDialog != null)
        {
            if (progressDialog.isShowing())
            {
                progressDialog.dismiss();
            }
            progressDialog = null;
        }
    }

}
