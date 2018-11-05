package se.listener;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import se.Variable;

/**
 * Web application lifecycle listener.
 *
 * @author Ben
 */
public class Initial implements ServletContextListener {

    private static final String TAG = "Initial";

    private Firestore fs;
    private Bucket bk;

    /**
     * Initialize web application, call only one times when deploy an
     * application.
     *
     * @param sce Application context
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // Create and get connection to firebase
            initDatabase(sce.getServletContext());
            // Store instance in application context for the whole web usage
            sce.getServletContext().setAttribute(Variable.APP_DB_NAME, fs);
            sce.getServletContext().setAttribute(Variable.APP_DB_BUCKET, bk);
        } catch (IOException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Call only when web application is being shut down.
     *
     * @param sce Application context
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            fs.close();
        } catch (Exception ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initialize connection to Firestore database and File storage. Provide
     * database instance
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void initDatabase(ServletContext sc) throws FileNotFoundException, IOException {
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
