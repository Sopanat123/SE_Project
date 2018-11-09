package se.model;

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

import se.Variable;

/**
 *
 * @author Ben
 */
public class TranslatorVerifyList {

    private static final String TAG = "TranslatorVerifyList";

    private boolean createStatus = false;
    private ArrayList<Translator> list;

    public TranslatorVerifyList(Firestore db) {
        // Create arraylist to hold all user reference
        list = new ArrayList<>();

        try {
            ApiFuture<QuerySnapshot> future = db.collection(Variable.DB_COL_USER)
                    .whereEqualTo(Variable.DB_DOC_USER_VERIFY, Variable.VERIFY_WAIT)
                    .get();
            List<QueryDocumentSnapshot> users = future.get().getDocuments();
            // Iliterate each document
            for (DocumentSnapshot u : users) {
                Translator translator = new Translator(u.getId());

                translator.setDisplayname(u.getString(Variable.DB_DOC_USER_DISPLAYNAME));
                translator.setFirstname(u.getString(Variable.DB_DOC_USER_FIRSTNAME));
                translator.setLastname(u.getString(Variable.DB_DOC_USER_LASTNAME));
                translator.setEmail(u.getString(Variable.DB_DOC_USER_EMAIL));
                translator.setPhone(u.getString(Variable.DB_DOC_USER_PHONE));
                translator.setInfo(u.getString(Variable.DB_DOC_USER_INFO));
                translator.setTag(u.getString(Variable.DB_DOC_USER_TAG));
                translator.setImage(u.getString(Variable.DB_DOC_USER_IMAGE));
                translator.setPrivilege(u.getString(Variable.DB_DOC_USER_PRIVILEGE));
                translator.setVerify(u.getString(Variable.DB_DOC_USER_VERIFY));
                translator.setIdCardImage(u.getString(Variable.DB_DOC_USER_ID_IMAGE));
                translator.setIdCardSelfie(u.getString(Variable.DB_DOC_USER_ID_SELFIE));

                list.add(translator);
            }
            createStatus = true;
        } catch (ExecutionException | InterruptedException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
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
