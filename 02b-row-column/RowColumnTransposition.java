import java.util.*;

class RowColumnTransposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String s = sc.nextLine().replaceAll("\\s+", "");

        System.out.print("Enter columns: ");
        int col = sc.nextInt();

        int row = (s.length() + col - 1) / col;
        char[][] a = new char[row][col];
        int k = 0;

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                a[i][j] = k < s.length() ? s.charAt(k++) : 'X';

        StringBuilder cipher = new StringBuilder();

        for (int j = 0; j < col; j++)
            for (int i = 0; i < row; i++)
                cipher.append(a[i][j]);

        System.out.println("Encrypted: " + cipher);

        k = 0;
        for (int j = 0; j < col; j++)
            for (int i = 0; i < row; i++)
                a[i][j] = cipher.charAt(k++);

        StringBuilder plain = new StringBuilder();

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                plain.append(a[i][j]);

        System.out.println("Decrypted: " + plain);
        sc.close();
    }
}
// import java.util.Scanner;

// public class RowColumnTransposition {
// static String encrypt(String text, int columns) {
// String clean = text.replaceAll("\\s+", "");
// StringBuilder out = new StringBuilder();
// for (int c = 0; c < columns; c++)
// for (int i = c; i < clean.length(); i += columns)
// out.append(clean.charAt(i));
// return out.toString();
// }

// static String decrypt(String cipher, int columns) {
// int n = cipher.length();
// int rows = (n + columns - 1) / columns;
// int fullColumns = n % columns;
// if (fullColumns == 0)
// fullColumns = columns;
// char[][] grid = new char[rows][columns];
// int index = 0;
// for (int c = 0; c < columns; c++) {
// int columnLength = (n / columns) + (c < n % columns ? 1 : 0);
// for (int r = 0; r < columnLength; r++)
// grid[r][c] = cipher.charAt(index++);
// }
// StringBuilder out = new StringBuilder();
// for (int r = 0; r < rows; r++)
// for (int c = 0; c < columns; c++)
// if (grid[r][c] != '\0')
// out.append(grid[r][c]);
// return out.toString();
// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// System.out.print("Enter plaintext: ");
// String plain = sc.nextLine();
// System.out.print("Enter number of columns (record uses 4): ");
// int columns = Integer.parseInt(sc.nextLine().trim());
// if (columns < 1) {
// System.out.println("Column count must be positive.");
// return;
// }
// String cipher = encrypt(plain, columns);
// System.out.println("Encrypted text: " + cipher);
// System.out.println("Decrypted text (spaces removed): " + decrypt(cipher,
// columns));
// }
// }
