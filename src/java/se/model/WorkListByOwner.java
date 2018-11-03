package se.model;

import java.util.ArrayList;

/**
 *
 * @author Ben
 */
public class WorkListByOwner {

    private final String owner;
    private ArrayList<Work> list;

    /**
     * Store all works of one owner in an array list
     *
     * @param owner name of owner
     */
    public WorkListByOwner(String owner) {
        this.owner = owner;
        list = new ArrayList<>();
    }

    public String getOwner() {
        return owner;
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
