package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rutvik on 2/22/2017 at 12:21 AM.
 */

public class Cards
{


    /**
     * errors : {}
     * result : [{"id":7,"rating":10,"language":[],"tags":[],"last_login":null,"email":"girl@gmail.com","first_name":"Girl","last_name":"","gender":"F","dob":"1997-11-11","phone_no":"","tagline":"","looking_for":"","relationship_status":"","status":"","height":null,"salary":null,"country":"","hair_color":"","eye_color":"","occupation":"","drink":null,"smoking":null,"weed":null,"aquarius":"","profile_picture":"","location":{"type":"Point","coordinates":[71.015625,22.8955078125]},"created_date":"2017-02-06T20:40:26.603747Z","modified_date":"2017-02-15T02:03:05.058597Z","likes":1,"skipped":0,"superlikes":0,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true},{"id":8,"rating":5,"language":[],"tags":[],"last_login":null,"email":"girl2@gmail.com","first_name":"","last_name":"","gender":"F","dob":"1995-12-18","phone_no":"","tagline":"","looking_for":"","relationship_status":"","status":"","height":null,"salary":null,"country":"","hair_color":"","eye_color":"","occupation":"","drink":null,"smoking":null,"weed":null,"aquarius":"","profile_picture":"","location":{"type":"Point","coordinates":[70.576171875,22.7197265625]},"created_date":"2017-02-06T21:02:52.714033Z","modified_date":"2017-02-06T21:02:52.714065Z","likes":0,"skipped":0,"superlikes":0,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true}]
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
         * id : 7
         * rating : 10
         * language : []
         * tags : []
         * last_login : null
         * email : girl@gmail.com
         * first_name : Girl
         * last_name :
         * gender : F
         * dob : 1997-11-11
         * phone_no :
         * tagline :
         * looking_for :
         * relationship_status :
         * status :
         * height : null
         * salary : null
         * country :
         * hair_color :
         * eye_color :
         * occupation :
         * drink : null
         * smoking : null
         * weed : null
         * aquarius :
         * profile_picture :
         * location : {"type":"Point","coordinates":[71.015625,22.8955078125]}
         * created_date : 2017-02-06T20:40:26.603747Z
         * modified_date : 2017-02-15T02:03:05.058597Z
         * likes : 1
         * skipped : 0
         * superlikes : 0
         * is_instagram_activated : false
         * show_me_on_jar : true
         * show_me_on_nearby : true
         */

        @SerializedName("id")
        private int id;
        @SerializedName("rating")
        private int rating;
        @SerializedName("last_login")
        private Object lastLogin;
        @SerializedName("email")
        private String email;
        @SerializedName("first_name")
        private String firstName;
        @SerializedName("last_name")
        private String lastName;
        @SerializedName("gender")
        private String gender;
        @SerializedName("dob")
        private String dob;
        @SerializedName("phone_no")
        private String phoneNo;
        @SerializedName("tagline")
        private String tagline;
        @SerializedName("looking_for")
        private String lookingFor;
        @SerializedName("relationship_status")
        private String relationshipStatus;
        @SerializedName("status")
        private String status;
        @SerializedName("height")
        private Object height;
        @SerializedName("salary")
        private Object salary;
        @SerializedName("country")
        private String country;
        @SerializedName("hair_color")
        private String hairColor;
        @SerializedName("eye_color")
        private String eyeColor;
        @SerializedName("occupation")
        private String occupation;
        @SerializedName("drink")
        private Object drink;
        @SerializedName("smoking")
        private Object smoking;
        @SerializedName("weed")
        private Object weed;
        @SerializedName("aquarius")
        private String aquarius;
        @SerializedName("profile_picture")
        private String profilePicture;
        @SerializedName("location")
        private LocationBean location;
        @SerializedName("created_date")
        private String createdDate;
        @SerializedName("modified_date")
        private String modifiedDate;
        @SerializedName("likes")
        private int likes;
        @SerializedName("skipped")
        private int skipped;
        @SerializedName("superlikes")
        private int superlikes;
        @SerializedName("is_instagram_activated")
        private boolean isInstagramActivated;
        @SerializedName("show_me_on_jar")
        private boolean showMeOnJar;
        @SerializedName("show_me_on_nearby")
        private boolean showMeOnNearby;
        @SerializedName("language")
        private List<?> language;
        @SerializedName("tags")
        private List<?> tags;

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public int getRating()
        {
            return rating;
        }

        public void setRating(int rating)
        {
            this.rating = rating;
        }

        public Object getLastLogin()
        {
            return lastLogin;
        }

        public void setLastLogin(Object lastLogin)
        {
            this.lastLogin = lastLogin;
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

        public String getGender()
        {
            return gender;
        }

        public void setGender(String gender)
        {
            this.gender = gender;
        }

        public String getDob()
        {
            return dob;
        }

        public void setDob(String dob)
        {
            this.dob = dob;
        }

        public String getPhoneNo()
        {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo)
        {
            this.phoneNo = phoneNo;
        }

        public String getTagline()
        {
            return tagline;
        }

        public void setTagline(String tagline)
        {
            this.tagline = tagline;
        }

        public String getLookingFor()
        {
            return lookingFor;
        }

        public void setLookingFor(String lookingFor)
        {
            this.lookingFor = lookingFor;
        }

        public String getRelationshipStatus()
        {
            return relationshipStatus;
        }

        public void setRelationshipStatus(String relationshipStatus)
        {
            this.relationshipStatus = relationshipStatus;
        }

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }

        public Object getHeight()
        {
            return height;
        }

        public void setHeight(Object height)
        {
            this.height = height;
        }

        public Object getSalary()
        {
            return salary;
        }

        public void setSalary(Object salary)
        {
            this.salary = salary;
        }

        public String getCountry()
        {
            return country;
        }

        public void setCountry(String country)
        {
            this.country = country;
        }

        public String getHairColor()
        {
            return hairColor;
        }

        public void setHairColor(String hairColor)
        {
            this.hairColor = hairColor;
        }

        public String getEyeColor()
        {
            return eyeColor;
        }

        public void setEyeColor(String eyeColor)
        {
            this.eyeColor = eyeColor;
        }

        public String getOccupation()
        {
            return occupation;
        }

        public void setOccupation(String occupation)
        {
            this.occupation = occupation;
        }

        public Object getDrink()
        {
            return drink;
        }

        public void setDrink(Object drink)
        {
            this.drink = drink;
        }

        public Object getSmoking()
        {
            return smoking;
        }

        public void setSmoking(Object smoking)
        {
            this.smoking = smoking;
        }

        public Object getWeed()
        {
            return weed;
        }

        public void setWeed(Object weed)
        {
            this.weed = weed;
        }

        public String getAquarius()
        {
            return aquarius;
        }

        public void setAquarius(String aquarius)
        {
            this.aquarius = aquarius;
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

        public String getCreatedDate()
        {
            return createdDate;
        }

        public void setCreatedDate(String createdDate)
        {
            this.createdDate = createdDate;
        }

        public String getModifiedDate()
        {
            return modifiedDate;
        }

        public void setModifiedDate(String modifiedDate)
        {
            this.modifiedDate = modifiedDate;
        }

        public int getLikes()
        {
            return likes;
        }

        public void setLikes(int likes)
        {
            this.likes = likes;
        }

        public int getSkipped()
        {
            return skipped;
        }

        public void setSkipped(int skipped)
        {
            this.skipped = skipped;
        }

        public int getSuperlikes()
        {
            return superlikes;
        }

        public void setSuperlikes(int superlikes)
        {
            this.superlikes = superlikes;
        }

        public boolean isIsInstagramActivated()
        {
            return isInstagramActivated;
        }

        public void setIsInstagramActivated(boolean isInstagramActivated)
        {
            this.isInstagramActivated = isInstagramActivated;
        }

        public boolean isShowMeOnJar()
        {
            return showMeOnJar;
        }

        public void setShowMeOnJar(boolean showMeOnJar)
        {
            this.showMeOnJar = showMeOnJar;
        }

        public boolean isShowMeOnNearby()
        {
            return showMeOnNearby;
        }

        public void setShowMeOnNearby(boolean showMeOnNearby)
        {
            this.showMeOnNearby = showMeOnNearby;
        }

        public List<?> getLanguage()
        {
            return language;
        }

        public void setLanguage(List<?> language)
        {
            this.language = language;
        }

        public List<?> getTags()
        {
            return tags;
        }

        public void setTags(List<?> tags)
        {
            this.tags = tags;
        }

        public static class LocationBean
        {
            /**
             * type : Point
             * coordinates : [71.015625,22.8955078125]
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
