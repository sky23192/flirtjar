package apimodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rutvik on 2/26/2017 at 11:07 PM.
 */

public class Coins
{

    /**
     * errors : {}
     * result : {"user":1,"coins":2}
     */

    @SerializedName("errors")
    private ErrorsBean errors;
    @SerializedName("result")
    private ResultBean result;

    public ErrorsBean getErrors()
    {
        return errors;
    }

    public void setErrors(ErrorsBean errors)
    {
        this.errors = errors;
    }

    public ResultBean getResult()
    {
        return result;
    }

    public void setResult(ResultBean result)
    {
        this.result = result;
    }

    public static class ErrorsBean
    {
    }

    public static class ResultBean
    {
        /**
         * user : 1
         * coins : 2
         */

        @SerializedName("user")
        private int user;
        @SerializedName("coins")
        private int coins;

        public int getUser()
        {
            return user;
        }

        public void setUser(int user)
        {
            this.user = user;
        }

        public int getCoins()
        {
            return coins;
        }

        public void setCoins(int coins)
        {
            this.coins = coins;
        }
    }
}
