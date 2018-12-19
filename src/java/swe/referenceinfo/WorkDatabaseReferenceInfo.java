package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class WorkDatabaseReferenceInfo {

    private static WorkDatabaseReferenceInfo workDatabaseReferenceInfo;

    // Work collection level
    private final String colWork = "works";

    // Work document level
    private final String docId = "id";
    private final String docOwner = "owner";
    private final String docTranslator = "translator";
    private final String docTitle = "title";
    private final String docOrigLang = "origlang";
    private final String docTargLang = "targlang";
    private final String docDesc = "desc";
    private final String docTag = "tag";
    private final String docImage = "image";
    private final String docSample = "sample";
    private final String docFile = "file";
    private final String docPrice = "price";
    private final String docHidden = "hidden";
    private final String docStatus = "status";
    private final String docDeadline = "deadline";
    private final String docCreateTime = "created";
    private final String docAcceptTime = "accepted";
    private final String docFinishTime = "finished";

    // Work hidden flag
    private final String attHideFalse = "no";
    private final String attHideTrue = "yes";

    // Work status
    private final String attStatusNew = "new";
    private final String attStatusDeal = "deal";
    private final String attStatusWip = "in progress";
    private final String attStatusComplete = "completed";

    private WorkDatabaseReferenceInfo() {
    }

    public static WorkDatabaseReferenceInfo getWorkDatabaseReferenceInfo() {
        if (workDatabaseReferenceInfo == null) {
            workDatabaseReferenceInfo = new WorkDatabaseReferenceInfo();
        }
        return workDatabaseReferenceInfo;
    }

    public String getColWork() {
        return colWork;
    }

    public String getDocId() {
        return docId;
    }

    public String getDocOwner() {
        return docOwner;
    }

    public String getDocTranslator() {
        return docTranslator;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public String getDocOrigLang() {
        return docOrigLang;
    }

    public String getDocTargLang() {
        return docTargLang;
    }

    public String getDocDesc() {
        return docDesc;
    }

    public String getDocTag() {
        return docTag;
    }

    public String getDocImage() {
        return docImage;
    }

    public String getDocSample() {
        return docSample;
    }

    public String getDocFile() {
        return docFile;
    }

    public String getDocPrice() {
        return docPrice;
    }

    public String getDocHidden() {
        return docHidden;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public String getDocDeadline() {
        return docDeadline;
    }

    public String getDocCreateTime() {
        return docCreateTime;
    }

    public String getDocAcceptTime() {
        return docAcceptTime;
    }

    public String getDocFinishTime() {
        return docFinishTime;
    }

    public String getAttHideFalse() {
        return attHideFalse;
    }

    public String getAttHideTrue() {
        return attHideTrue;
    }

    public String getAttStatusNew() {
        return attStatusNew;
    }

    public String getAttStatusDeal() {
        return attStatusDeal;
    }

    public String getAttStatusWip() {
        return attStatusWip;
    }

    public String getAttStatusComplete() {
        return attStatusComplete;
    }

}
