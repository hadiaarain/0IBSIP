public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("My Bank");

        // Dummy Accounts
        bank.addAccount(new Account("1001", "1234", 15000));
        bank.addAccount(new Account("1002", "5678", 8000));
        bank.addAccount(new Account("1003", "1111", 5000));

        ATM atm = new ATM(bank);
        atm.start();
    }
}