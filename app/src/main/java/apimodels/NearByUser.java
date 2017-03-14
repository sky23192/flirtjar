package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rutvik on 2/25/2017 at 8:01 PM.
 */

public class NearByUser
{


    /**
     * errors : {}
     * result : [{"id":8,"email":"girl2@gmail.com","first_name":"","last_name":"","profile_picture":"","location":{"type":"Point","coordinates":[70.576171875,22.7197265625]},"status":"","gender":"F"},{"id":7,"email":"girl@gmail.com","first_name":"Girl","last_name":"","profile_picture":"","location":{"type":"Point","coordinates":[71.015625,22.8955078125]},"status":"","gender":"F"},{"id":23,"email":"manisha@gmail.com","first_name":"Manisha","last_name":"Singh","profile_picture":"https://i.mdel.net/i/db/2015/5/387209/387209-500w.jpg","location":{"type":"Point","coordinates":[71.103515625,22.65380859375]},"status":"movie","gender":"F"},{"id":19,"email":"Christiandarvin@gmail.com","first_name":"Darvin","last_name":"christian","profile_picture":"","location":{"type":"Point","coordinates":[71.101522240788,22.547323554754]},"status":"dinner","gender":"M"},{"id":24,"email":"emma@yahoo.com","first_name":"Emma","last_name":"Stone","profile_picture":"http://g02.a.alicdn.com/kf/HTB1PftGIXXXXXb.XpXXq6xXFXXXJ/-font-b-Emma-b-font-font-b-stone-b-font-Actor-Fabric-font-b-Poster.jpg","location":{"type":"Point","coordinates":[71.177673339844,22.832336425781]},"status":"drink","gender":"F"},{"id":20,"email":"mayank@gmail.com","first_name":"Mayank","last_name":"Batra","profile_picture":"","location":{"type":"Point","coordinates":[70.90576171875,22.8076171875]},"status":"walk","gender":"M"},{"id":21,"email":"ridhi@gmail.com","first_name":"Ridhi","last_name":"","profile_picture":"https://elliesblog22.files.wordpress.com/2013/09/doutzen-kroe-1341.jpg?w=600&h=800&crop=1","location":{"type":"Point","coordinates":[70.94970703125,23.6865234375]},"status":"coffee","gender":"F"},{"id":25,"email":"kate@mail.com","first_name":"Kate","last_name":"kate","profile_picture":"http://infocelebz.com/wp-content/uploads/2016/11/408262.jpeg","location":{"type":"Point","coordinates":[71.103515625,22.5439453125]},"status":"long_drive","gender":"F"},{"id":1,"email":"admin@gmail.com","first_name":"","last_name":"","profile_picture":"","location":{"type":"Point","coordinates":[70.990562438965,23.215141296385]},"status":"detour","gender":"M"},{"id":27,"email":"pooja@gmail.com","first_name":"Pooja","last_name":"Yadav","profile_picture":"http://theweddingtiara.com/wp-content/uploads/2013/04/Bianca-Balti-Fashion-Model-Profile-on-New-York-Magazine.jpg","location":{"type":"Point","coordinates":[70.7958984375,22.87353515625]},"status":"dinner","gender":"F"},{"id":28,"email":"kriti@gmail.com","first_name":"Kriti","last_name":"","profile_picture":"http://theweddingtiara.com/wp-content/uploads/2013/04/Bianca-Balti-Fashion-Model-Profile-on-New-York-Magazine.jpg","location":{"type":"Point","coordinates":[70.691528320313,22.670288085938]},"status":"detour","gender":"F"},{"id":29,"email":"ren2344@facebook.com","first_name":"Renu","last_name":"Kumari","profile_picture":"http://theweddingtiara.com/wp-content/uploads/2013/04/Bianca-Balti-Fashion-Model-Profile-on-New-York-Magazine.jpg","location":{"type":"Point","coordinates":[71.010131835938,22.911987304688]},"status":"dinner","gender":"F"},{"id":30,"email":"harsh@gmail.com","first_name":"Harsh","last_name":"Jain","profile_picture":"http://www.heliummagazine.com/wp-content/uploads/2010/06/DanielOrth-699x450.jpg","location":{"type":"Point","coordinates":[70.90576171875,22.8076171875]},"status":"long_drive","gender":"M"},{"id":31,"email":"mrinaldutta1@gmail.com","first_name":"Mrinal","last_name":"Dutta","profile_picture":"https://scontent.famd1-1.fna.fbcdn.net/v/t1.0-1/12814184_1221525704541761_8554614692400182675_n.jpg?oh=8d369e3d8e7997c8cd0164e0454e4a8b&oe=593993F6","location":{"type":"Point","coordinates":[70.806884765625,22.78564453125]},"status":"dinner","gender":"F"},{"id":32,"email":"greedsin19191@gmail.com","first_name":"Jerin","last_name":"Shibu","profile_picture":"https://scontent.famd1-1.fna.fbcdn.net/v/t1.0-9/524490_259593654134088_1845555101_n.jpg?oh=5633e4d1f77de96bcb68a5db4a6d14ea&oe=592861AC","location":{"type":"Point","coordinates":[70.927734375,22.69775390625]},"status":"lunch","gender":"M"},{"id":10,"email":"pratik.lampard@gmail.com","first_name":"Pratik","last_name":"Banerjee","profile_picture":"https://scontent.xx.fbcdn.net/v/t1.0-1/p200x200/13331135_1180985131926047_2302533599598752519_n.jpg?oh=d1d1b89160daa4ec2982142e027ab31d&oe=5900E3BB","location":{"type":"Point","coordinates":[70.893523401999,22.900841735361]},"status":"lunch","gender":"M"},{"id":2,"email":"deepak@gmail.com","first_name":"Deepak","last_name":"Kumar","profile_picture":"https://scontent.famd1-1.fna.fbcdn.net/v/t1.0-9/15977841_1248602075233101_777434784686203872_n.jpg?oh=0bf3cace91de522429b78f00257ad003&oe=5965B7AC","location":{"type":"Point","coordinates":[70.751266479493,23.102359771729]},"status":"coffee","gender":"M"},{"id":33,"email":"mohammad@gmail.com","first_name":"Mohammad","last_name":"Contractor","profile_picture":"https://scontent.famd1-1.fna.fbcdn.net/v/t1.0-9/12814539_984203971667374_2209389616976223249_n.jpg?oh=d6c562ed70858360c104825621906591&oe=596DBEBA","location":{"type":"Point","coordinates":[70.716247558594,22.999877929687]},"status":"walk","gender":"M"}]
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
         * id : 8
         * email : girl2@gmail.com
         * first_name :
         * last_name :
         * profile_picture :
         * location : {"type":"Point","coordinates":[70.576171875,22.7197265625]}
         * status :
         * gender : F
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
             * coordinates : [70.576171875,22.7197265625]
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
