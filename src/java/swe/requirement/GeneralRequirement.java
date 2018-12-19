package swe.requirement;

/**
 *
 * @author Ben
 */
public class GeneralRequirement {

    private static GeneralRequirement generalRequirement;

    private final int reqTagMinLength = 1;
    private final int reqTagMaxLength = 15;

    private GeneralRequirement() {
    }

    public static GeneralRequirement getGeneralRequirement() {
        if (generalRequirement == null) {
            generalRequirement = new GeneralRequirement();
        }
        return generalRequirement;
    }

    public int getReqTagMinLength() {
        return reqTagMinLength;
    }

    public int getReqTagMaxLength() {
        return reqTagMaxLength;
    }

}
