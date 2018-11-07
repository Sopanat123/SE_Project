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

    // Link to Google Cloud Store (GCS)
    public static final String LINK_GCS = "https://storage.googleapis.com/se-project-db.appspot.com/";
    public static final String LINK_APPEND_PROFILE_IMAGE = "profile-image/";
    public static final String LINK_APPEND_WORK_IMAGE = "work-image/";
    public static final String LINK_APPEND_WORK_FILE = "work-file/";
    
    // Application scope
    public static final String APP_DB_NAME = "db";
    public static final String APP_DB_BUCKET = "bk";

    // DB collection name
    public static final String DB_COL_USER = "users";
//    public static final String DB_COL_WORK = "works";

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

    // DB collection 'works', document values
//    public static final String DB_DOC_WORK_ID = "id";

    // Usally carry error message in request scope
    public static final String MESSAGE = "msg";

    // Url for call servlet page to forward to associate jsp page
    public static final String PAGE_SIGN_IN = "signin";
//    public static final String PAGE_SIGN_UP = "signup";
    public static final String PAGE_SIGN_OUT = "signout";
    public static final String PAGE_HOME = "home";
    public static final String PAGE_USER_PROFILE = "user";
    public static final String PAGE_EDIT_PROFILE = "editprofile";
    public static final String PAGE_MYWORK = "mywork";
    public static final String PAGE_ADD_WORK = "addwork";

    // Session scope
    public static final String SES_CURRENT_USER = "cruser";

    // User privilege
    public static final String PRIVILEGE_MEMBER = "member";
    public static final String PRIVILEGE_TRANSLATOR = "translator";
    public static final String PRIVILEGE_ADMIN = "admin";

    // Web parameter name
    // Share
    public static final String WEB_IMAGE = "image";
    // User
    public static final String WEB_USERNAME = "username";
    public static final String WEB_PASSWORD = "password";
    public static final String WEB_DISPLAYNAME = "displayname";
    public static final String WEB_FIRSTNAME = "firstname";
    public static final String WEB_LASTNAME = "lastname";
    public static final String WEB_EMAIL = "email";
    public static final String WEB_PHONE = "phone";
    public static final String WEB_USER_INFO = "info";
    public static final String WEB_USER_TAG = "usertag";
    public static final String WEB_USER_ID_CARD = "idcardimg";
    public static final String WEB_USER_ID_SELFIE = "idselfieimg";
    // Work
    public static final String WEB_TITLE = "title";
    public static final String WEB_DESC = "desc";
    public static final String WEB_WORK_TAG = "worktag";
    public static final String WEB_DEADLINE = "deadline";
    public static final String WEB_PRICE = "price";
    public static final String WEB_HIDDEN = "hidden";
    public static final String WEB_FILE = "file";

    // MIN length
    public static final int LEN_MIN_USERNAME = 8;
    public static final int LEN_MIN_PASSWORD = 8;
    public static final int LEN_MIN_DISPLAYNAME = 1;
    public static final int LEN_MIN_FIRSTNAME = 1;
    public static final int LEN_MIN_LASTNAME = 1;
    public static final int LEN_MIN_EMAIL = 5;
    public static final int LEN_MIN_PHONE = 10;
    public static final int LEN_MIN_INFO = 1;
    public static final int LEN_MIN_TAG = 3;

    // MAX length
    public static final int LEN_MAX_USERNAME = 25;
    public static final int LEN_MAX_PASSWORD = 25;
    public static final int LEN_MAX_DISPLAYNAME = 25;
    public static final int LEN_MAX_FIRSTNAME = 999;
    public static final int LEN_MAX_LASTNAME = 999;
    public static final int LEN_MAX_EMAIL = 5;
    public static final int LEN_MAX_PHONE = 10;
    public static final int LEN_MAX_INFO = 999;
    public static final int LEN_MAX_TAG = 9;
}
