import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DESExample {
    public static void main(String[] args) throws Exception {
        String message = "Secret Information";
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        generator.init(56);
        SecretKey key = generator.generateKey();

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("Original message: " + message);
        System.out.println("Encrypted (Base64): " + Base64.getEncoder().encodeToString(encrypted));
        System.out.println("Decrypted message: " + new String(decrypted, StandardCharsets.UTF_8));
        System.out.println("Warning: DES is obsolete and shown for lab learning only.");
    }
}
