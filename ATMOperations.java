package atm;
import java.util.Scanner;

public class ATMOperations {
    Scanner sc = new Scanner(System.in);

    public void menu(User user) {
        while (true) {
            System.out.println("\n===== ATM MAIN MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Mini Statement");
            System.out.println("7. Change PIN");
            System.out.println("8. Quit");
            System.out.print("Choose an option: ");

            int choice = getValidInteger();

            switch (choice) {
                case 1: user.account.printTransactionHistory(); break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double wAmount = getValidDouble();
                    if (user.account.withdraw(wAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance or invalid amount!");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double dAmount = getValidDouble();
                    if (dAmount > 0) {
                        user.account.deposit(dAmount);
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;
                case 4:
                    System.out.print("Enter recipient name: ");
                    sc.nextLine();
                    String toUser = sc.nextLine();
                    System.out.print("Enter amount to transfer: ₹");
                    double tAmount = getValidDouble();
                    if (user.account.transfer(tAmount, toUser)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Insufficient balance or invalid amount!");
                    }
                    break;
                case 5: user.account.checkBalance(); break;
                case 6: user.account.printMiniStatement(); break;
                case 7:
                    System.out.print("Enter new PIN: ");
                    sc.nextLine();
                    String newPin = sc.nextLine();
                    user.changePin(newPin);
                    break;
                case 8:
                    System.out.println("\nThank you for using our ATM! Have a nice day!");
                    return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }

    int getValidInteger() {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    double getValidDouble() {
        while (!sc.hasNextDouble()) {
            System.out.print("Please enter a valid amount: ₹");
            sc.next();
        }
        return sc.nextDouble();
    }
}










