package utils;

import com.google.android.gms.wallet.WalletConstants;

/**
 * Created by rutvik on 2/21/2017 at 11:21 PM.
 */

public class Constants
{
    public static final String BASE_URL = "http://139.59.44.13/api/";

    public static final String CONTENT_TYPE = "Content-Type";

    public static final String AUTHORIZATION = "Authorization";

    public static final String FLIRTJAR_USER_TOKEN = "FLIRTJAR_USER_TOKEN";

    public static final String CONTENT_TYPE_JSON = "application/json";

    public static final String DEVICE_TYPE = "android";
    public static final int WALLET_ENVIRONMENT = WalletConstants.ENVIRONMENT_TEST;
    public static final String MERCHANT_NAME = "Harikesh Patel";
    public static final String CURRENCY_CODE_USD = "USD";

    public static enum Gender
    {
        MALE("M"), FEMALE("F"), UNSPECIFIED("U");

        final String value;

        Gender(final String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }
    }

}
