import java.security.*;

public class SHA1Digest {
    public static void main(String[] args) throws Exception {
        String msg = "HELLO";

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(msg.getBytes());

        String hex = "";
        for (byte b : digest)
            hex += String.format("%02x", b);

        System.out.println("Original Text : " + msg);
        System.out.println("SHA-1 Digest : " + hex);
    }
}
// import java.nio.charset.StandardCharsets;
// import java.security.MessageDigest;
// import java.util.Scanner;

// public class SHA1Digest {
// public static void main(String[] args) throws Exception {
// Scanner sc = new Scanner(System.in);
// System.out.print("Enter input text: ");
// String input = sc.nextLine();
// byte[] digest =
// MessageDigest.getInstance("SHA-1").digest(input.getBytes(StandardCharsets.UTF_8));
// StringBuilder hex = new StringBuilder();
// for (byte b : digest) hex.append(String.format("%02x", b & 0xff));
// System.out.println("Original text: " + input);
// System.out.println("SHA-1 digest: " + hex);
// System.out.println("SHA-1 is obsolete for security-sensitive use.");
// }
// }
