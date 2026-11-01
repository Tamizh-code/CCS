import java.util.Scanner;

public class HillCipher {
    // Invertible 2x2 key matrix modulo 26: [3 3; 2 5], determinant = 9.
    private static final int A = 3, B = 3, C = 2, D = 5;
    private static final int DET_INVERSE = 3; // 9 * 3 = 27 = 1 (mod 26)

    static String encrypt(String input) {
        String s = input.toUpperCase().replaceAll("[^A-Z]", "");
        if (s.length() % 2 != 0) s += "X";
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            int x = s.charAt(i) - 'A', y = s.charAt(i + 1) - 'A';
            out.append((char) ('A' + (A * x + B * y) % 26));
            out.append((char) ('A' + (C * x + D * y) % 26));
        }
        return out.toString();
    }

    static String decrypt(String input) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < input.length(); i += 2) {
            int x = input.charAt(i) - 'A', y = input.charAt(i + 1) - 'A';
            int p = Math.floorMod(DET_INVERSE * (D * x - B * y), 26);
            int q = Math.floorMod(DET_INVERSE * (-C * x + A * y), 26);
            out.append((char) ('A' + p)).append((char) ('A' + q));
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plain = sc.nextLine();
        String cipher = encrypt(plain);
        System.out.println("Encrypted text: " + cipher);
        System.out.println("Decrypted padded text: " + decrypt(cipher));
    }
}
