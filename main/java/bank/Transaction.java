package bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    public  String number;
    public Date transactionDate;
    public double transaction;

    @Override
    // this is statement
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.transaction, transaction) == 0 &&
                Objects.equals(number, that.number) &&
                Objects.equals(transactionDate, that.transactionDate);
    }

    public Transaction(String number, Date transactionDate, double transaction) {
        this.number = number;
        this.transactionDate = transactionDate;
        this.transaction = transaction;
    }
}
