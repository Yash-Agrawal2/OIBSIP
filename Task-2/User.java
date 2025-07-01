import java.util.*;

public class User {
    private String userId;
    private String pin;
    private double balance;
    private List<String> transactionHistory;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
            return true;
        } else {
            return false;
        }
    }

    public void transfer(User receiver, double amount) {
        if (balance >= amount) {
            balance -= amount;
            receiver.balance += amount;
            transactionHistory.add("Transferred ₹" + amount + " to " + receiver.userId);
            receiver.transactionHistory.add("Received ₹" + amount + " from " + this.userId);
        }
    }

    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getUserId() {
        return userId;
    }
}
