package swe.listener;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.MainStorageReferenceInfo;

/**
 * Web application lifecycle listener.
 *
 * @author Ben
 */
public class Initial implements ServletContextListener {

    private Firestore fs;
    private Bucket bk;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ServletContext sc = sce.getServletContext();
            // Create and get connection to firebase
            initializeDatabase(sc);
            // Store instance in application context for the whole web usage
            sc.setAttribute(MainDatabaseReferenceInfo.getMainDatabaseReferenceInfo().getDatabase(), fs);
            sc.setAttribute(MainStorageReferenceInfo.getMainStorageReferenceInfo().getStorage(), bk);
        } catch (IOException ex) {
            Logger.getLogger(Initial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            fs.close();
        } catch (Exception ex) {
            Logger.getLogger(Initial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initializeDatabase(ServletContext sc) throws IOException {
        // Get a service account
        InputStream serviceAccount = sc.getResourceAsStream("/WEB-INF/assets"
                + "/se-project-db-firebase-adminsdk-byx1d-b9bc9cc741.json");
        // Use a service account to authenticate
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        // Create and set the option
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setStorageBucket("se-project-db.appspot.com")
                .build();
        // Initialize a Firestore
        FirebaseApp.initializeApp(options);
        // Get Database
        fs = FirestoreClient.getFirestore();
        bk = StorageClient.getInstance().bucket();
    }
}
