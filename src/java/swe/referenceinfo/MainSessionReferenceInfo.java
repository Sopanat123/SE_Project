package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class MainSessionReferenceInfo {

    private static MainSessionReferenceInfo mainSessionReferenceInfo;

    private final String sUser = "suser";
    private final String sWork = "swork";

    private MainSessionReferenceInfo() {
    }

    public static MainSessionReferenceInfo getMainSessionReferenceInfo() {
        if (mainSessionReferenceInfo == null) {
            mainSessionReferenceInfo = new MainSessionReferenceInfo();
        }
        return mainSessionReferenceInfo;
    }

    public String getsUser() {
        return sUser;
    }

    public String getsWork() {
        return sWork;
    }

}
