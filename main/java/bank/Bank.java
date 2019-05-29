package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Bank {
    public static void main(String[] args) {
        System.out.println(createAccount("ankita"));
    }
    private static int numberOfAccounts;

    public static Account createAccount(String name){
        numberOfAccounts++;
        Account account = new Account(name,Integer.toString(numberOfAccounts),0);
        return account;
    }
}
