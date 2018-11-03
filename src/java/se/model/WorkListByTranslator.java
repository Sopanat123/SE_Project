package se.model;

import java.util.ArrayList;

/**
 *
 * @author Ben
 */
public class WorkListByTranslator {

    private final String translator;
    private ArrayList<Work> list;

    /**
     * Store all works of one translator in an array list
     *
     * @param translator name of translator
     */
    public WorkListByTranslator(String translator) {
        this.translator = translator;
        list = new ArrayList<>();
    }

    public String getTranslator() {
        return translator;
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
