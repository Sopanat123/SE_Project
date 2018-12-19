package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class ServletReferenceInfo {

    private static ServletReferenceInfo servletReferenceInfo;

    private final String signIn = "signin";
    private final String signUp = "signup";
    private final String signOut = "signout";

    private final String home = "home";

    private ServletReferenceInfo() {
    }

    public static ServletReferenceInfo getsServletReferenceInfo() {
        if (servletReferenceInfo == null) {
            servletReferenceInfo = new ServletReferenceInfo();
        }
        return servletReferenceInfo;
    }

    public String getSignIn() {
        return signIn;
    }

    public String getSignUp() {
        return signUp;
    }

    public String getSignOut() {
        return signOut;
    }

    public String getHome() {
        return home;
    }

}
