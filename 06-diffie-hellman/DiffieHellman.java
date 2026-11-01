import java.util.Scanner;

public class DiffieHellman {
    private static long modPow(long base, long exponent, long modulus) {
        long result = 1;
        base %= modulus;
        while (exponent > 0) {
            if ((exponent & 1) == 1) result = (result * base) % modulus;
            base = (base * base) % modulus;
            exponent >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long p = 23, g = 5;
        System.out.println("Public prime p = " + p + ", base g = " + g);
        System.out.print("Enter Alice's private value (record example: 4): ");
        long a = Long.parseLong(sc.nextLine().trim());
        System.out.print("Enter Bob's private value (record example: 3): ");
        long b = Long.parseLong(sc.nextLine().trim());

        long A = modPow(g, a, p);
        long B = modPow(g, b, p);
        long aliceSecret = modPow(B, a, p);
        long bobSecret = modPow(A, b, p);

        System.out.println("Alice sends: " + A);
        System.out.println("Bob sends: " + B);
        System.out.println("Alice shared secret: " + aliceSecret);
        System.out.println("Bob shared secret: " + bobSecret);
        System.out.println(aliceSecret == bobSecret ? "Success: shared secrets match." : "Error: secrets do not match.");
        System.out.println("Small parameters are for demonstration only.");
    }
}
