import java.security.*;

public class MD5Digest {
    public static void main(String[] args) throws Exception {
        String s = "cryptography";

        byte[] hash = MessageDigest.getInstance("MD5").digest(s.getBytes());

        String result = "";
        for (byte b : hash)
            result += String.format("%02x", b);

        System.out.println("MD5 Hash : " + result);
    }
}
// import java.nio.charset.StandardCharsets;
// import java.security.MessageDigest;
// import java.util.Scanner;

// public class MD5Digest {
// public static void main(String[] args) throws Exception {
// Scanner sc = new Scanner(System.in);
// System.out.print("Enter input text: ");
// String input = sc.nextLine();
// byte[] digest =
// MessageDigest.getInstance("MD5").digest(input.getBytes(StandardCharsets.UTF_8));
// StringBuilder hex = new StringBuilder();
// for (byte b : digest) hex.append(String.format("%02x", b & 0xff));
// System.out.println("Original text: " + input);
// System.out.println("MD5 digest: " + hex);
// System.out.println("MD5 is obsolete for security-sensitive use.");
// }
// }
