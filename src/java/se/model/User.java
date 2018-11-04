package se.model;

/**
 *
 * @author Ben
 */
public class User {

    private String username;
    private String email;
    private String phone;
    private String firstname;
    private String lastname;
    private String displayname;
    private String imageUrl;
    private String privilege;
    private String publicInfo;
    private String tag;
    private String idCardImg;
    private String selfieImg;

    /**
     * Create user object, identify by username
     *
     * @param username user identifier
     */
    public User(String username) {
        this.username = username;
    }

    /**
     * return identifier of this user as String
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getPublicInfo() {
        return publicInfo;
    }

    public void setPublicInfo(String publicInfo) {
        this.publicInfo = publicInfo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIdCardImg() {
        return idCardImg;
    }

    public void setIdCardImg(String idCardImg) {
        this.idCardImg = idCardImg;
    }

    public String getSelfieImg() {
        return selfieImg;
    }

    public void setSelfieImg(String selfieImg) {
        this.selfieImg = selfieImg;
    }
}
