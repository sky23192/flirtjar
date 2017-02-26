package apimodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rutvik on 1/22/2017 at 11:52 PM.
 */

public class CreatedUser
{


    /**
     * errors : {}
     * result : {"Token":"6d4f0bd0e4627444eb38fb4c652e0304f9375e9d","id":12,"email":""}
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
         * Token : 6d4f0bd0e4627444eb38fb4c652e0304f9375e9d
         * id : 12
         * email :
         */

        @SerializedName("Token")
        private String Token;
        @SerializedName("id")
        private int id;
        @SerializedName("email")
        private String email;

        public String getToken()
        {
            return Token;
        }

        public void setToken(String Token)
        {
            this.Token = Token;
        }

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getEmail()
        {
            return email;
        }

        public void setEmail(String email)
        {
            this.email = email;
        }
    }
}
