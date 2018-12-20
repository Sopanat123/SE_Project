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

    private final String editprofile = "editprofile";
    private final String betranslator = "betranslator";
    private final String approvetranslator = "approvetranslator";

    private final String addNewWork = "addnewwork";
    private final String myWork = "mywork";
    private final String workDetail = "workdetail";

    private ServletReferenceInfo() {
    }

    public static ServletReferenceInfo getServletReferenceInfo() {
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

    public String getEditprofile() {
        return editprofile;
    }

    public String getAddNewWork() {
        return addNewWork;
    }

    public String getMyWork() {
        return myWork;
    }

    public String getBetranslator() {
        return betranslator;
    }

    public String getApprovetranslator() {
        return approvetranslator;
    }

    public String getWorkDetail() {
        return workDetail;
    }

}
