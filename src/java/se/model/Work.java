package se.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ben
 */
public class Work {

    private String id; // username + "work" + number of work
    private String owner; // owner username
    private String title;
    private String desc;
    private String tag; // separate by comma (,)
    private String imgUrl;
    private String sampleUrl; // sample file
    private String fileUrl; // full file
    private String translator; // translator username, separate by comma (,) in auction phase
    private String status; // new - deal - completed
    private Date deadline; // user define finish time
    private Date created;
    private Date accepted;
    private Date finished; // actual deal closed time;
    private Double price; // full price
    private String onlySample; // show only sample file not full file
    private String hidden; // hide work, access by direct url

//    public void setDate(String timestamp) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
//        sdf.format(this.createTime);
//    }
}
