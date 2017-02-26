package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rutvik on 2/26/2017 at 11:55 PM.
 */

public class OtherPictures
{

    /**
     * errors : {}
     * result : [{"id":1,"image":"https://storage.googleapis.com/gweb-uniblog-publish-prod/static/blog/images/google-200x200.7714256da16f.png"},{"id":2,"image":"https://www.hdmarketing.ca/dynamique/images/google(2).jpg"},{"id":3,"image":"https://storage.googleapis.com/gweb-uniblog-publish-prod/static/blog/images/google-200x200.7714256da16f.png"},{"id":4,"image":"https://www.hdmarketing.ca/dynamique/images/google(2).jpg"},{"id":5,"image":"https://storage.googleapis.com/gweb-uniblog-publish-prod/static/blog/images/google-200x200.7714256da16f.png"},{"id":6,"image":"string"}]
     */

    @SerializedName("errors")
    private ErrorsBean errors;
    @SerializedName("result")
    private List<ResultBean> result;

    public ErrorsBean getErrors()
    {
        return errors;
    }

    public void setErrors(ErrorsBean errors)
    {
        this.errors = errors;
    }

    public List<ResultBean> getResult()
    {
        return result;
    }

    public void setResult(List<ResultBean> result)
    {
        this.result = result;
    }

    public static class ErrorsBean
    {
    }

    public static class ResultBean
    {
        /**
         * id : 1
         * image : https://storage.googleapis.com/gweb-uniblog-publish-prod/static/blog/images/google-200x200.7714256da16f.png
         */

        @SerializedName("id")
        private int id;
        @SerializedName("image")
        private String image;

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getImage()
        {
            return image;
        }

        public void setImage(String image)
        {
            this.image = image;
        }
    }
}
