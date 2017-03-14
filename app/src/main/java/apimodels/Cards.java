package apimodels;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by rutvik on 2/22/2017 at 12:21 AM.
 */

public class Cards
{

    /**
     * errors : {}
     * result : [{"id":24,"rating":10,"language":["English"],"tags":[],"last_login":"2017-03-08T09:40:22Z","email":"emma@yahoo.com","first_name":"Emma","last_name":"Stone","gender":"F","dob":"1986-04-08","phone_no":"94350934523","tagline":"","looking_for":"F","relationship_status":"S","status":"drink","height":5.8,"salary":242930843920,"country":"USA","hair_color":"br","eye_color":"bl","occupation":"Actress","drink":true,"smoking":true,"weed":true,"aquarius":"sa","profile_picture":"http://g02.a.alicdn.com/kf/HTB1PftGIXXXXXb.XpXXq6xXFXXXJ/-font-b-Emma-b-font-font-b-stone-b-font-Actor-Fabric-font-b-Poster.jpg","location":{"type":"Point","coordinates":[71.177673339844,22.832336425781]},"created_date":"2017-03-08T09:44:28.634989Z","modified_date":"2017-03-08T09:44:28.635038Z","likes":9349134,"skipped":5,"superlikes":23422,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true},{"id":23,"rating":9.73,"language":[],"tags":[],"last_login":"2017-03-08T09:37:36Z","email":"manisha@gmail.com","first_name":"Manisha","last_name":"Singh","gender":"F","dob":"2000-05-08","phone_no":"","tagline":"","looking_for":"F","relationship_status":"","status":"movie","height":5.7,"salary":594934,"country":"India","hair_color":"br","eye_color":"bu","occupation":"Manager","drink":false,"smoking":true,"weed":true,"aquarius":"cp","profile_picture":"https://i.mdel.net/i/db/2015/5/387209/387209-500w.jpg","location":{"type":"Point","coordinates":[71.103515625,22.65380859375]},"created_date":"2017-03-08T09:39:25.725934Z","modified_date":"2017-03-08T09:39:25.725962Z","likes":1483,"skipped":55,"superlikes":492,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true},{"id":21,"rating":9.15,"language":["Hindi","ENglish","Gujarati"],"tags":[],"last_login":"2017-03-08T09:28:21Z","email":"ridhi@gmail.com","first_name":"Ridhi","last_name":"","gender":"F","dob":"1994-06-08","phone_no":"473829934124","tagline":"","looking_for":"M","relationship_status":"S","status":"coffee","height":6,"salary":80000,"country":"India","hair_color":"br","eye_color":"bu","occupation":"Designer","drink":true,"smoking":false,"weed":false,"aquarius":"sa","profile_picture":"https://elliesblog22.files.wordpress.com/2013/09/doutzen-kroe-1341.jpg?w=600&h=800&crop=1","location":{"type":"Point","coordinates":[70.94970703125,23.6865234375]},"created_date":"2017-03-08T09:30:16.729333Z","modified_date":"2017-03-08T09:30:16.729363Z","likes":1000,"skipped":100,"superlikes":80,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true},{"id":25,"rating":10,"language":["English","Spanish"],"tags":[],"last_login":"2017-03-08T09:45:28Z","email":"kate@mail.com","first_name":"Kate","last_name":"kate","gender":"F","dob":"1989-05-12","phone_no":"4234","tagline":"","looking_for":"M","relationship_status":"S","status":"long_drive","height":5.6,"salary":500000,"country":"England","hair_color":"br","eye_color":"bu","occupation":"Actress","drink":true,"smoking":false,"weed":false,"aquarius":"vi","profile_picture":"http://infocelebz.com/wp-content/uploads/2016/11/408262.jpeg","location":{"type":"Point","coordinates":[71.103515625,22.5439453125]},"created_date":"2017-03-08T09:47:40.877758Z","modified_date":"2017-03-08T09:47:40.877787Z","likes":1002138,"skipped":324,"superlikes":248324,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true},{"id":7,"rating":10,"language":[],"tags":[],"last_login":null,"email":"girl@gmail.com","first_name":"Girl","last_name":"","gender":"F","dob":"1997-11-11","phone_no":"","tagline":"","looking_for":"","relationship_status":"","status":"","height":null,"salary":null,"country":"","hair_color":"","eye_color":"","occupation":"","drink":null,"smoking":null,"weed":null,"aquarius":"","profile_picture":"","location":{"type":"Point","coordinates":[71.015625,22.8955078125]},"created_date":"2017-02-06T20:40:26.603747Z","modified_date":"2017-02-15T02:03:05.058597Z","likes":1,"skipped":0,"superlikes":0,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true},{"id":29,"rating":9.77,"language":["Hindi"],"tags":["Cool","Naughty"],"last_login":"2017-03-08T09:55:43Z","email":"ren2344@facebook.com","first_name":"Renu","last_name":"Kumari","gender":"F","dob":"1991-05-09","phone_no":"","tagline":"Hi...","looking_for":"F","relationship_status":"S","status":"dinner","height":5.6,"salary":27847324,"country":"India","hair_color":"bl","eye_color":"bl","occupation":"Student","drink":true,"smoking":false,"weed":false,"aquarius":"ge","profile_picture":"http://theweddingtiara.com/wp-content/uploads/2013/04/Bianca-Balti-Fashion-Model-Profile-on-New-York-Magazine.jpg","location":{"type":"Point","coordinates":[71.010131835938,22.911987304688]},"created_date":"2017-03-08T09:57:52.611816Z","modified_date":"2017-03-08T09:57:52.611858Z","likes":10323,"skipped":342,"superlikes":4124,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true},{"id":27,"rating":5.05,"language":["Gujarati"],"tags":[],"last_login":"2017-03-08T09:50:23Z","email":"pooja@gmail.com","first_name":"Pooja","last_name":"Yadav","gender":"F","dob":"1998-07-20","phone_no":"23904190414","tagline":"","looking_for":"M","relationship_status":"m","status":"dinner","height":5.4,"salary":453234,"country":"India","hair_color":"bl","eye_color":"bl","occupation":"Manager","drink":true,"smoking":false,"weed":false,"aquarius":"sc","profile_picture":"http://theweddingtiara.com/wp-content/uploads/2013/04/Bianca-Balti-Fashion-Model-Profile-on-New-York-Magazine.jpg","location":{"type":"Point","coordinates":[70.7958984375,22.87353515625]},"created_date":"2017-03-08T09:52:26.597907Z","modified_date":"2017-03-08T09:52:37.214049Z","likes":100,"skipped":102,"superlikes":4,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true},{"id":31,"rating":7.09,"language":["Hindi","Gujarati","Bangali","English"],"tags":[],"last_login":"2017-03-08T10:01:48Z","email":"mrinaldutta1@gmail.com","first_name":"Mrinal","last_name":"Dutta","gender":"F","dob":"1997-11-14","phone_no":"9510614921","tagline":"","looking_for":"M","relationship_status":"S","status":"dinner","height":5.8,"salary":45435,"country":"India","hair_color":"bl","eye_color":"br","occupation":"Chef","drink":true,"smoking":false,"weed":true,"aquarius":"vi","profile_picture":"https://scontent.famd1-1.fna.fbcdn.net/v/t1.0-1/12814184_1221525704541761_8554614692400182675_n.jpg?oh=8d369e3d8e7997c8cd0164e0454e4a8b&oe=593993F6","location":{"type":"Point","coordinates":[70.806884765625,22.78564453125]},"created_date":"2017-03-08T10:05:32.983648Z","modified_date":"2017-03-08T10:05:32.983689Z","likes":500,"skipped":232,"superlikes":65,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true},{"id":28,"rating":10,"language":["English","Hindi","Marathi"],"tags":["Cool","HOT"],"last_login":"2017-03-08T09:53:01Z","email":"kriti@gmail.com","first_name":"Kriti","last_name":"","gender":"F","dob":"1991-04-05","phone_no":"","tagline":"Cool","looking_for":"M","relationship_status":"S","status":"detour","height":null,"salary":23424324,"country":"India","hair_color":"bl","eye_color":"br","occupation":"Model","drink":true,"smoking":false,"weed":false,"aquarius":"ta","profile_picture":"http://theweddingtiara.com/wp-content/uploads/2013/04/Bianca-Balti-Fashion-Model-Profile-on-New-York-Magazine.jpg","location":{"type":"Point","coordinates":[70.691528320313,22.670288085938]},"created_date":"2017-03-08T09:55:08.100044Z","modified_date":"2017-03-08T09:55:08.100072Z","likes":10032412,"skipped":232,"superlikes":21313,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true},{"id":8,"rating":5,"language":[],"tags":[],"last_login":null,"email":"girl2@gmail.com","first_name":"","last_name":"","gender":"F","dob":"1995-12-18","phone_no":"","tagline":"","looking_for":"","relationship_status":"","status":"","height":null,"salary":null,"country":"","hair_color":"","eye_color":"","occupation":"","drink":null,"smoking":null,"weed":null,"aquarius":"","profile_picture":"","location":{"type":"Point","coordinates":[70.576171875,22.7197265625]},"created_date":"2017-02-06T21:02:52.714033Z","modified_date":"2017-02-06T21:02:52.714065Z","likes":0,"skipped":0,"superlikes":0,"is_instagram_activated":false,"show_me_on_jar":true,"show_me_on_nearby":true}]
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
         * id : 24
         * rating : 10
         * language : ["English"]
         * tags : []
         * last_login : 2017-03-08T09:40:22Z
         * email : emma@yahoo.com
         * first_name : Emma
         * last_name : Stone
         * gender : F
         * dob : 1986-04-08
         * phone_no : 94350934523
         * tagline :
         * looking_for : F
         * relationship_status : S
         * status : drink
         * height : 5.8
         * salary : 242930843920
         * country : USA
         * hair_color : br
         * eye_color : bl
         * occupation : Actress
         * drink : true
         * smoking : true
         * weed : true
         * aquarius : sa
         * profile_picture : http://g02.a.alicdn.com/kf/HTB1PftGIXXXXXb.XpXXq6xXFXXXJ/-font-b-Emma-b-font-font-b-stone-b-font-Actor-Fabric-font-b-Poster.jpg
         * location : {"type":"Point","coordinates":[71.177673339844,22.832336425781]}
         * created_date : 2017-03-08T09:44:28.634989Z
         * modified_date : 2017-03-08T09:44:28.635038Z
         * likes : 9349134
         * skipped : 5
         * superlikes : 23422
         * is_instagram_activated : false
         * show_me_on_jar : true
         * show_me_on_nearby : true
         */

        @SerializedName("id")
        private int id;
        @SerializedName("rating")
        private double rating;
        @SerializedName("last_login")
        private String lastLogin;
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
        private double height;
        @SerializedName("salary")
        private long salary;
        @SerializedName("country")
        private String country;
        @SerializedName("hair_color")
        private String hairColor;
        @SerializedName("eye_color")
        private String eyeColor;
        @SerializedName("occupation")
        private String occupation;
        @SerializedName("drink")
        private boolean drink;
        @SerializedName("smoking")
        private boolean smoking;
        @SerializedName("weed")
        private boolean weed;
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
        private List<String> language;
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

        public double getRating()
        {
            return rating;
        }

        public void setRating(double rating)
        {
            this.rating = rating;
        }

        public String getLastLogin()
        {
            return lastLogin;
        }

        public void setLastLogin(String lastLogin)
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

        public String getAge()
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            try
            {
                Date d = sdf.parse(getDob());
                GregorianCalendar birth = new GregorianCalendar();
                birth.setTime(d);
                int month = birth.get(GregorianCalendar.MONTH);
                int day = birth.get(GregorianCalendar.DAY_OF_MONTH);

                GregorianCalendar now = new GregorianCalendar();

                int age = now.get(GregorianCalendar.YEAR) - birth.get(GregorianCalendar.YEAR);

                int birthMonth = birth.get(GregorianCalendar.MONTH);
                int birthDay = birth.get(GregorianCalendar.DAY_OF_MONTH);
                int nowMonth = now.get(GregorianCalendar.MONTH);
                int nowDay = now.get(GregorianCalendar.DAY_OF_MONTH);

                if (nowMonth > birthMonth)
                {
                    age = age + 1;
                } else
                {
                    if (nowMonth == birthMonth)
                    {
                        if (nowDay >= birthDay)
                        {
                            age = age + 1;
                        }
                    }
                }
                return age + "";
            } catch (ParseException e)
            {
                e.printStackTrace();
            }

            return "";

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

        public double getHeight()
        {
            return height;
        }

        public void setHeight(double height)
        {
            this.height = height;
        }

        public long getSalary()
        {
            return salary;
        }

        public void setSalary(long salary)
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

        public boolean isDrink()
        {
            return drink;
        }

        public void setDrink(boolean drink)
        {
            this.drink = drink;
        }

        public boolean isSmoking()
        {
            return smoking;
        }

        public void setSmoking(boolean smoking)
        {
            this.smoking = smoking;
        }

        public boolean isWeed()
        {
            return weed;
        }

        public void setWeed(boolean weed)
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

        public List<String> getLanguage()
        {
            return language;
        }

        public void setLanguage(List<String> language)
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
             * coordinates : [71.177673339844,22.832336425781]
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
