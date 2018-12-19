package swe.requirement;

/**
 *
 * @author Ben
 */
public class UserRequirement {

    private static UserRequirement userRequirement;

    private final int reqUsernameMinLength = 8;
    private final int reqUsernameMaxLength = 25;

    private final int reqPasswordMinLength = 8;
    private final int reqPasswordMaxLength = 30;

    private final int reqDisplaynameMinLength = 5;
    private final int reqDisplaynameMaxLength = 20;

    private final int reqFirstnameMinLength = 1;
    private final int reqFirstnameMaxLength = 255;

    private final int reqLastnameMinLength = 1;
    private final int reqLastnameMaxLength = 255;

    private final int reqEmailMinLength = 5;
    private final int reqEmailMaxLength = 255;

    private final int reqPhoneMinLength = 9;
    private final int reqPhoneMaxLength = 10;

    private final int reqInfoMinLength = 1;
    private final int reqInfoMaxLength = 999;

    private UserRequirement() {
    }

    public static UserRequirement getUserRequirement() {
        if (userRequirement == null) {
            userRequirement = new UserRequirement();
        }
        return userRequirement;
    }

    public int getReqUsernameMinLength() {
        return reqUsernameMinLength;
    }

    public int getReqUsernameMaxLength() {
        return reqUsernameMaxLength;
    }

    public int getReqPasswordMinLength() {
        return reqPasswordMinLength;
    }

    public int getReqPasswordMaxLength() {
        return reqPasswordMaxLength;
    }

    public int getReqDisplaynameMinLength() {
        return reqDisplaynameMinLength;
    }

    public int getReqDisplaynameMaxLength() {
        return reqDisplaynameMaxLength;
    }

    public int getReqFirstnameMinLength() {
        return reqFirstnameMinLength;
    }

    public int getReqFirstnameMaxLength() {
        return reqFirstnameMaxLength;
    }

    public int getReqLastnameMinLength() {
        return reqLastnameMinLength;
    }

    public int getReqLastnameMaxLength() {
        return reqLastnameMaxLength;
    }

    public int getReqEmailMinLength() {
        return reqEmailMinLength;
    }

    public int getReqEmailMaxLength() {
        return reqEmailMaxLength;
    }

    public int getReqPhoneMinLength() {
        return reqPhoneMinLength;
    }

    public int getReqPhoneMaxLength() {
        return reqPhoneMaxLength;
    }

    public int getReqInfoMinLength() {
        return reqInfoMinLength;
    }

    public int getReqInfoMaxLength() {
        return reqInfoMaxLength;
    }

}
