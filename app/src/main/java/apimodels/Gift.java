package apimodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rutvik on 2/26/2017 at 9:07 AM.
 */

public class Gift
{


    /**
     * errors : {}
     * result : [{"id":1,"name":"Car","price":10,"icon":"http://139.59.44.13/media/gifts/3.png"},{"id":2,"name":"kitty","price":10,"icon":"http://139.59.44.13/media/gifts/kitty.png"},{"id":3,"name":"cake 1","price":3,"icon":"http://139.59.44.13/media/gifts/5e5d032d5068f312df9df406d2b17df3.png"},{"id":4,"name":"cake 2","price":5,"icon":"http://139.59.44.13/media/gifts/495ede96.png"},{"id":5,"name":"dog 1","price":2,"icon":"http://139.59.44.13/media/gifts/dog-einstein-icon.png"},{"id":6,"name":"dog 2","price":3,"icon":"http://139.59.44.13/media/gifts/dog-labrador-icon.png"},{"id":7,"name":"dog 3","price":5,"icon":"http://139.59.44.13/media/gifts/Dog_1.png"},{"id":8,"name":"dog 4","price":10,"icon":"http://139.59.44.13/media/gifts/dog-einstein-icon_ttQgdKX.png"}]
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
