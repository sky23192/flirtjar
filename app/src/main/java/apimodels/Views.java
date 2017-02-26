package apimodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rutvik on 2/27/2017 at 12:02 AM.
 */

public class Views
{

    /**
     * errors : {}
     * result : {"pk":1,"likes":1,"superlikes":0,"skipped":0}
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
         * pk : 1
         * likes : 1
         * superlikes : 0
         * skipped : 0
         */

        @SerializedName("pk")
        private int pk;
        @SerializedName("likes")
        private int likes;
        @SerializedName("superlikes")
        private int superlikes;
        @SerializedName("skipped")
        private int skipped;

        public int getPk()
        {
            return pk;
        }

        public void setPk(int pk)
        {
            this.pk = pk;
        }

        public int getLikes()
        {
            return likes;
        }

        public void setLikes(int likes)
        {
            this.likes = likes;
        }

        public int getSuperlikes()
        {
            return superlikes;
        }

        public void setSuperlikes(int superlikes)
        {
            this.superlikes = superlikes;
        }

        public int getSkipped()
        {
            return skipped;
        }

        public void setSkipped(int skipped)
        {
            this.skipped = skipped;
        }
    }
}
