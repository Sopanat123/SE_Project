package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class MainWebReferenceInfo {

    private static MainWebReferenceInfo mainWebReferenceInfo;

    final String pageSignIn = "signin";
    final String pageSignUp = "signUp";
    final String pageSignOut = "signout";

    private MainWebReferenceInfo() {
    }

    public static MainWebReferenceInfo getMainWebReferenceInfo() {
        if (mainWebReferenceInfo == null) {
            mainWebReferenceInfo = new MainWebReferenceInfo();
        }
        return mainWebReferenceInfo;
    }
}
