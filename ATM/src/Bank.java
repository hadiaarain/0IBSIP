import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Account> accounts=new ArrayList<>();

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void addAccount(Account account) {
        
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void displayAccounts() {
        System.out.println("Accounts in " + bankName + ":");
        System.out.println("================================");
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getuID() +"\n"+"Balance: " + account.getBalance()+"\n");
        }
        System.out.println("================================");
    }
    
}
