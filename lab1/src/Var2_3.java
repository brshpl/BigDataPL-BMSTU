import java.util.Scanner;

public class Var2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers to input: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter an integer: ");
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] % 3 == 0 || arr[i] % 9 == 0) {
                System.out.println(arr[i]);
            }
        }

        // close the scanner
        scanner.close();
    }
}