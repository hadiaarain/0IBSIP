public class Main {
    public static void main(String[] args){
       Account account = new Account("1990", "JasonBell123", 1000.0);
       Bank bank = new Bank("MyBank");
       bank.addAccount(account);
       Account account2 = new Account("1991", "JohnDoe456", 500.0);
       bank.addAccount(account2);
       bank.displayAccounts();

       account.getuID();
       account.getUpin();
       account.verifyUser(1990, "JasonBell123");
       account.deposit(200.0);
       account.withdraw(150.0);
       account.displayTransactionHistory();
       System.out.println("================================");

       account.getuID();
       account2.verifyUser(1991, "JohnDoe456");
       account2.deposit(100.0);
       account2.withdraw(50.0);
       account2.displayTransactionHistory();

       ATM atm = new ATM(account);
       atm.startATM();
    }
}
