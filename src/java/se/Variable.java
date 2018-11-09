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

    // Usally be used in request scope
    public static final String REQ_MESSAGE = "msg";
    public static final String REQ_WORKLIST = "works";
    public static final String REQ_TRANSLATOR = "translator";
    public static final String REQ_VERIFY_LIST = "translist";
    public static final String REQ_INTERESTED = "interested";

    // Session scope
    public static final String SES_CURRENT_USER = "cruser";
    public static final String SES_CURRENT_WORK = "crwork";

    // Default profile image
    public static final String DEF_PRO_IMG = "assets/def_pro_img.png";

    /*
     * Link to Google Cloud Store (GCS)
     *
     * profile image : (GCS/)PI/username-imagename
     * work image : (GCS/)WI/timestamp-i-usernameimagename
     * work sample : (GCS/)WS/timestamp-s-usernamesamplename
     * work file : (GCS/)WF/timestamp-f-usernamefilename
     */
    public static final String LINK_GCS = "https://storage.googleapis.com/se-project-db.appspot.com/";
    public static final String LINK_APPEND_PROFILE_IMAGE = "profile-image/";
    public static final String LINK_APPEND_USER_ID_CARD = "user-idcard/";
    public static final String LINK_APPEND_USER_ID_SELFIE = "user-idselfie/";
    public static final String LINK_APPEND_WORK_IMAGE = "work-image/";
    public static final String LINK_APPEND_WORK_FILE = "work-file/";
    public static final String LINK_APPEND_WORK_SAMPLE = "work-sample/";

    // Application scope
    public static final String APP_DB_NAME = "db";
    public static final String APP_DB_BUCKET = "bk";

    // DB collection name
    public static final String DB_COL_USER = "users";
    public static final String DB_COL_WORK = "works";

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
    // For translator only
    public static final String DB_DOC_USER_VERIFY = "verify";
    public static final String DB_DOC_USER_VERIFY_TIME = "verifytime";
    public static final String DB_DOC_USER_ID_IMAGE = "idcard";
    public static final String DB_DOC_USER_ID_SELFIE = "idselfie";

    // DB collection 'works', document values
    public static final String DB_DOC_WORK_ID = "id";
    public static final String DB_DOC_WORK_OWNER = "owner";
    public static final String DB_DOC_WORK_TRANSLATOR = "translator";
    public static final String DB_DOC_WORK_TITLE = "title";
    public static final String DB_DOC_WORK_LANG_ORI = "orilang";
    public static final String DB_DOC_WORK_LANG_DEST = "destlang";
    public static final String DB_DOC_WORK_DESC = "desc";
    public static final String DB_DOC_WORK_TAG = "tag";
    public static final String DB_DOC_WORK_IMAGE = "image";
    public static final String DB_DOC_WORK_SAMPLE = "sample";
    public static final String DB_DOC_WORK_FILE = "file";
    public static final String DB_DOC_WORK_PRICE = "price";
    public static final String DB_DOC_WORK_ONLYSAMPLE = "onlysample";
    public static final String DB_DOC_WORK_HIDDEN = "hidden";
    public static final String DB_DOC_WORK_STATUS = "status";
    public static final String DB_DOC_WORK_DEADLINE = "deadline";
    public static final String DB_DOC_WORK_CREATED = "created";
    public static final String DB_DOC_WORK_ACCEPTED = "accepted";
    public static final String DB_DOC_WORK_FINISHED = "finished";

    // Url for call servlet page to forward to associate jsp page
    public static final String PAGE_SIGN_IN = "signin";
//    public static final String PAGE_SIGN_UP = "signup";
    public static final String PAGE_SIGN_OUT = "signout";
    public static final String PAGE_HOME = "home";
    public static final String PAGE_USER_PROFILE = "user";
    public static final String PAGE_EDIT_PROFILE = "editprofile";
    public static final String PAGE_MYWORK = "mywork";
    public static final String PAGE_ADD_WORK = "addwork";
    public static final String PAGE_TO_TRANSLATOR = ""; // TODO ///////////////////////////////////////////////
    public static final String PAGE_VERIFY_TRANSLATOR = ""; // TODO ///////////////////////////////////////////

    // User privilege
    public static final String PRIVILEGE_MEMBER = "member";
    public static final String PRIVILEGE_TRANSLATOR = "translator";
    public static final String PRIVILEGE_ADMIN = "admin";

    // User verification step
    public static final String VERIFY_NONE = "none";
    public static final String VERIFY_WAIT = "wait";
    public static final String VERIFY_SUCCESS = "success";
    public static final String VERIFY_REJECT = "reject";

    // Work status
    public static final String WORK_STATUS_NEW = "new";
    public static final String WORK_STATUS_DEAL = "deal";
    public static final String WORK_STATUS_COMPLETED = "completed";

    // Web parameter name
    // Verify translator
    public static final String WEB_VERIFY_BUTTON_REJECT = "vrbtn";
    public static final String WEB_VERIFY_BUTTON_APPROVE = "apbtn";
    // User
    public static final String WEB_USER_USERNAME = "username";
    public static final String WEB_USER_PASSWORD = "password";
    public static final String WEB_USER_DISPLAYNAME = "displayname";
    public static final String WEB_USER_FIRSTNAME = "firstname";
    public static final String WEB_USER_LASTNAME = "lastname";
    public static final String WEB_USER_EMAIL = "email";
    public static final String WEB_USER_PHONE = "phone";
    public static final String WEB_USER_IMAGE = "image";
    public static final String WEB_USER_INFO = "info";
    public static final String WEB_USER_TAG = "usertag";
    public static final String WEB_USER_ID_CARD = "idcardimg";
    public static final String WEB_USER_ID_SELFIE = "idselfieimg";
    // Work
    public static final String WEB_WORK_TITLE = "title";
    public static final String WEB_WORK_DESC = "desc";
    public static final String WEB_WORK_LANG_ORI = "orilang";
    public static final String WEB_WORK_LANG_DEST = "destlang";
    public static final String WEB_WORK_TAG = "worktag";
    public static final String WEB_WORK_DEADLINE = "deadline";
    public static final String WEB_WORK_PRICE = "price";
    public static final String WEB_WORK_ONLYSAMPLE = "onlysample";
    public static final String WEB_WORK_HIDDEN = "hidden";
    public static final String WEB_WORK_IMAGE = "image";
    public static final String WEB_WORK_SAMPLE = "sample";
    public static final String WEB_WORK_FILE = "file";

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
    public static final int LEN_MIN_TITLE = 1;
    public static final int LEN_MIN_LANGUAGE = 2;
    public static final int LEN_MIN_DESC = 1;
    public static final double LEN_MIN_PRICE = 0;

    // MAX length
    public static final int LEN_MAX_USERNAME = 25;
    public static final int LEN_MAX_PASSWORD = 25;
    public static final int LEN_MAX_DISPLAYNAME = 25;
    public static final int LEN_MAX_FIRSTNAME = 255;
    public static final int LEN_MAX_LASTNAME = 255;
    public static final int LEN_MAX_EMAIL = 5;
    public static final int LEN_MAX_PHONE = 10;
    public static final int LEN_MAX_INFO = 255;
    public static final int LEN_MAX_TAG = 9;
    public static final int LEN_MAX_TITLE = 20;
    public static final int LEN_MAX_LANGUAGE = 20;
    public static final int LEN_MAX_DESC = 255;
    public static final double LEN_MAX_PRICE = 99999.99;
}
