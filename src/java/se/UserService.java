package se;

import se.Variable;

/**
 *
 * @author Ben
 */
public class UserService {

    private static String message;

    public static final String getMessage() {
        return message;
    }

    public static final boolean validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            message = "Username is empty";
            return false;
        } else if (username.length() < Variable.LEN_MIN_USERNAME) {
            message = "Username is too short";
            return false;
        } else if (username.length() > Variable.LEN_MAX_USERNAME) {
            message = "Username is too long";
            return false;
        } else if (username.contains("/")) {
            message = "Username can't has /";
            return false;
        }
        return true;
    }

    public static final boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            message = "Password is empty";
            return false;
        } else if (password.length() < Variable.LEN_MIN_PASSWORD) {
            message = "Password is too short";
            return false;
        } else if (password.length() > Variable.LEN_MAX_PASSWORD) {
            message = "Password is too long";
            return false;
        } else if (password.contains("/")) {
            message = "Password can't has /";
            return false;
        }
        return true;
    }

    public static final boolean validateDisplayname(String displayname) {
        if (displayname == null || displayname.isEmpty()) {
            message = "Displayname is empty";
            return false;
        } else if (displayname.length() < Variable.LEN_MIN_DISPLAYNAME) {
            message = "Displayname is too short";
            return false;
        } else if (displayname.length() > Variable.LEN_MAX_DISPLAYNAME) {
            message = "Displayname is too long";
            return false;
        } else if (displayname.contains("/")) {
            message = "Displayname can't has /";
            return false;
        }
        return true;
    }

    public static final boolean validateFirstname(String firstname) {
        if (firstname == null || firstname.isEmpty()) {
            message = "Firstname is empty";
            return false;
        } else if (firstname.length() < Variable.LEN_MIN_FIRSTNAME) {
            message = "Firstname is too short";
            return false;
        } else if (firstname.length() > Variable.LEN_MAX_FIRSTNAME) {
            message = "Firstname is too long";
            return false;
        }
        return true;
    }

    public static final boolean validateLastname(String lastname) {
        if (lastname == null || lastname.isEmpty()) {
            message = "Lastname is empty";
            return false;
        } else if (lastname.length() < Variable.LEN_MIN_LASTNAME) {
            message = "Lastname is too short";
            return false;
        } else if (lastname.length() > Variable.LEN_MAX_LASTNAME) {
            message = "Lastname is too long";
            return false;
        }
        return true;
    }

    public static final boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            message = "Email is empty";
            return false;
        } else if (email.length() < Variable.LEN_MIN_EMAIL) {
            message = "Email is too short";
            return false;
        } else if (email.length() > Variable.LEN_MAX_EMAIL) {
            message = "Email is too long";
            return false;
        } else if (!email.contains("@")) {
            message = "Email has no domain";
            return false;
        } else if (email.contains("/")) {
            message = "Email can't has /";
            return false;
        }
        return true;
    }

    public static final boolean validatePhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            message = "Phone is empty";
            return false;
        } else if (phone.length() < Variable.LEN_MIN_PHONE) {
            message = "Phone is too short";
            return false;
        } else if (phone.length() > Variable.LEN_MAX_PHONE) {
            message = "Phone is too long";
            return false;
        } else if (phone.contains("/")) {
            message = "Phone can't has /";
            return false;
        }
        return true;
    }

    public static final boolean validateInfo(String info) {
        if (info == null || info.isEmpty()) {
            message = "Info is empty";
            return false;
        } else if (info.length() < Variable.LEN_MIN_INFO) {
            message = "Info is too short";
            return false;
        } else if (info.length() > Variable.LEN_MAX_INFO) {
            message = "Info is too long";
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

}
