package swe.requirement;

/**
 *
 * @author Ben
 */
public class GeneralRequirement {

    private static GeneralRequirement generalRequirement;

    private final int tagMinLength = 1;
    private final int tagMaxLength = 15;

    private GeneralRequirement() {
    }

    public static GeneralRequirement getGeneralRequirement() {
        if (generalRequirement == null) {
            generalRequirement = new GeneralRequirement();
        }
        return generalRequirement;
    }

    public int getTagMinLength() {
        return tagMinLength;
    }

    public int getTagMaxLength() {
        return tagMaxLength;
    }

}
