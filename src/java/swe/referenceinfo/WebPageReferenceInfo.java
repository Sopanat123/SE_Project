package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class WebPageReferenceInfo {

    private static WebPageReferenceInfo webPageReferenceInfo;

    private final String welcome = "Welcome_PageNewVersion.jsp";
    private final String home = "WEB-INF/homepage.jsp";
    private final String editprofile = "WEB-INF/editprofile.jsp";
    private final String mywork = "WEB-INF/mywork.jsp";

    private WebPageReferenceInfo() {
    }

    public static WebPageReferenceInfo getWebPageReferenceInfo() {
        if (webPageReferenceInfo == null) {
            webPageReferenceInfo = new WebPageReferenceInfo();
        }
        return webPageReferenceInfo;
    }

    public String getWelcome() {
        return welcome;
    }

    public String getHome() {
        return home;
    }

    public String getEditprofile() {
        return editprofile;
    }

    public String getMywork() {
        return mywork;
    }

}
