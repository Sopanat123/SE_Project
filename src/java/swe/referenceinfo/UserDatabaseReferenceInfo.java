package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class UserDatabaseReferenceInfo {

    private static UserDatabaseReferenceInfo userDatabaseReferenceInfo;

    // User collection level
    private final String dbColUser = "users";

    // User document level
    private final String dbDocUsername = "username";
    private final String dbDocPassowrd = "password";
    private final String dbDocDisplayname = "displayname";
    private final String dbDocFirstname = "firstname";
    private final String dbDocLastname = "lastname";
    private final String dbDocEmail = "email";
    private final String dbDocPhone = "phone";
    private final String dbDocCreateTime = "create";
    private final String dbDocPrivilege = "privilege";
    private final String dbDocImage = "image";
    private final String dbDocInfo = "info";
    private final String dbDocTag = "tag";

    // Additional for translator
    private final String dbDocIdCard = "idcard";
    private final String dbDocIdSelfie = "idselfie";
    private final String dbDocVerify = "verify";
    private final String dbDocVerifyTime = "verifytime";

    // Default profile image
    private final String dbAttDefProImage = "assets/def_pro_img.png";

    // User privilege value
    private final String dbAttPrivilegeMember = "member";
    private final String dbAttPrivilegeTranslator = "translator";
    private final String dbAttPrivilegeAdmin = "admin";

    // User verification step
    private final String dbAttVerifyNone = "none";
    private final String dbAttVerifyWait = "waiting";
    private final String dbAttVerifySuccess = "success";
    private final String dbAttVerifyReject = "reject";

    private UserDatabaseReferenceInfo() {
    }

    public static UserDatabaseReferenceInfo getUserDatabaseReferenceInfo() {
        if (userDatabaseReferenceInfo == null) {
            userDatabaseReferenceInfo = new UserDatabaseReferenceInfo();
        }
        return userDatabaseReferenceInfo;
    }

    public String getDbColUser() {
        return dbColUser;
    }

    public String getDbDocUsername() {
        return dbDocUsername;
    }

    public String getDbDocPassowrd() {
        return dbDocPassowrd;
    }

    public String getDbDocDisplayname() {
        return dbDocDisplayname;
    }

    public String getDbDocFirstname() {
        return dbDocFirstname;
    }

    public String getDbDocLastname() {
        return dbDocLastname;
    }

    public String getDbDocEmail() {
        return dbDocEmail;
    }

    public String getDbDocPhone() {
        return dbDocPhone;
    }

    public String getDbDocCreateTime() {
        return dbDocCreateTime;
    }

    public String getDbDocPrivilege() {
        return dbDocPrivilege;
    }

    public String getDbDocImage() {
        return dbDocImage;
    }

    public String getDbDocInfo() {
        return dbDocInfo;
    }

    public String getDbDocTag() {
        return dbDocTag;
    }

    public String getDbDocIdCard() {
        return dbDocIdCard;
    }

    public String getDbDocIdSelfie() {
        return dbDocIdSelfie;
    }

    public String getDbDocVerify() {
        return dbDocVerify;
    }

    public String getDbDocVerifyTime() {
        return dbDocVerifyTime;
    }

    public String getDbAttDefProImage() {
        return dbAttDefProImage;
    }

    public String getDbAttPrivilegeMember() {
        return dbAttPrivilegeMember;
    }

    public String getDbAttPrivilegeTranslator() {
        return dbAttPrivilegeTranslator;
    }

    public String getDbAttPrivilegeAdmin() {
        return dbAttPrivilegeAdmin;
    }

    public String getDbAttVerifyNone() {
        return dbAttVerifyNone;
    }

    public String getDbAttVerifyWait() {
        return dbAttVerifyWait;
    }

    public String getDbAttVerifySuccess() {
        return dbAttVerifySuccess;
    }

    public String getDbAttVerifyReject() {
        return dbAttVerifyReject;
    }

}
