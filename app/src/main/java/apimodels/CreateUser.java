package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rutvik on 1/22/2017 at 11:47 PM.
 */

public class CreateUser
{

    /**
     * last_name : string
     * relationship_status : string
     * hair_color : string
     * height : 0
     * skipped : 0
     * likes : 0
     * looking_for : string
     * occupation : string
     * first_name : string
     * tagline : string
     * last_login : string
     * location : {"type":"Point","coordinates":[72.52571982,23.03117357]}
     * email : string
     * status : string
     * aquarius : string
     * tags : string
     * drink : string
     * weed : string
     * eye_color : string
     * profile_picture : string
     * smoking : string
     * salary : 0
     * language : string
     * dob : string
     * gender : string
     * superlikes : 0
     * phone_no : string
     * country : string
     * oauth_id : string
     */

    @SerializedName("last_name")
    private String lastName;
    @SerializedName("relationship_status")
    private String relationshipStatus;
    @SerializedName("hair_color")
    private String hairColor;
    @SerializedName("height")
    private int height;
    @SerializedName("skipped")
    private int skipped;
    @SerializedName("likes")
    private int likes;
    @SerializedName("looking_for")
    private String lookingFor;
    @SerializedName("occupation")
    private String occupation;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("last_login")
    private String lastLogin;
    @SerializedName("location")
    private LocationBean location;
    @SerializedName("email")
    private String email;
    @SerializedName("status")
    private String status;
    @SerializedName("aquarius")
    private String aquarius;
    @SerializedName("tags")
    private String tags;
    @SerializedName("drink")
    private String drink;
    @SerializedName("weed")
    private String weed;
    @SerializedName("eye_color")
    private String eyeColor;
    @SerializedName("profile_picture")
    private String profilePicture;
    @SerializedName("smoking")
    private String smoking;
    @SerializedName("salary")
    private int salary;
    @SerializedName("language")
    private String language;
    @SerializedName("dob")
    private String dob;
    @SerializedName("gender")
    private String gender;
    @SerializedName("superlikes")
    private int superlikes;
    @SerializedName("phone_no")
    private String phoneNo;
    @SerializedName("country")
    private String country;
    @SerializedName("oauth_id")
    private String oauthId;

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getRelationshipStatus()
    {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus)
    {
        this.relationshipStatus = relationshipStatus;
    }

    public String getHairColor()
    {
        return hairColor;
    }

    public void setHairColor(String hairColor)
    {
        this.hairColor = hairColor;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getSkipped()
    {
        return skipped;
    }

    public void setSkipped(int skipped)
    {
        this.skipped = skipped;
    }

    public int getLikes()
    {
        return likes;
    }

    public void setLikes(int likes)
    {
        this.likes = likes;
    }

    public String getLookingFor()
    {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor)
    {
        this.lookingFor = lookingFor;
    }

    public String getOccupation()
    {
        return occupation;
    }

    public void setOccupation(String occupation)
    {
        this.occupation = occupation;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getTagline()
    {
        return tagline;
    }

    public void setTagline(String tagline)
    {
        this.tagline = tagline;
    }

    public String getLastLogin()
    {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin)
    {
        this.lastLogin = lastLogin;
    }

    public LocationBean getLocation()
    {
        return location;
    }

    public void setLocation(LocationBean location)
    {
        this.location = location;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getAquarius()
    {
        return aquarius;
    }

    public void setAquarius(String aquarius)
    {
        this.aquarius = aquarius;
    }

    public String getTags()
    {
        return tags;
    }

    public void setTags(String tags)
    {
        this.tags = tags;
    }

    public String getDrink()
    {
        return drink;
    }

    public void setDrink(String drink)
    {
        this.drink = drink;
    }

    public String getWeed()
    {
        return weed;
    }

    public void setWeed(String weed)
    {
        this.weed = weed;
    }

    public String getEyeColor()
    {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor)
    {
        this.eyeColor = eyeColor;
    }

    public String getProfilePicture()
    {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture)
    {
        this.profilePicture = profilePicture;
    }

    public String getSmoking()
    {
        return smoking;
    }

    public void setSmoking(String smoking)
    {
        this.smoking = smoking;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public int getSuperlikes()
    {
        return superlikes;
    }

    public void setSuperlikes(int superlikes)
    {
        this.superlikes = superlikes;
    }

    public String getPhoneNo()
    {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getOauthId()
    {
        return oauthId;
    }

    public void setOauthId(String oauthId)
    {
        this.oauthId = oauthId;
    }

    public static class LocationBean
    {
        /**
         * type : Point
         * coordinates : [72.52571982,23.03117357]
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
