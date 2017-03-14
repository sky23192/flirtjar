package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rutvik on 2/26/2017 at 11:16 PM.
 */

public class ReceivedGifts
{

    /**
     * errors : {}
     * result : [{"id":2,"user_from":2,"user_to":1,"gift":{"id":1,"name":"Car","price":10,"icon":"http://139.59.44.13/media/gifts/3.png"}},{"id":1,"user_from":2,"user_to":1,"gift":{"id":1,"name":"Car","price":10,"icon":"http://139.59.44.13/media/gifts/3.png"}}]
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
         * user_from : 2
         * user_to : 1
         * gift : {"id":1,"name":"Car","price":10,"icon":"http://139.59.44.13/media/gifts/3.png"}
         */

        @SerializedName("id")
        private int id;
        @SerializedName("user_from")
        private int userFrom;
        @SerializedName("user_to")
        private int userTo;
        @SerializedName("gift")
        private GiftBean gift;

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public int getUserFrom()
        {
            return userFrom;
        }

        public void setUserFrom(int userFrom)
        {
            this.userFrom = userFrom;
        }

        public int getUserTo()
        {
            return userTo;
        }

        public void setUserTo(int userTo)
        {
            this.userTo = userTo;
        }

        public GiftBean getGift()
        {
            return gift;
        }

        public void setGift(GiftBean gift)
        {
            this.gift = gift;
        }

        public static class GiftBean
        {
            /**
             * id : 1
             * name : Car
             * price : 10
             * icon : http://139.59.44.13/media/gifts/3.png
             */

            @SerializedName("id")
            private int id;
            @SerializedName("name")
            private String name;
            @SerializedName("price")
            private int price;
            @SerializedName("icon")
            private String icon;

            public int getId()
            {
                return id;
            }

            public void setId(int id)
            {
                this.id = id;
            }

            public String getName()
            {
                return name;
            }

            public void setName(String name)
            {
                this.name = name;
            }

            public int getPrice()
            {
                return price;
            }

            public void setPrice(int price)
            {
                this.price = price;
            }

            public String getIcon()
            {
                return icon;
            }

            public void setIcon(String icon)
            {
                this.icon = icon;
            }
        }
    }
}
