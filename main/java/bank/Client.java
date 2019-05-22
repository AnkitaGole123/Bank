package bank;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        Account ankita = new Account("Ankita", "557346758",0, new Date(2019, 5, 21));
        ankita.credit(100, new Date(2019, 5, 23));
        ankita.debit(15);
        System.out.println(ankita);
        ankita.getBalance(3);

    }
}
