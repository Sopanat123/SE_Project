package se;

/**
 * <p>
 * Store all commonly use variable's name in Application. It is important that
 * all file should reference to common object by name store at this place, so
 * changes can be apply easier and applied to whole application. </p>
 *
 * <p>
 * <code>TAG</code> and <code>PAGE_JSP</code> must not be included as it must
 * implement on specific related element </p>
 *
 * @author Ben
 */
public final class Variable {

    // Application scope
    public static final String APP_DB_NAME = "db";
    public static final String APP_DB_BUCKET = "bk";

    // DB collection name
//    public static final String DB_COL_WORK = "works";
    public static final String DB_COL_USER = "users";

    // DB collection 'users', document values
    public static final String DB_DOC_USER_USERNAME = "username";
    public static final String DB_DOC_USER_PASSWORD = "password";
    public static final String DB_DOC_USER_DISPLAYNAME = "displayname";
    public static final String DB_DOC_USER_FIRSTNAME = "firstname";
    public static final String DB_DOC_USER_LASTNAME = "lastname";
    public static final String DB_DOC_USER_EMAIL = "email";
    public static final String DB_DOC_USER_PHONE = "phone";
    public static final String DB_DOC_USER_CREATE_TIME = "create";
    public static final String DB_DOC_USER_PRIVILEGE = "privilege";
    public static final String DB_DOC_USER_IMAGE = "image";
    public static final String DB_DOC_USER_INFO = "info";
    public static final String DB_DOC_USER_TAG = "tag";
    public static final String DB_DOC_USER_ID_IMAGE = "idcard";
    public static final String DB_DOC_USER_ID_SELFIE = "idselfie";

    // Usally carry error message in request scope
    public static final String MESSAGE = "msg";

    // Url for call servlet page to forward to associate jsp page
    public static final String PAGE_SIGN_IN = "signin";
//    public static final String PAGE_SIGN_UP = "signup";
    public static final String PAGE_SIGN_OUT = "signout";
    public static final String PAGE_HOME = "home";
    public static final String PAGE_USER_PROFILE = "user";
    public static final String PAGE_USER_EDIT_PROFILE = "editprofile";

    // Session scope
    public static final String SES_CURRENT_USER = "cruser";

    //  Web parameter name
    public static final String WEB_USERNAME = "username";
    public static final String WEB_PASSWORD = "password";
    public static final String WEB_DISPLAYNAME = "displayname";
    public static final String WEB_FIRSTNAME = "firstname";
    public static final String WEB_LASTNAME = "lastname";
    public static final String WEB_EMAIL = "email";
    public static final String WEB_PHONE = "phone";
}
