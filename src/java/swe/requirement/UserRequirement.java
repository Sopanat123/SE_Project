package swe.requirement;

/**
 *
 * @author Ben
 */
public class UserRequirement {

    private static UserRequirement userRequirement;

    private final int usernameMinLength = 8;
    private final int usernameMaxLength = 25;

    private final int passwordMinLength = 8;
    private final int passwordMaxLength = 25;

    private final int displaynameMinLength = 5;
    private final int displaynameMaxLength = 30;

    private final int firstnameMinLength = 1;
    private final int firstnameMaxLength = 255;

    private final int lastnameMinLength = 1;
    private final int lastnameMaxLength = 255;

    private final int emailMinLength = 5;
    private final int emailMaxLength = 255;

    private final int phoneMinLength = 8;
    private final int phoneMaxLength = 15;

    private final int infoMinLength = 1;
    private final int infoMaxLength = 999;

    private UserRequirement() {
    }

    public static UserRequirement getUserRequirement() {
        if (userRequirement == null) {
            userRequirement = new UserRequirement();
        }
        return userRequirement;
    }

    public int getUsernameMinLength() {
        return usernameMinLength;
    }

    public int getUsernameMaxLength() {
        return usernameMaxLength;
    }

    public int getPasswordMinLength() {
        return passwordMinLength;
    }

    public int getPasswordMaxLength() {
        return passwordMaxLength;
    }

    public int getDisplaynameMinLength() {
        return displaynameMinLength;
    }

    public int getDisplaynameMaxLength() {
        return displaynameMaxLength;
    }

    public int getFirstnameMinLength() {
        return firstnameMinLength;
    }

    public int getFirstnameMaxLength() {
        return firstnameMaxLength;
    }

    public int getLastnameMinLength() {
        return lastnameMinLength;
    }

    public int getLastnameMaxLength() {
        return lastnameMaxLength;
    }

    public int getEmailMinLength() {
        return emailMinLength;
    }

    public int getEmailMaxLength() {
        return emailMaxLength;
    }

    public int getPhoneMinLength() {
        return phoneMinLength;
    }

    public int getPhoneMaxLength() {
        return phoneMaxLength;
    }

    public int getInfoMinLength() {
        return infoMinLength;
    }

    public int getInfoMaxLength() {
        return infoMaxLength;
    }

}
