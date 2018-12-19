package swe.requirement;

/**
 *
 * @author Ben
 */
public class WorkRequirement {

    private static WorkRequirement workRequirement;

    private final int reqTitleMinLength = 1;
    private final int reqTitleMaxLength = 20;

    private final int reqLanguageMinLength = 2;
    private final int reqLanguageMaxLength = 15;

    private final int reqDescMinLength = 1;
    private final int reqDescMaxLength = 500;

    private final double reqPriceMin = 0;
    private final double reqPriceMax = 100000;

    private WorkRequirement() {
    }

    public static WorkRequirement getWorkRequirement() {
        if (workRequirement == null) {
            workRequirement = new WorkRequirement();
        }
        return workRequirement;
    }

    public int getReqTitleMinLength() {
        return reqTitleMinLength;
    }

    public int getReqTitleMaxLength() {
        return reqTitleMaxLength;
    }

    public int getReqLanguageMinLength() {
        return reqLanguageMinLength;
    }

    public int getReqLanguageMaxLength() {
        return reqLanguageMaxLength;
    }

    public int getReqDescMinLength() {
        return reqDescMinLength;
    }

    public int getReqDescMaxLength() {
        return reqDescMaxLength;
    }

    public double getReqPriceMin() {
        return reqPriceMin;
    }

    public double getReqPriceMax() {
        return reqPriceMax;
    }

}
