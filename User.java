package atm;

public class User {
    String userId;
    String userPin;
    BankAccount account;
    boolean isLocked = false;

    public User(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.account = new BankAccount(balance);
    }

    public void changePin(String newPin) {
        this.userPin = newPin;
        System.out.println("PIN changed successfully!");
    }
}

