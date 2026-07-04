import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String transactionType;
    private double amount;
    private String dateTime;

   
    public Transaction(String transactionType, double amount) {

        this.transactionType = transactionType;
        this.amount = amount;

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        this.dateTime = LocalDateTime.now().format(formatter);
    }
	
    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getDateTime() {
        return dateTime;
    }
	
    public String toString() {

        return String.format("%-12s Rs. %-10.2f %s",
                transactionType,
                amount,
                dateTime);
    }

}