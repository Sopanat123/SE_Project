package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class SessionReferenceInfo {

    private static SessionReferenceInfo sessionReferenceInfo;

    private final String user = "sesuser";
    private final String work = "seswork";

    private SessionReferenceInfo() {
    }

    public static SessionReferenceInfo getSessionReferenceInfo() {
        if (sessionReferenceInfo == null) {
            sessionReferenceInfo = new SessionReferenceInfo();
        }
        return sessionReferenceInfo;
    }

    public String getUser() {
        return user;
    }

    public String getWork() {
        return work;
    }

}
