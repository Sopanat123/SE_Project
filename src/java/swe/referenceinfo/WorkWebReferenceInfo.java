package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class WorkWebReferenceInfo {

    private static WorkWebReferenceInfo workWebReferenceInfo;

    private final String webTitle = "title";
    private final String webDesc = "desc";
    private final String webOrigLang = "origlang";
    private final String webTargLang = "targlang";
    private final String webTag = "worktag";
    private final String webDeadline = "deadline";
    private final String webPrice = "price";
    private final String webHidden = "hidden";
    private final String webImage = "image";
    private final String webSample = "sample";
    private final String webFile = "file";

    private WorkWebReferenceInfo() {
    }

    public static WorkWebReferenceInfo getWorkWebReferenceInfo() {
        if (workWebReferenceInfo == null) {
            workWebReferenceInfo = new WorkWebReferenceInfo();
        }
        return workWebReferenceInfo;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getWebDesc() {
        return webDesc;
    }

    public String getWebOrigLang() {
        return webOrigLang;
    }

    public String getWebTargLang() {
        return webTargLang;
    }

    public String getWebTag() {
        return webTag;
    }

    public String getWebDeadline() {
        return webDeadline;
    }

    public String getWebPrice() {
        return webPrice;
    }

    public String getWebHidden() {
        return webHidden;
    }

    public String getWebImage() {
        return webImage;
    }

    public String getWebSample() {
        return webSample;
    }

    public String getWebFile() {
        return webFile;
    }

}
