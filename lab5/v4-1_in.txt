import java.util.Scanner;

public class Var1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String samplePassword = "password123";

        System.out.print("Enter your password: ");
        String userPassword = scanner.nextLine();

        if (userPassword.equals(samplePassword)) {
            System.out.println("Password is correct.");
        } else {
            System.out.println("Password is incorrect.");
        }

        scanner.close();
    }
}