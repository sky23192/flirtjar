package apimodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rutvik on 2/26/2017 at 11:30 PM.
 */

public class SendGift
{

    /**
     * errors : {}
     * result : {"user_from":2,"user_to":1,"gift":1}
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
         * user_from : 2
         * user_to : 1
         * gift : 1
         */

        @SerializedName("user_from")
        private int userFrom;
        @SerializedName("user_to")
        private int userTo;
        @SerializedName("gift")
        private int gift;

        public int getUserFrom()
        {
            return userFrom;
        }

        public void setUserFrom(int userFrom)
        {
            this.userFrom = userFrom;
        }

        public int getUserTo()
        {
            return userTo;
        }

        public void setUserTo(int userTo)
        {
            this.userTo = userTo;
        }

        public int getGift()
        {
            return gift;
        }

        public void setGift(int gift)
        {
            this.gift = gift;
        }
    }
}
