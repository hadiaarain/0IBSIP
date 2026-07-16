import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner sc;

    public ATM(Bank bank) {
        this.bank = bank;
        sc = new Scanner(System.in);
    }

    public void start() {

        System.out.println("==================================");
        System.out.println("         ATM INTERFACE");
        System.out.println("==================================");

        int attempts = 3;
        Account currentAccount = null;

        // Login
        while (attempts > 0) {

            System.out.print("Enter User ID : ");
            String userId = sc.next();

            System.out.print("Enter PIN : ");
            String pin = sc.next();

            currentAccount = bank.login(userId, pin);

            if (currentAccount != null) {
                System.out.println("\nLogin Successful!\n");
                break;
            }

            attempts--;

            if (attempts > 0) {
                System.out.println("Invalid User ID or PIN.");
                System.out.println("Attempts Remaining : " + attempts);
            }
        }

        if (currentAccount == null) {
            System.out.println("\nToo many failed attempts.");
            System.out.println("Account Locked.");
            return;
        }

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("            MAIN MENU");
            System.out.println("==================================");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.println("==================================");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    currentAccount.showTransactionHistory();
                    break;

                case 2:

                    System.out.print("Enter amount : ");
                    double withdraw = sc.nextDouble();

                    currentAccount.withdraw(withdraw);

                    break;

                case 3:

                    System.out.print("Enter amount : ");
                    double deposit = sc.nextDouble();

                    currentAccount.deposit(deposit);

                    break;

                case 4:

                    System.out.print("Enter Receiver User ID : ");
                    String receiverId = sc.next();

                    Account receiver = bank.findAccount(receiverId);

                    if (receiver == null) {
                        System.out.println("Receiver account not found.");
                        break;
                    }

                    if (receiver == currentAccount) {
                        System.out.println("Cannot transfer to your own account.");
                        break;
                    }

                    System.out.print("Enter Amount : ");
                    double amount = sc.nextDouble();

                    currentAccount.transfer(receiver, amount);

                    break;

                case 5:

                    System.out.println("Current Balance : Rs. "
                            + currentAccount.getBalance());

                    break;

                case 6:

                    System.out.println("\nThank you for using our ATM.");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);
    }
}