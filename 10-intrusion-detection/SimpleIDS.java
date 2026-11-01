import java.util.Scanner;

public class SimpleIDS {
    // Safe classroom demonstration: detects selected suspicious text patterns in sample log lines.
    private static boolean isSuspicious(String line) {
        String s = line.toLowerCase();
        return s.contains("failed login") ||
               s.contains("port scan") ||
               s.contains("multiple password attempts") ||
               s.contains("malware detected");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Simple Intrusion Detection System demonstration");
        System.out.println("Enter log lines. Type EXIT to stop.");
        while (true) {
            System.out.print("Log> ");
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("EXIT")) break;
            if (isSuspicious(line))
                System.out.println("ALERT: Suspicious activity detected.");
            else
                System.out.println("OK: No configured pattern detected.");
        }
    }
}
