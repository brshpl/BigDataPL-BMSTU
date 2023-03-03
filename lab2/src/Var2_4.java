import java.util.Scanner;

public class Var2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dimension of the matrix: ");
        int n = scanner.nextInt();

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            boolean foundFirstPositive = false;
            int firstPositiveIndex = -1;
            for (int j = 0; j < n; j++) {
                if (a[i][j] > 0) {
                    if (!foundFirstPositive) {
                        foundFirstPositive = true;
                        firstPositiveIndex = j;
                    } else {
                        for (int k = firstPositiveIndex + 1; k < j; k++) {
                            sum += a[i][k];
                        }
                        break;
                    }
                }
            }
        }

        System.out.println("Matrix:");
        Var2_3.PrintMatrix(a);
        System.out.println("Sum of elements between first and second positive elements of each row: " + sum);

        scanner.close();
    }
}
