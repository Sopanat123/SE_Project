package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class UserWebReferenceInfo {

    private static UserWebReferenceInfo userWebReferenceInfo;

    private final String webUsername = "username";
    private final String webPassword = "password";
    private final String webDisplayname = "displayname";
    private final String webFirstname = "firstname";
    private final String webLastname = "lastname";
    private final String webEmail = "email";
    private final String webPhone = "phone";
    private final String webImage = "image";
    private final String webInfo = "info";
    private final String webTag = "usertag";
    private final String webIdCardImage = "idcardimg";
    private final String webIdSelfieImage = "idselfieimg";

    private UserWebReferenceInfo() {
    }

    public static UserWebReferenceInfo getUserWebReferenceInfo() {
        if (userWebReferenceInfo == null) {
            userWebReferenceInfo = new UserWebReferenceInfo();
        }
        return userWebReferenceInfo;
    }

    public String getWebUsername() {
        return webUsername;
    }

    public String getWebPassword() {
        return webPassword;
    }

    public String getWebDisplayname() {
        return webDisplayname;
    }

    public String getWebFirstname() {
        return webFirstname;
    }

    public String getWebLastname() {
        return webLastname;
    }

    public String getWebEmail() {
        return webEmail;
    }

    public String getWebPhone() {
        return webPhone;
    }

    public String getWebImage() {
        return webImage;
    }

    public String getWebInfo() {
        return webInfo;
    }

    public String getWebTag() {
        return webTag;
    }

    public String getWebIdCardImage() {
        return webIdCardImage;
    }

    public String getWebIdSelfieImage() {
        return webIdSelfieImage;
    }

}
