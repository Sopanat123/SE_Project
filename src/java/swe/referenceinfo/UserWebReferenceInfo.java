package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class UserWebReferenceInfo {

    private static UserWebReferenceInfo userWebReferenceInfo;

    private final String username = "username";
    private final String password = "password";
    private final String displayname = "displayname";
    private final String firstname = "firstname";
    private final String lastname = "lastname";
    private final String email = "email";
    private final String phone = "phone";
    private final String image = "image";
    private final String info = "info";
    private final String tag = "usertag";
    private final String idCardImage = "idcardimg";
    private final String idSelfieImage = "idselfieimg";

    private UserWebReferenceInfo() {
    }

    public static UserWebReferenceInfo getUserWebReferenceInfo() {
        if (userWebReferenceInfo == null) {
            userWebReferenceInfo = new UserWebReferenceInfo();
        }
        return userWebReferenceInfo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getImage() {
        return image;
    }

    public String getInfo() {
        return info;
    }

    public String getTag() {
        return tag;
    }

    public String getIdCardImage() {
        return idCardImage;
    }

    public String getIdSelfieImage() {
        return idSelfieImage;
    }

}
