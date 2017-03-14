package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rutvik on 2/26/2017 at 11:46 PM.
 */

public class MatchedProfiles
{

    /**
     * errors : {}
     * result : [{"id":2,"email":"deepak@gmail.com","first_name":"Deepak","last_name":"","profile_picture":"","location":{"type":"Point","coordinates":[70.3564453125,23.203125]},"status":"coffee","gender":"M"},{"id":6,"email":"iosteam2016@gmail.com","first_name":"Narendra","last_name":"Suthar","profile_picture":"https://scontent.xx.fbcdn.net/v/t1.0-1/p200x200/15420854_356748618033308_1961839182452950093_n.jpg?oh=e280b40bf05cef53a4eb346a27b10bbe&oe=590B5F9C","location":{"type":"Point","coordinates":[19.0176147,72.8561644]},"status":"","gender":""},{"id":8,"email":"girl2@gmail.com","first_name":"","last_name":"","profile_picture":"","location":{"type":"Point","coordinates":[70.576171875,22.7197265625]},"status":"","gender":"F"},{"id":10,"email":"pratik.lampard@gmail.com","first_name":"Pratik","last_name":"Banerjee","profile_picture":"https://scontent.xx.fbcdn.net/v/t1.0-1/p200x200/13331135_1180985131926047_2302533599598752519_n.jpg?oh=d1d1b89160daa4ec2982142e027ab31d&oe=5900E3BB","location":{"type":"Point","coordinates":[23.0205985973111,72.51904775953203]},"status":"","gender":""},{"id":3,"email":"ruthvik@gmail.com","first_name":"Ruthvik","last_name":"","profile_picture":"","location":null,"status":"","gender":""},{"id":7,"email":"girl@gmail.com","first_name":"Girl","last_name":"","profile_picture":"","location":{"type":"Point","coordinates":[71.015625,22.8955078125]},"status":"","gender":"F"}]
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
         * id : 2
         * email : deepak@gmail.com
         * first_name : Deepak
         * last_name :
         * profile_picture :
         * location : {"type":"Point","coordinates":[70.3564453125,23.203125]}
         * status : coffee
         * gender : M
         */

        @SerializedName("id")
        private int id;
        @SerializedName("email")
        private String email;
        @SerializedName("first_name")
        private String firstName;
        @SerializedName("last_name")
        private String lastName;
        @SerializedName("profile_picture")
        private String profilePicture;
        @SerializedName("location")
        private LocationBean location;
        @SerializedName("status")
        private String status;
        @SerializedName("gender")
        private String gender;

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

        public String getFirstName()
        {
            return firstName;
        }

        public void setFirstName(String firstName)
        {
            this.firstName = firstName;
        }

        public String getLastName()
        {
            return lastName;
        }

        public void setLastName(String lastName)
        {
            this.lastName = lastName;
        }

        public String getProfilePicture()
        {
            return profilePicture;
        }

        public void setProfilePicture(String profilePicture)
        {
            this.profilePicture = profilePicture;
        }

        public LocationBean getLocation()
        {
            return location;
        }

        public void setLocation(LocationBean location)
        {
            this.location = location;
        }

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }

        public String getGender()
        {
            return gender;
        }

        public void setGender(String gender)
        {
            this.gender = gender;
        }

        public static class LocationBean
        {
            /**
             * type : Point
             * coordinates : [70.3564453125,23.203125]
             */

            @SerializedName("type")
            private String type;
            @SerializedName("coordinates")
            private List<Double> coordinates;

            public String getType()
            {
                return type;
            }

            public void setType(String type)
            {
                this.type = type;
            }

            public List<Double> getCoordinates()
            {
                return coordinates;
            }

            public void setCoordinates(List<Double> coordinates)
            {
                this.coordinates = coordinates;
            }
        }
    }
}
