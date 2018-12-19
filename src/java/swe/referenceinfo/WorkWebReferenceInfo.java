package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class WorkWebReferenceInfo {

    private static WorkWebReferenceInfo workWebReferenceInfo;

    private final String title = "title";
    private final String desc = "desc";
    private final String origLang = "origlang";
    private final String targLang = "targlang";
    private final String tag = "worktag";
    private final String deadline = "deadline";
    private final String price = "price";
    private final String hidden = "hidden";
    private final String image = "image";
    private final String sample = "sample";
    private final String file = "file";

    private WorkWebReferenceInfo() {
    }

    public static WorkWebReferenceInfo getWorkWebReferenceInfo() {
        if (workWebReferenceInfo == null) {
            workWebReferenceInfo = new WorkWebReferenceInfo();
        }
        return workWebReferenceInfo;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getOrigLang() {
        return origLang;
    }

    public String getTargLang() {
        return targLang;
    }

    public String getTag() {
        return tag;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getPrice() {
        return price;
    }

    public String getHidden() {
        return hidden;
    }

    public String getImage() {
        return image;
    }

    public String getSample() {
        return sample;
    }

    public String getFile() {
        return file;
    }

}
