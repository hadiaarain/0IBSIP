public class Transaction {
    public static String type;
    public static double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public static String transactionHistory() {
        return "Transaction Type: " + type + ", Amount: " + amount;
    }
    
}
