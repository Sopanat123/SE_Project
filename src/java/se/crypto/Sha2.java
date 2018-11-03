package se.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Provide SHA-2 function for hashing a plain text.
 * 
 * @author Ben
 */
public final class Sha2 {

    /**
     * generates hash text with SHA-256 algorithm, using plain text.
     * 
     * @param text a plain text
     * @return hashed text
     * @throws NoSuchAlgorithmException 
     */
    public static final String sha256(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64.getEncoder().encodeToString(hash);
        return encoded;
    }

    /**
     * generates hash plain text with SHA-512 algorithm, using plain text and salt text.
     * 
     * @param text a plain text
     * @param salt a text for mix up with plain text
     * @return hashed text
     * @throws NoSuchAlgorithmException 
     */
    public static final String sha512(String text, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = md.digest(text.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String encoded = sb.toString();
        return encoded;
    }
}
