package swe.model;

/**
 *
 * @author Ben
 */
public class Translator extends User {

    private String verifyTime;
    private String idCardImage;
    private String idCardSelfie;

    public Translator(String username) {
        super(username);
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getIdCardImage() {
        return idCardImage;
    }

    public void setIdCardImage(String idCardImage) {
        this.idCardImage = idCardImage;
    }

    public String getIdCardSelfie() {
        return idCardSelfie;
    }

    public void setIdCardSelfie(String idCardSelfie) {
        this.idCardSelfie = idCardSelfie;
    }

}
