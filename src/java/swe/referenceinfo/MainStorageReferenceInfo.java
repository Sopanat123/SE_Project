package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class MainStorageReferenceInfo {

    private static MainStorageReferenceInfo mainStorageReferenceInfo;

    private final String storage = "bk";

    /*
     * Link to Google Cloud Store (GCS)
     *
     * profile image : (GCS/)PI/username-imagename
     * id card : (GCS/)IC/username-cardname
     * id selfie : (GCS/)IS/username-selfiename
     * work image : (GCS/)WI/timestamp-i-usernameimagename
     * work sample : (GCS/)WS/timestamp-s-usernamesamplename
     * work file : (GCS/)WF/timestamp-f-usernamefilename
     */
    // Main path to google cloud storage
    private final String urlGCS = "https://storage.googleapis.com/se-project-db.appspot.com/";

    // path to append after the main path
    private final String urlExtProfileImage = "profile-image/";
    private final String urlExtIdCard = "user-idcard/";
    private final String urlExtIdSelfie = "user-idselfie/";
    private final String urlExtWorkImage = "work-image/";
    private final String urlExtWorkFile = "work-file/";
    private final String urlExtWorkSample = "work-sample/";

    private MainStorageReferenceInfo() {
    }

    public static MainStorageReferenceInfo getMainStorageReferenceInfo() {
        if (mainStorageReferenceInfo == null) {
            mainStorageReferenceInfo = new MainStorageReferenceInfo();
        }
        return mainStorageReferenceInfo;
    }

    public String getStorage() {
        return storage;
    }

    public String getUrlGCS() {
        return urlGCS;
    }

    public String getUrlExtProfileImage() {
        return urlExtProfileImage;
    }

    public String getUrlExtIdCard() {
        return urlExtIdCard;
    }

    public String getUrlExtIdSelfie() {
        return urlExtIdSelfie;
    }

    public String getUrlExtWorkImage() {
        return urlExtWorkImage;
    }

    public String getUrlExtWorkFile() {
        return urlExtWorkFile;
    }

    public String getUrlExtWorkSample() {
        return urlExtWorkSample;
    }

}
