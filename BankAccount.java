package atm;
import java.util.ArrayList;

public class BankAccount {
    double balance;
    ArrayList<Transaction> transactionHistory;

    public BankAccount(double balance) {
        this.balance = balance;
        transactionHistory = new ArrayList<>();
    }
    
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount, "Cash Deposit", balance));
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount, "Cash Withdrawal", balance));
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(double amount, String toUser) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Transfer", amount, "To: " + toUser, balance));
            return true;
        } else {
            return false;
        }
    }

    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("\nNo transactions yet.");
        } else {
            System.out.println("\n------ FULL TRANSACTION HISTORY -----");
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    public void printMiniStatement() {
        System.out.println("\n===== MINI STATEMENT (Last 5 Transactions) =====");
        int size = transactionHistory.size();
        if (size == 0) {
            System.out.println("No transactions yet.");
            return;
        }
        for (int i = Math.max(0, size - 5); i < size; i++) {
            System.out.println(transactionHistory.get(i));
        }
    }

    public void checkBalance() {
        System.out.println("\nCurrent Balance: ₹" + balance);
    }
}








