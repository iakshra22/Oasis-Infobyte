package atm;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    String type;
    double amount;
    String details;
    String dateTime;
    double balanceAfter;

    public Transaction(String type, double amount, String details, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.details = details;
        this.balanceAfter = balanceAfter;
        this.dateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    }

    public String toString() {
        return "[" + dateTime + "] " + type + " of ₹" + amount +
               " | " + details + " | Balance: ₹" + balanceAfter;
    }
}








