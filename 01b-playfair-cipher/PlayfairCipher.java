import java.util.Scanner;

public class PlayfairCipher {
    private static final char[][] table = new char[5][5];
    private static final int[] row = new int[26];
    private static final int[] col = new int[26];

    private static String clean(String s) {
        return s.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
    }

    private static void buildTable(String key) {
        boolean[] used = new boolean[26];
        String sequence = clean(key) + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        int k = 0;
        for (char ch : sequence.toCharArray()) {
            if (ch == 'J') ch = 'I';
            if (!used[ch - 'A']) {
                used[ch - 'A'] = true;
                table[k / 5][k % 5] = ch;
                row[ch - 'A'] = k / 5;
                col[ch - 'A'] = k % 5;
                k++;
            }
        }
    }

    private static String prepare(String input) {
        String s = clean(input);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length();) {
            char a = s.charAt(i++);
            char b = 'X';
            if (i < s.length()) {
                char next = s.charAt(i);
                if (a != next) {
                    b = next;
                    i++;
                }
            }
            out.append(a).append(b);
        }
        return out.toString();
    }

    private static String transform(String text, int direction) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i), b = text.charAt(i + 1);
            int r1 = row[a - 'A'], c1 = col[a - 'A'];
            int r2 = row[b - 'A'], c2 = col[b - 'A'];
            if (r1 == r2) {
                c1 = Math.floorMod(c1 + direction, 5);
                c2 = Math.floorMod(c2 + direction, 5);
            } else if (c1 == c2) {
                r1 = Math.floorMod(r1 + direction, 5);
                r2 = Math.floorMod(r2 + direction, 5);
            } else {
                int temp = c1; c1 = c2; c2 = temp;
            }
            out.append(table[r1][c1]).append(table[r2][c2]);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key: ");
        buildTable(sc.nextLine());
        System.out.print("Enter plaintext: ");
        String prepared = prepare(sc.nextLine());
        String encrypted = transform(prepared, 1);
        System.out.println("Prepared text: " + prepared);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted prepared text: " + transform(encrypted, -1));
        System.out.println("Note: Remove filler X characters manually when interpreting the plaintext.");
    }
}
