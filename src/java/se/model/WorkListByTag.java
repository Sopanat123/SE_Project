package se.model;

import java.util.ArrayList;

/**
 *
 * @author Ben
 */
public class WorkListByTag {

    private final String tag;
    private ArrayList<Work> list;

    /**
     * Store works relate with tag in an array list
     *
     * @param tag name of tag
     */
    public WorkListByTag(String tag) {
        this.tag = tag;
        list = new ArrayList<>();
    }

    public String getTag() {
        return tag;
    }

    public ArrayList<Work> getList() {
        return list;
    }

    public void setList(ArrayList<Work> list) {
        this.list = list;
    }

    public boolean addWork(Work work) {
        return list.add(work);
    }

    public boolean removeWork(Work work) {
        return list.remove(work);
    }

    public void clearList() {
        list.clear();
    }
}
