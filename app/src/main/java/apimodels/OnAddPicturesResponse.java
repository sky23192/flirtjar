package apimodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rutvik on 2/27/2017 at 12:00 AM.
 */

public class OnAddPicturesResponse
{

    /**
     * errors : {}
     * result : {"data":"saved"}
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
         * data : saved
         */

        @SerializedName("data")
        private String data;

        public String getData()
        {
            return data;
        }

        public void setData(String data)
        {
            this.data = data;
        }
    }
}
