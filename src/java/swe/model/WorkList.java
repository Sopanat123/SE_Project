package swe.model;

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
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import swe.referenceinfo.UserDatabaseReferenceInfo;
import swe.referenceinfo.WorkDatabaseReferenceInfo;

/**
 *
 * @author Ben
 */
public class WorkList {

    private final WorkDatabaseReferenceInfo wDbRef = WorkDatabaseReferenceInfo.getWorkDatabaseReferenceInfo();

    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    private boolean createListStatus = false;
    private String identifier;
    private ArrayList<Work> list;

    public WorkList(Firestore db) {
        try {
            list = new ArrayList<>();

            ApiFuture<QuerySnapshot> future = db.collection(wDbRef.getColWork())
                    .orderBy(wDbRef.getDocCreateTime(), Query.Direction.ASCENDING)
                    .get();
            List<QueryDocumentSnapshot> docs = future.get().getDocuments();
            for (DocumentSnapshot doc : docs) {
                Map<String, Object> map = doc.getData();
                Work work = new Work();

                work.setId((String) map.get(wDbRef.getDocId()));
                work.setOwner((String) map.get(wDbRef.getDocOwner()));
                work.setTitle((String) map.get(wDbRef.getDocTitle()));
                work.setOriLang((String) map.get(wDbRef.getDocOrigLang()));
                work.setTargLang((String) map.get(wDbRef.getDocTargLang()));
                work.setDesc((String) map.get(wDbRef.getDocDesc()));
                work.setTag((String) map.get(wDbRef.getDocTag()));
                work.setImgUrl((String) map.get(wDbRef.getDocImage()));
                work.setSampleUrl((String) map.get(wDbRef.getDocSample()));
                if (map.get(wDbRef.getDocFile()) != null) {
                    work.setFileUrl((String) map.get(wDbRef.getDocFile()));
                }
                work.setTranslator((String) map.get(wDbRef.getDocTranslator()));
                work.setStatus((String) map.get(wDbRef.getDocStatus()));
                work.setDeadline((String) map.get(wDbRef.getDocDeadline()));
                Date cDate = (Date) map.get(wDbRef.getDocCreateTime());
                work.setCreated(df.format(cDate));
                if (map.get(wDbRef.getDocAcceptTime()) != null) {
                    Date aDate = (Date) map.get(wDbRef.getDocAcceptTime());
                    work.setAccepted(df.format(aDate));
                }
                if (map.get(wDbRef.getDocFinishTime()) != null) {
                    Date fDate = (Date) map.get(wDbRef.getDocFinishTime());
                    work.setFinished(df.format(fDate));
                }
                work.setPrice((String) map.get(wDbRef.getDocPrice()));
                work.setHidden((String) map.get(wDbRef.getDocHidden()));

                list.add(work);
            }
            createListStatus = true;
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(WorkList.class.getName()).log(Level.SEVERE, null, ex);
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
