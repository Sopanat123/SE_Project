package swe.model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import swe.referenceinfo.UserDatabaseReferenceInfo;

/**
 *
 * @author Ben
 */
public class TranslatorVerifyList {

    private boolean createStatus = false;
    private ArrayList<Translator> list;

    private final UserDatabaseReferenceInfo uDbRef = UserDatabaseReferenceInfo.getUserDatabaseReferenceInfo();

    public TranslatorVerifyList(Firestore db) {
        // Create arraylist to hold all user reference
        list = new ArrayList<>();

        try {
            ApiFuture<QuerySnapshot> future = db.collection(uDbRef.getColUser())
                    .whereEqualTo(uDbRef.getDocVerify(), uDbRef.getAttVerifyWait())
                    .get();
            List<QueryDocumentSnapshot> users = future.get().getDocuments();
            // Iliterate each document
            for (DocumentSnapshot u : users) {
                Translator translator = new Translator(u.getId());

                translator.setDisplayname(u.getString(uDbRef.getDocDisplayname()));
                translator.setFirstname(u.getString(uDbRef.getDocFirstname()));
                translator.setLastname(u.getString(uDbRef.getDocLastname()));
                translator.setEmail(u.getString(uDbRef.getDocEmail()));
                translator.setPhone(u.getString(uDbRef.getDocPhone()));
                translator.setInfo(u.getString(uDbRef.getDocInfo()));
                translator.setTag(u.getString(uDbRef.getDocTag()));
                translator.setImage(u.getString(uDbRef.getDocImage()));
                translator.setPrivilege(u.getString(uDbRef.getDocPrivilege()));
                translator.setVerify(u.getString(uDbRef.getDocVerify()));
                translator.setIdCardImage(u.getString(uDbRef.getDocIdCard()));
                translator.setIdCardSelfie(u.getString(uDbRef.getDocIdSelfie()));

                list.add(translator);
            }
            createStatus = true;
        } catch (ExecutionException | InterruptedException ex) {
            Logger.getLogger(TranslatorVerifyList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isCreateStatus() {
        return createStatus;
    }

    public ArrayList<Translator> getList() {
        return list;
    }

    public void setList(ArrayList<Translator> list) {
        this.list = list;
    }

}
