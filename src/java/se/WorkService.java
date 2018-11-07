package se;

/**
 *
 * @author Ben
 */
public class WorkService {

    private static String message;
    
    private static final String getMessage() {
        return message;
    }
    
    public static final boolean validateTitle(String title) {
        if (title == null || title.isEmpty()) {
            message = "Title is empty";
            return false;
        }
        return true;
    }
}
