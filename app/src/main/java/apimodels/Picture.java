package apimodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rutvik on 2/26/2017 at 11:58 PM.
 */

public class Picture
{

    /**
     * image : string
     */

    @SerializedName("image")
    private String image;

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }
}
