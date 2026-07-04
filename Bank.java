import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

   
    public Bank() {
        accounts = new ArrayList<>();

        accounts.add(new Account("1001", "Sadeesha", "1234", 10000));
        accounts.add(new Account("1002", "Kamal", "5678", 15000));
        accounts.add(new Account("1003", "Nimal", "4321", 20000));
    }

    public Account findAccount(String accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }

        }

        return null;
    }

    public Account login(String accountNumber, String pin) {

        Account account = findAccount(accountNumber);

        if (account != null && account.getPin().equals(pin)) {
            return account;
        }

        return null;
    }

    public void createAccount(String accountNumber,
                              String customerName,
                              String pin,
                              double balance) {

        if (findAccount(accountNumber) != null) {
            System.out.println("Account Number Already Exists!");
            return;
        }

        accounts.add(new Account(accountNumber,
                                 customerName,
                                 pin,
                                 balance));

        System.out.println("Account Created Successfully!");
    }

    public void displayAllAccounts() {

        System.out.println("\n===== ALL ACCOUNTS =====");

        for (Account account : accounts) {
            account.displayAccountDetails();
        }

    }
	    
    public void deposit(String accountNumber, double amount) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        account.deposit(amount);
    }

    
    public void withdraw(String accountNumber, double amount) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        account.withdraw(amount);
    }

    
    public void balanceInquiry(String accountNumber) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        System.out.println("\n========== BALANCE ==========");
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Customer Name  : " + account.getCustomerName());
        System.out.println("Current Balance: Rs. " + account.getBalance());
    }

    
    public void changePin(String accountNumber,
                          String oldPin,
                          String newPin) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        if (!account.getPin().equals(oldPin)) {
            System.out.println("Incorrect Old PIN!");
            return;
        }

        account.changePin(newPin);
    }

    
    public void transfer(String senderAccount,
                         String receiverAccount,
                         double amount) {

        Account sender = findAccount(senderAccount);
        Account receiver = findAccount(receiverAccount);

        if (sender == null) {
            System.out.println("Sender Account Not Found!");
            return;
        }

        if (receiver == null) {
            System.out.println("Receiver Account Not Found!");
            return;
        }

        if (sender.withdraw(amount)) {

            receiver.deposit(amount);

            sender.addTransaction(
                    new Transaction(
                            "Transfer To " + receiverAccount,
                            amount));

            receiver.addTransaction(
                    new Transaction(
                            "Transfer From " + senderAccount,
                            amount));

            System.out.println("Transfer Successful!");
        }
    }

    
    public void deleteAccount(String accountNumber) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        accounts.remove(account);

        System.out.println("Account Deleted Successfully!");
    }

    
    public void miniStatement(String accountNumber) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        account.displayMiniStatement();
    }

}