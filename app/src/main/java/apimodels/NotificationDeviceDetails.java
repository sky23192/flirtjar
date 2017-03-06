package apimodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rutvik on 3/7/2017 at 12:02 AM.
 */

public class NotificationDeviceDetails
{


    /**
     * registration_id : 054c7c42d7316d9ab30e8d5d328263038f3963c326d19e3d6f6ba48c839ae98f
     * device_type : ios
     */

    @SerializedName("registration_id")
    private String registrationId;
    @SerializedName("device_type")
    private String deviceType;

    public String getRegistrationId()
    {
        return registrationId;
    }

    public void setRegistrationId(String registrationId)
    {
        this.registrationId = registrationId;
    }

    public String getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }
}
