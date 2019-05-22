package bank;

import java.util.Date;

public class Account {
    public String holderName;
    public String Number;
    private double balance;
    private Date openingDate;
    public final int RATE_OF_INTEREST_PER_ANNUM = 10;

    public Account(String accountHolderName, String accountNumber, double balance, Date openingDate) {
        this.holderName = accountHolderName;
        this.Number = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
    }

    public double getBalance(int year) {
        return balance + (RATE_OF_INTEREST_PER_ANNUM * year * balance)/100;
    }


    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) {
        if(amount < balance){
            this.balance-=amount;
        }
    }

    public double getBalance() {
        return getBalance(0);
    }

    @Override
    public String toString() {
        return holderName + ", " + Number + ", " +balance;
    }
}

