package swe;

/**
 * Singleton service for checking input value
 *
 * @author Ben
 */
public class InputService {

    private static InputService service;

    private InputService() {
    }

    /**
     * Return instance of service for further use
     *
     * @return
     */
    public static InputService getService() {
        if (service == null) {
            service = new InputService();
        }
        return service;
    }

    public final boolean verifyString(String string, int min, int max) {
        return !checkVoidString(string)
                && checkMinLengthString(string, min)
                && checkMaxLengthString(string, max);
    }

    public final boolean verifyString(String string, int min, int max, String[] contain) {
        return verifyString(string, min, max)
                && checkStringContainChar(string, contain);
    }

    public final boolean verifyNumber(double value, double min, double max) {
        return checkMinNumber(value, min)
                && checkMaxNumber(value, max);
    }

    public boolean verifyNumber(String value, double min, double max) {
        return !checkVoidString(value)
                && verifyNumber(Double.parseDouble(value), min, max);
    }

    /**
     * @param string
     * @return true if string is null or empty, false otherwise
     */
    public boolean checkVoidString(String string) {
        return string == null || string.isEmpty();
    }

    public boolean checkMinLengthString(String string, int min) {
        return string.length() >= min;
    }

    public boolean checkMaxLengthString(String string, int max) {
        return string.length() <= max;
    }

    public boolean checkStringContainChar(String string, String[] collection) {
        boolean flag = true;
        for (String s : collection) {
            if (!string.contains(s)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean checkMinNumber(double value, double min) {
        return value >= min;
    }

    public boolean checkMaxNumber(double value, double max) {
        return value <= max;
    }
}
