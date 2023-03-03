import java.util.Scanner;

public class Var2_3 {
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

        // find the length of the longest increasing or decreasing sequence of elements in each row
        int longestIncreasing = 1;
        int longestDecreasing = 1;
        for (int i = 0; i < n; i++) {
            int increasing = 1;
            int decreasing = 1;
            for (int j = 1; j < n; j++) {
                if (a[i][j] > a[i][j - 1]) {
                    increasing++;
                    decreasing = 1;
                } else if (a[i][j] < a[i][j - 1]) {
                    decreasing++;
                    increasing = 1;
                } else {
                    increasing = 1;
                    decreasing = 1;
                }
                if (increasing > longestIncreasing) {
                    longestIncreasing = increasing;
                }
                if (decreasing > longestDecreasing) {
                    longestDecreasing = decreasing;
                }
            }
        }

        // output the results
        System.out.println("Matrix:");
        PrintMatrix(a);
        System.out.println("Longest increasing sequence length: " + longestIncreasing);
        System.out.println("Longest decreasing sequence length: " + longestDecreasing);

        // close the scanner
        scanner.close();
    }

    public static void PrintMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
