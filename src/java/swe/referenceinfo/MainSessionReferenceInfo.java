package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class MainSessionReferenceInfo {

    private static MainSessionReferenceInfo mainSessionReferenceInfo;

    private final String user = "sesuser";
    private final String work = "seswork";

    private MainSessionReferenceInfo() {
    }

    public static MainSessionReferenceInfo getMainSessionReferenceInfo() {
        if (mainSessionReferenceInfo == null) {
            mainSessionReferenceInfo = new MainSessionReferenceInfo();
        }
        return mainSessionReferenceInfo;
    }

    public String getUser() {
        return user;
    }

    public String getWork() {
        return work;
    }

}
