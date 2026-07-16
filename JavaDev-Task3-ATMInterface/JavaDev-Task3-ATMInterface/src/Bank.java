import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Account> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        accounts = new ArrayList<>();
    }

    // Add Account
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Find Account using User ID
    public Account findAccount(String userId) {

        for (Account account : accounts) {

            if (account.getUserId().equals(userId)) {
                return account;
            }
        }

        return null;
    }

    // Login Verification
    public Account login(String userId, String pin) {

        Account account = findAccount(userId);

        if (account != null && account.verifyPin(pin)) {
            return account;
        }

        return null;
    }

    // Display All Accounts (Optional - for testing)
    public void displayAccounts() {

        System.out.println("\n========== " + bankName + " Accounts ==========");

        for (Account account : accounts) {

            System.out.println("-----------------------------");
            System.out.println("User ID : " + account.getUserId());
            System.out.println("Balance : Rs. " + account.getBalance());
        }

        System.out.println("-----------------------------");
    }
}
