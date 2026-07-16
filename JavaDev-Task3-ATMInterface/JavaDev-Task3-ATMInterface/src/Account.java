import java.util.ArrayList;

public class Account {

    private String userId;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        transactionHistory = new ArrayList<>();
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    // Login Verification
    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    // Deposit
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;

        transactionHistory.add(
                new Transaction(
                        "Deposit",
                        amount,
                        "Amount deposited successfully"));

        System.out.println("\nDeposit Successful!");
        System.out.println("Current Balance: Rs. " + balance);
    }

    // Withdraw
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance.");
            return false;
        }

        balance -= amount;

        transactionHistory.add(
                new Transaction(
                        "Withdraw",
                        amount,
                        "Cash Withdrawn"));

        System.out.println("\nWithdrawal Successful!");
        System.out.println("Current Balance: Rs. " + balance);

        return true;
    }

    // Transfer
    public boolean transfer(Account receiver, double amount) {

        if (receiver == null) {
            System.out.println("Receiver account not found.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance.");
            return false;
        }

        // Deduct sender balance
        balance -= amount;

        // Add receiver balance
        receiver.balance += amount;

        // Sender history
        transactionHistory.add(
                new Transaction(
                        "Transfer",
                        amount,
                        "Transferred to " + receiver.getUserId()));

        // Receiver history
        receiver.transactionHistory.add(
                new Transaction(
                        "Received",
                        amount,
                        "Received from " + userId));

        System.out.println("\nTransfer Successful!");
        System.out.println("Transferred Rs. " + amount +
                " to " + receiver.getUserId());
        System.out.println("Current Balance: Rs. " + balance);

        return true;
    }

    // Show Transaction History
    public void showTransactionHistory() {

        System.out.println("\n========== Transaction History ==========");

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }
}