package swe.model;

/**
 *
 * @author Ben
 */
public class Work {

    private String id; // username + "work" + number of work
    private String owner; // owner username
    private String title;
    private String oriLang;
    private String targLang;
    private String desc;
    private String tag; // separate by comma (,)
    private String imgUrl;
    private String sampleUrl; // sample file
    private String fileUrl; // full file
    private String cmpFileUrl; // complete file
    private String translator; // translator username, separate by comma (,) in auction phase
    private String status; // new - deal - completed
    private String deadline; // user define finish time
    private String created;
    private String accepted;
    private String finished; // actual deal closed time;
    private String price; // full price
    private String hidden; // hide work, access by direct url

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriLang() {
        return oriLang;
    }

    public void setOriLang(String oriLang) {
        this.oriLang = oriLang;
    }

    public String getTargLang() {
        return targLang;
    }

    public void setTargLang(String destLang) {
        this.targLang = destLang;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSampleUrl() {
        return sampleUrl;
    }

    public void setSampleUrl(String sampleUrl) {
        this.sampleUrl = sampleUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getAccepted() {
        return accepted;
    }

    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public String getCmpFileUrl() {
        return cmpFileUrl;
    }

    public void setCmpFileUrl(String cmpFileUrl) {
        this.cmpFileUrl = cmpFileUrl;
    }

}
