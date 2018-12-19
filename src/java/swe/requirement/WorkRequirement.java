package swe.requirement;

/**
 *
 * @author Ben
 */
public class WorkRequirement {

    private static WorkRequirement workRequirement;

    private final int titleMinLength = 1;
    private final int titleMaxLength = 20;

    private final int languageMinLength = 2;
    private final int languageMaxLength = 15;

    private final int descMinLength = 1;
    private final int descMaxLength = 500;

    private final double priceMin = 0;
    private final double priceMax = 100000;

    private WorkRequirement() {
    }

    public static WorkRequirement getWorkRequirement() {
        if (workRequirement == null) {
            workRequirement = new WorkRequirement();
        }
        return workRequirement;
    }

    public int getTitleMinLength() {
        return titleMinLength;
    }

    public int getTitleMaxLength() {
        return titleMaxLength;
    }

    public int getLanguageMinLength() {
        return languageMinLength;
    }

    public int getLanguageMaxLength() {
        return languageMaxLength;
    }

    public int getDescMinLength() {
        return descMinLength;
    }

    public int getDescMaxLength() {
        return descMaxLength;
    }

    public double getPriceMin() {
        return priceMin;
    }

    public double getPriceMax() {
        return priceMax;
    }

}
