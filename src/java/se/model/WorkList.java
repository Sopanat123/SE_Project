package se.model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import se.Variable;

/**
 *
 * @author Ben
 */
public class WorkList {

    private static final String TAG = "WorkList";
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    private boolean createListStatus = false;
    private String identifier;
    private ArrayList<Work> list;

    public WorkList(Firestore db) {
        // Create arraylist to hold all work reference
        list = new ArrayList<>();

        try {
            ApiFuture<QuerySnapshot> future = db.collection(Variable.DB_COL_WORK)
                    .orderBy(Variable.DB_DOC_WORK_CREATED, Query.Direction.ASCENDING)
                    .get();
            List<QueryDocumentSnapshot> docs = future.get().getDocuments();
            // Iliterate each document
            for (DocumentSnapshot doc : docs) {
                Work work = new Work();

                work.setId(doc.getString(Variable.DB_DOC_WORK_ID));
                work.setOwner(doc.getString(Variable.DB_DOC_WORK_OWNER));
                work.setTitle(doc.getString(Variable.DB_DOC_WORK_TITLE));
                work.setOriLang(doc.getString(Variable.DB_DOC_WORK_LANG_ORI));
                work.setDestLang(doc.getString(Variable.DB_DOC_WORK_LANG_DEST));
                work.setDesc(doc.getString(Variable.DB_DOC_WORK_DESC));
                work.setTag(doc.getString(Variable.DB_DOC_WORK_TAG));
                work.setImgUrl(doc.getString(Variable.DB_DOC_WORK_IMAGE));
                work.setSampleUrl(doc.getString(Variable.DB_DOC_WORK_SAMPLE));
                work.setFileUrl(doc.getString(Variable.DB_DOC_WORK_FILE));
                work.setTranslator(doc.getString(Variable.DB_DOC_WORK_TRANSLATOR));
                work.setStatus(doc.getString(Variable.DB_DOC_WORK_STATUS));
                work.setDeadline(doc.getString(Variable.DB_DOC_WORK_DEADLINE));
                Date cDate = (Date) doc.get(Variable.DB_DOC_WORK_CREATED);
                work.setCreated(df.format(cDate));
                if (doc.get(Variable.DB_DOC_WORK_ACCEPTED) != null) {
                    Date aDate = (Date) doc.get(Variable.DB_DOC_WORK_ACCEPTED);
                    work.setAccepted(df.format(aDate));
                }
                if (doc.get(Variable.DB_DOC_WORK_FINISHED) != null) {
                    Date fDate = (Date) doc.get(Variable.DB_DOC_WORK_FINISHED);
                    work.setFinished(df.format(fDate));
                }
                work.setPrice(doc.getString(Variable.DB_DOC_WORK_PRICE));
                work.setOnlySample(doc.getString(Variable.DB_DOC_WORK_ONLYSAMPLE));
                work.setHidden(doc.getString(Variable.DB_DOC_WORK_HIDDEN));

                list.add(work);
            }
            createListStatus = true;
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        }
    }

    public String getIdentifier() {
        return identifier;
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

    public boolean isCreateListStatus() {
        return createListStatus;
    }
}
