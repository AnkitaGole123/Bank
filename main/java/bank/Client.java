package bank;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        Account ankita = new Account("Ankita", "123", 0);
        ankita.credit(200, new Date(2019, 5, 27));
        ankita.debit(200, new Date(2019, 5, 28));
        for (Transaction transaction :ankita.getPassbook()) {
            System.out.println(transaction);
        }
    }
}
