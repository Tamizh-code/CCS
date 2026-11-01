import java.util.Scanner;

public class RailFenceCipher {
    static String encrypt(String text, int rails) {
        if (rails < 2 || rails >= text.length()) return text;
        StringBuilder[] lines = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) lines[i] = new StringBuilder();
        int r = 0, direction = 1;
        for (char ch : text.toCharArray()) {
            lines[r].append(ch);
            if (r == 0) direction = 1;
            else if (r == rails - 1) direction = -1;
            r += direction;
        }
        StringBuilder out = new StringBuilder();
        for (StringBuilder line : lines) out.append(line);
        return out.toString();
    }

    static String decrypt(String cipher, int rails) {
        if (rails < 2 || rails >= cipher.length()) return cipher;
        int n = cipher.length();
        int[] pattern = new int[n];
        int r = 0, direction = 1;
        int[] counts = new int[rails];
        for (int i = 0; i < n; i++) {
            pattern[i] = r;
            counts[r]++;
            if (r == 0) direction = 1;
            else if (r == rails - 1) direction = -1;
            r += direction;
        }
        String[] railText = new String[rails];
        int offset = 0;
        for (int i = 0; i < rails; i++) {
            railText[i] = cipher.substring(offset, offset + counts[i]);
            offset += counts[i];
        }
        int[] positions = new int[rails];
        StringBuilder out = new StringBuilder();
        for (int rail : pattern) out.append(railText[rail].charAt(positions[rail]++));
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String message = sc.nextLine();
        System.out.print("Enter number of rails: ");
        int rails = Integer.parseInt(sc.nextLine().trim());
        String encrypted = encrypt(message, rails);
        System.out.println("Encrypted message: " + encrypted);
        System.out.println("Decrypted message: " + decrypt(encrypted, rails));
    }
}
