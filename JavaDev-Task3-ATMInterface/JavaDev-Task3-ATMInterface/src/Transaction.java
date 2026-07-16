import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private double amount;
    private String details;
    private String dateTime;

    public Transaction(String type, double amount, String details) {
        this.type = type;
        this.amount = amount;
        this.details = details;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        this.dateTime = LocalDateTime.now().format(formatter);
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDetails() {
        return details;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {

        return "--------------------------------------\n"
                + "Type      : " + type + "\n"
                + "Amount    : Rs. " + amount + "\n"
                + "Details   : " + details + "\n"
                + "Date/Time : " + dateTime + "\n"
                + "--------------------------------------";
    }
}
