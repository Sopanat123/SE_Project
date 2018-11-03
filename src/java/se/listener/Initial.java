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
            // Create and get connection to firebase
            initDatabase(sce.getServletContext());
            sce.getServletContext().setAttribute("db", fs);
            sce.getServletContext().setAttribute("bk", bk);
        } catch (IOException ex) {
            Logger.getLogger(Initial.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            fs.close();
        } catch (Exception ex) {
            Logger.getLogger(Initial.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initialize connection to Firestore database.
     *
     * @return connection to database
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
