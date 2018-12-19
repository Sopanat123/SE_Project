package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class UserDatabaseReferenceInfo {

    private static UserDatabaseReferenceInfo userDatabaseReferenceInfo;

    // User collection level
    private final String colUser = "users";

    // User document level
    private final String docUsername = "username";
    private final String docPassowrd = "password";
    private final String docDisplayname = "displayname";
    private final String docFirstname = "firstname";
    private final String docLastname = "lastname";
    private final String docEmail = "email";
    private final String docPhone = "phone";
    private final String docCreateTime = "create";
    private final String docPrivilege = "privilege";
    private final String docImage = "image";
    private final String docInfo = "info";
    private final String docTag = "tag";

    // Additional for translator
    private final String docIdCard = "idcard";
    private final String docIdSelfie = "idselfie";
    private final String docVerify = "verify";
    private final String docVerifyTime = "verifytime";

    // Default profile image
    private final String attDefProImage = "assets/def_pro_img.png";

    // User privilege value
    private final String attPrivilegeMember = "member";
    private final String attPrivilegeTranslator = "translator";
    private final String attPrivilegeAdmin = "admin";

    // User verification step
    private final String attVerifyNone = "none";
    private final String attVerifyWait = "waiting";
    private final String attVerifySuccess = "success";
    private final String attVerifyReject = "reject";

    private UserDatabaseReferenceInfo() {
    }

    public static UserDatabaseReferenceInfo getUserDatabaseReferenceInfo() {
        if (userDatabaseReferenceInfo == null) {
            userDatabaseReferenceInfo = new UserDatabaseReferenceInfo();
        }
        return userDatabaseReferenceInfo;
    }

    public String getColUser() {
        return colUser;
    }

    public String getDocUsername() {
        return docUsername;
    }

    public String getDocPassowrd() {
        return docPassowrd;
    }

    public String getDocDisplayname() {
        return docDisplayname;
    }

    public String getDocFirstname() {
        return docFirstname;
    }

    public String getDocLastname() {
        return docLastname;
    }

    public String getDocEmail() {
        return docEmail;
    }

    public String getDocPhone() {
        return docPhone;
    }

    public String getDocCreateTime() {
        return docCreateTime;
    }

    public String getDocPrivilege() {
        return docPrivilege;
    }

    public String getDocImage() {
        return docImage;
    }

    public String getDocInfo() {
        return docInfo;
    }

    public String getDocTag() {
        return docTag;
    }

    public String getDocIdCard() {
        return docIdCard;
    }

    public String getDocIdSelfie() {
        return docIdSelfie;
    }

    public String getDocVerify() {
        return docVerify;
    }

    public String getDocVerifyTime() {
        return docVerifyTime;
    }

    public String getAttDefProImage() {
        return attDefProImage;
    }

    public String getAttPrivilegeMember() {
        return attPrivilegeMember;
    }

    public String getAttPrivilegeTranslator() {
        return attPrivilegeTranslator;
    }

    public String getAttPrivilegeAdmin() {
        return attPrivilegeAdmin;
    }

    public String getAttVerifyNone() {
        return attVerifyNone;
    }

    public String getAttVerifyWait() {
        return attVerifyWait;
    }

    public String getAttVerifySuccess() {
        return attVerifySuccess;
    }

    public String getAttVerifyReject() {
        return attVerifyReject;
    }

}
