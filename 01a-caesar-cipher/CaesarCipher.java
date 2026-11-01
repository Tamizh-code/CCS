import java.util.Scanner;

public class CaesarCipher {
    static String encrypt(String text, int shift) {
        shift = Math.floorMod(shift, 26);
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z')
                result.append((char) ('A' + (ch - 'A' + shift) % 26));
            else if (ch >= 'a' && ch <= 'z')
                result.append((char) ('a' + (ch - 'a' + shift) % 26));
            else result.append(ch);
        }
        return result.toString();
    }

    static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plain = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = Integer.parseInt(sc.nextLine().trim());
        String cipher = encrypt(plain, shift);
        System.out.println("Encrypted message: " + cipher);
        System.out.println("Decrypted message: " + decrypt(cipher, shift));
    }
}
