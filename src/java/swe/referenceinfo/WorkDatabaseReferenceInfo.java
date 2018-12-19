package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class WorkDatabaseReferenceInfo {

    private static WorkDatabaseReferenceInfo workDatabaseReferenceInfo;

    // Work collection level
    private final String dbColWork = "works";

    // Work document level
    private final String dbDocId = "id";
    private final String dbDocOwner = "owner";
    private final String dbDocTranslator = "translator";
    private final String dbDocTitle = "title";
    private final String dbDocOrigLang = "origlang";
    private final String dbDocTargLang = "targlang";
    private final String dbDocDesc = "desc";
    private final String dbDocTag = "tag";
    private final String dbDocImage = "image";
    private final String dbDocSample = "sample";
    private final String dbDocFile = "file";
    private final String dbDocPrice = "price";
    private final String dbDocHidden = "hidden";
    private final String dbDocStatus = "status";
    private final String dbDocDeadline = "deadline";
    private final String dbDocCreateTime = "created";
    private final String dbDocAcceptTime = "accepted";
    private final String dbDocFinishTime = "finished";

    // Work hidden flag
    private final String dbAttHideFalse = "no";
    private final String dbAttHideTrue = "yes";

    // Work status
    private final String dbAttStatusNew = "new";
    private final String dbAttStatusDeal = "deal";
    private final String dbAttStatusWip = "in progress";
    private final String dbAttStatusComplete = "completed";

    private WorkDatabaseReferenceInfo() {
    }

    public static WorkDatabaseReferenceInfo getWorkDatabaseReferenceInfo() {
        if (workDatabaseReferenceInfo == null) {
            workDatabaseReferenceInfo = new WorkDatabaseReferenceInfo();
        }
        return workDatabaseReferenceInfo;
    }

    public String getDbColWork() {
        return dbColWork;
    }

    public String getDbDocId() {
        return dbDocId;
    }

    public String getDbDocOwner() {
        return dbDocOwner;
    }

    public String getDbDocTranslator() {
        return dbDocTranslator;
    }

    public String getDbDocTitle() {
        return dbDocTitle;
    }

    public String getDbDocOrigLang() {
        return dbDocOrigLang;
    }

    public String getDbDocTargLang() {
        return dbDocTargLang;
    }

    public String getDbDocDesc() {
        return dbDocDesc;
    }

    public String getDbDocTag() {
        return dbDocTag;
    }

    public String getDbDocImage() {
        return dbDocImage;
    }

    public String getDbDocSample() {
        return dbDocSample;
    }

    public String getDbDocFile() {
        return dbDocFile;
    }

    public String getDbDocPrice() {
        return dbDocPrice;
    }

    public String getDbDocHidden() {
        return dbDocHidden;
    }

    public String getDbDocStatus() {
        return dbDocStatus;
    }

    public String getDbDocDeadline() {
        return dbDocDeadline;
    }

    public String getDbDocCreateTime() {
        return dbDocCreateTime;
    }

    public String getDbDocAcceptTime() {
        return dbDocAcceptTime;
    }

    public String getDbDocFinishTime() {
        return dbDocFinishTime;
    }

    public String getDbAttHideFalse() {
        return dbAttHideFalse;
    }

    public String getDbAttHideTrue() {
        return dbAttHideTrue;
    }

    public String getDbAttStatusNew() {
        return dbAttStatusNew;
    }

    public String getDbAttStatusDeal() {
        return dbAttStatusDeal;
    }

    public String getDbAttStatusWip() {
        return dbAttStatusWip;
    }

    public String getDbAttStatusComplete() {
        return dbAttStatusComplete;
    }

}
