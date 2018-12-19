package swe.referenceinfo;

/**
 *
 * @author Ben
 */
public class MainDatabaseReferenceInfo {

    private static MainDatabaseReferenceInfo mainDatabaseReferenceInfo;

    private final String database = "db";

    private MainDatabaseReferenceInfo() {
    }

    public static MainDatabaseReferenceInfo getMainDatabaseReferenceInfo() {
        if (mainDatabaseReferenceInfo == null) {
            mainDatabaseReferenceInfo = new MainDatabaseReferenceInfo();
        }
        return mainDatabaseReferenceInfo;
    }

    public String getDatabase() {
        return database;
    }

}
