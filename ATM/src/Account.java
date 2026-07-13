import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    private int upin;
    private String uID;
    private double balance;
    private ArrayList<Transaction>transactionHistory;
    private static byte attempts=3;
    

    public Account(String upin, String uID, double balance) {
        this.upin = Integer.parseInt(upin);
        this.uID = uID;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getUpin() {
        return upin;
    }

    public String getuID() {
        return uID;
    }

    public double getBalance() {
        return balance;
    }

    public boolean verifyUser(int pin, String id) {
        if (this.upin == pin && this.uID.equals(id)) {
            return true;
        } else {
            attempts--;
            System.out.println("Invalid PIN or User ID. Attempts remaining: " + attempts);
            return false;
        }
       
    }
    

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            System.out.println("Deposit successful"+"\n"+"New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            System.out.println("Withdrawal successful."+"\n"+"New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History for Account ID: " + uID);
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.transactionHistory());
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Transfer", amount));
            System.out.println("Transfer successful."+"\n"+"New balance: " + balance);
        } else {
            System.out.println("Invalid transfer amount or insufficient funds.");
        }
    }
}