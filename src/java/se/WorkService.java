package se;

/**
 *
 * @author Ben
 */
public class WorkService {

    private static String message;

    public static final String getMessage() {
        return message;
    }

    public static final boolean validateTitle(String title) {
        if (title == null || title.isEmpty()) {
            message = "Title is empty";
            return false;
        } else if (title.length() < Variable.LEN_MIN_TITLE) {
            message = "Title is too short";
            return false;
        } else if (title.length() > Variable.LEN_MAX_TITLE) {
            message = "Title is too long";
            return false;
        }
        return true;
    }

    public static final boolean validateDescription(String desc) {
        if (desc == null || desc.isEmpty()) {
            message = "Description is empty";
            return false;
        } else if (desc.length() < Variable.LEN_MIN_DESC) {
            message = "Description is too short";
            return false;
        } else if (desc.length() > Variable.LEN_MAX_DESC) {
            message = "Description is too long";
            return false;
        }
        return true;
    }

    public static final boolean validateTag(String tag) {
        if (tag == null || tag.isEmpty()) {
            message = "Tag is empty";
            return false;
        } else if (tag.length() < Variable.LEN_MIN_TAG) {
            message = "Tag is too short";
            return false;
        } else if (tag.length() > Variable.LEN_MAX_TAG) {
            message = "Tag is too long";
            return false;
        } else if (tag.contains("/")) {
            message = "Tag can't has /";
            return false;
        }
        return true;
    }

    public static final boolean validateTime(String time) {
        if (time == null || time.isEmpty()) {
            message = "Time is empty";
            return false;
        }
        return true;
    }

    public static final boolean validatePrice(String price) {
        if (price == null || price.isEmpty()) {
            message = "Price is empty";
            return false;
        }
        try {
            double price_double = Double.parseDouble(price);
            return validatePrice(price_double);
        } catch (NumberFormatException e) {
            message = "Format for price is invalid";
            return false;
        }
    }

    public static final boolean validatePrice(double price) {
        if (price < Variable.LEN_MIN_PRICE) {
            message = "Price is too low";
            return false;
        } else if (price > Variable.LEN_MAX_PRICE) {
            message = "Price is too high";
            return false;
        }
        return true;
    }
}
