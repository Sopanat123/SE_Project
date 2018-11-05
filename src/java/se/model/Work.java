package se.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ben
 */
public class Work {

    private String id;
    private String owner; // owner username
    private String title;
    private String desc;
    private String tag; // separate by comma (,)
    private String srcUrl;
    private String translator; // translator username
    private String status;
    private Date createTime;
    private Date acceptTime;
    private Date deadLine; // user define finish time
    private Date finishTime; // actual deal closed time;
    private Double price; // full price
    private String hidden; // confindential file

//    public void setDate(String timestamp) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
//        sdf.format(this.createTime);
//    }
}
