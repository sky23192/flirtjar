package apimodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rutvik on 3/7/2017 at 12:19 AM.
 */

public class SendChatMessage
{


    /**
     * user_to : string
     * message_text : string
     * user_from : string
     */

    @SerializedName("user_to")
    private String userTo;
    @SerializedName("message_text")
    private String messageText;
    @SerializedName("user_from")
    private String userFrom;

    public String getUserTo()
    {
        return userTo;
    }

    public void setUserTo(String userTo)
    {
        this.userTo = userTo;
    }

    public String getMessageText()
    {
        return messageText;
    }

    public void setMessageText(String messageText)
    {
        this.messageText = messageText;
    }

    public String getUserFrom()
    {
        return userFrom;
    }

    public void setUserFrom(String userFrom)
    {
        this.userFrom = userFrom;
    }
}
