import java.util.Scanner;

public class Var1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of lines to output: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Line " + (i+1));
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Line " + (i+1) + " ");
        }

        scanner.close();
    }
}