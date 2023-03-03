import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class Var1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of lines to input: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] lines = new String[n];

        int totalLength = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a line: ");
            lines[i] = scanner.nextLine();
            totalLength += lines[i].length();
        }
        double averageLength = (double) totalLength / n;

        System.out.println("Lines with length less than the average (" + averageLength + "):");
        for (int i = 0; i < n; i++) {
            if (lines[i].length() < averageLength) {
                System.out.println(lines[i] + " (length: " + lines[i].length() + ")");
            }
        }
        System.out.println("Lines with length greater than the average (" + averageLength + "):");
        for (int i = 0; i < n; i++) {
            if (lines[i].length() > averageLength) {
                System.out.println(lines[i] + " (length: " + lines[i].length() + ")");
            }
        }

        System.out.println(GetMetaData());

        scanner.close();
    }

    public static String GetMetaData() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, Calendar.MARCH);
        cal.set(Calendar.DAY_OF_MONTH, 3);
        cal.set(Calendar.HOUR, 10);
        cal.set(Calendar.MINUTE, 30);
        Date receivingDate = cal.getTime();

        Date now = new Date();

        return "Developer: Igor Barishpol\n" + "Task received on: " + receivingDate + "\nTask delivered on: " + now;
    }
}