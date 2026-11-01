import javax.crypto.*;
import java.util.Base64;

public class AES {
    public static void main(String[] args) throws Exception {
        String msg = "HELLO";

        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);
        SecretKey key = kg.generateKey();

        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        String enc = Base64.getEncoder().encodeToString(c.doFinal(msg.getBytes()));

        c.init(Cipher.DECRYPT_MODE, key);
        String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));

        System.out.println("AES Encryption");
        System.out.println("Original : " + msg);
        System.out.println("Encrypted : " + enc);
        System.out.println("Decrypted : " + dec);
    }
}
// import javax.crypto.Cipher;
// import javax.crypto.KeyGenerator;
// import javax.crypto.SecretKey;
// import javax.crypto.spec.GCMParameterSpec;
// import java.nio.charset.StandardCharsets;
// import java.security.SecureRandom;
// import java.util.Base64;

// public class AESExample {
// public static void main(String[] args) throws Exception {
// String message = "www.annauniv.edu";
// KeyGenerator generator = KeyGenerator.getInstance("AES");
// generator.init(128);
// SecretKey key = generator.generateKey();

// byte[] nonce = new byte[12];
// new SecureRandom().nextBytes(nonce);
// Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
// cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(128, nonce));
// byte[] encrypted = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

// cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(128, nonce));
// byte[] decrypted = cipher.doFinal(encrypted);

// System.out.println("Original text: " + message);
// System.out.println("Nonce (Base64): " +
// Base64.getEncoder().encodeToString(nonce));
// System.out.println("Encrypted text (Base64): " +
// Base64.getEncoder().encodeToString(encrypted));
// System.out.println("Decrypted text: " + new String(decrypted,
// StandardCharsets.UTF_8));
// }
// }
