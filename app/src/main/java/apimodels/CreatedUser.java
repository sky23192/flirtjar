package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rutvik on 1/22/2017 at 11:52 PM.
 */

public class CreatedUser
{


    /**
     * errors : ["drink : [u'\"string\" is not a valid boolean.']","relationship_status : [u'\"string\" is not a valid choice.']","language : [u'Expected a list of items but got type \"unicode\".']","tags : [u'Expected a list of items but got type \"unicode\".']","dob : [u'Date has wrong format. Use one of these formats instead: YYYY[-MM[-DD]].']","gender : [u'\"string\" is not a valid choice.']","aquarius : [u'\"string\" is not a valid choice.']","hair_color : [u'\"string\" is not a valid choice.']","weed : [u'\"string\" is not a valid boolean.']","eye_color : [u'\"string\" is not a valid choice.']","last_login : [u'Datetime has wrong format. Use one of these formats instead: YYYY-MM-DDThh:mm[:ss[.uuuuuu]][+HH:MM|-HH:MM|Z].']","location : [u'Invalid format: string or unicode input unrecognized as GeoJSON, WKT EWKT or HEXEWKB.']","smoking : [u'\"string\" is not a valid boolean.']","looking_for : [u'\"string\" is not a valid choice.']","email : [u'Enter a valid email address.']"]
     * result : {"id":20,"email":"example@gmail.com","Token":"g56uy234jhnf83487i723h"}
     */

    @SerializedName("result")
    private ResultBean result;
    @SerializedName("errors")
    private List<String> errors;

    public ResultBean getResult()
    {
        return result;
    }

    public void setResult(ResultBean result)
    {
        this.result = result;
    }

    public List<String> getErrors()
    {
        return errors;
    }

    public void setErrors(List<String> errors)
    {
        this.errors = errors;
    }

    public static class ResultBean
    {
        /**
         * id : 20
         * email : example@gmail.com
         * Token : g56uy234jhnf83487i723h
         */

        @SerializedName("id")
        private int id;
        @SerializedName("email")
        private String email;
        @SerializedName("Token")
        private String Token;

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

        public String getToken()
        {
            return Token;
        }

        public void setToken(String Token)
        {
            this.Token = Token;
        }
    }
}
