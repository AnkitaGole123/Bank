package bank;

import java.util.Date;

public class Transaction {
    public  String number;
    public Date transactionDate;
    public double transaction;

    public Transaction(String number, Date transactionDate, double transaction) {
        this.number = number;
        this.transactionDate = transactionDate;
        this.transaction = transaction;
    }
}
