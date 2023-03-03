import java.util.Scanner;

public class Var1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // sample password
        String samplePassword = "password123";

        // prompt the user to enter a password
        System.out.print("Enter your password: ");
        String userPassword = scanner.nextLine();

        // compare the entered password with the sample password
        if (userPassword.equals(samplePassword)) {
            System.out.println("Password is correct.");
        } else {
            System.out.println("Password is incorrect.");
        }

        // close the scanner
        scanner.close();
    }
}