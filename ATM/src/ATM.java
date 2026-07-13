import java.util.Scanner;

public class ATM{
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public static void menu(){
         int choice=0;

        System.out.println("================================");
        System.out.println("   ATM INTERFACE   ");
        System.out.println("================================");
        System.out.println("   1. Transaction History   ");
        System.out.println("   2. Withdraw   ");
        System.out.println("   3. Deposit   ");
        System.out.println("   4. Transfer   ");
        System.out.println("   5. Exit   ");
        System.out.println("================================");

    }

    public void startATM(){
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        while(choice!=5){
            menu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    account.displayTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    account.withdraw(new Scanner(System.in).nextDouble());
                    account.displayTransactionHistory();
                    break;
                case 3:
                    account.deposit(new Scanner(System.in).nextDouble());
                    account.displayTransactionHistory();
                    break;
                case 4:
                    System.out.print("Enter the recipient's User ID: ");
                    String recipientID = scanner.next();
                    System.out.print("Enter the amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(new Account("1991", recipientID, 0.0), transferAmount);
                    account.displayTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }}}
    
