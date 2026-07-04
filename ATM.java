import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner input;

    public ATM() {
        bank = new Bank();
        input = new Scanner(System.in);
    }

    public void start() {

        while (true) {

            System.out.println("\n=========================");
            System.out.println("      ATM MACHINE");
            System.out.println("=========================");
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    login();
                    break;

                case 2:
                    createAccount();
                    break;

                case 3:
                    System.out.println("Thank you for using ATM!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
	
	private void login() {

        System.out.print("Enter Account Number: ");
        String accNo = input.next();

        System.out.print("Enter PIN: ");
        String pin = input.next();

        Account account = bank.login(accNo, pin);

        if (account != null) {
            System.out.println("\nLogin Successful!");
            userMenu(account);
        } else {
            System.out.println("Invalid Account Number or PIN!");
        }
    }
	
	private void createAccount() {

        System.out.print("Enter Account Number: ");
        String accNo = input.next();

        System.out.print("Enter Name: ");
        String name = input.next();

        System.out.print("Enter PIN: ");
        String pin = input.next();

        System.out.print("Enter Initial Balance: ");
        double balance = input.nextDouble();

        bank.createAccount(accNo, name, pin, balance);
    }
	
	private void userMenu(Account account) {

        while (true) {

            System.out.println("\n=========================");
            System.out.println("Welcome " + account.getCustomerName());
            System.out.println("=========================");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Mini Statement");
            System.out.println("6. Change PIN");
            System.out.println("7. Logout");
            System.out.print("Choose: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    bank.balanceInquiry(account.getAccountNumber());
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    double dep = input.nextDouble();
                    bank.deposit(account.getAccountNumber(), dep);
                    break;

                case 3:
                    System.out.print("Enter Amount: ");
                    double w = input.nextDouble();
                    bank.withdraw(account.getAccountNumber(), w);
                    break;

                case 4:
                    System.out.print("Enter Receiver Account: ");
                    String rAcc = input.next();

                    System.out.print("Enter Amount: ");
                    double amt = input.nextDouble();

                    bank.transfer(account.getAccountNumber(), rAcc, amt);
                    break;

                case 5:
                    bank.miniStatement(account.getAccountNumber());
                    break;

                case 6:
                    System.out.print("Enter Old PIN: ");
                    String oldPin = input.next();

                    System.out.print("Enter New PIN: ");
                    String newPin = input.next();

                    bank.changePin(account.getAccountNumber(), oldPin, newPin);
                    break;

                case 7:
                    System.out.println("Logged out successfully!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}