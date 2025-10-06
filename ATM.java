package atm;
import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, User> users = UserDatabase.getUsers();

        System.out.println("===== Welcome to Secure ATM =====");

        int attempts = 3;
        User loggedInUser = null;

        while (attempts > 0) {
            System.out.print("\nEnter User ID: ");
            String enteredId = sc.nextLine();
            System.out.print("Enter PIN: ");
            String enteredPin = sc.nextLine();

            if (users.containsKey(enteredId)) {
                User u = users.get(enteredId);
                if (u.isLocked) {
                    System.out.println("This account is locked due to multiple failed logins!");
                    break;
                }
                if (u.userPin.equals(enteredPin)) {
                    loggedInUser = u;
                    System.out.println("\nLogin Successful! Welcome, User " + enteredId + "!");
                    break;
                } else {
                    attempts--;
                    System.out.println("Wrong PIN! Attempts left: " + attempts);
                    if (attempts == 0) {
                        u.isLocked = true;
                        System.out.println("Account locked due to multiple failed attempts!");
                    }
                }
            } else {
                attempts--;
                System.out.println("User not found! Attempts left: " + attempts);
            }
        }

        if (loggedInUser != null) {
            ATMOperations atm = new ATMOperations();
            atm.menu(loggedInUser);
        } else {
            System.out.println("\nExiting system...");
        }

        sc.close();
    }
}













