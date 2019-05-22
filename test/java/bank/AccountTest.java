package bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class AccountTest {

    public static final Date TODAY = new Date(2019, 5, 21);

    @Test public void itsCurrentBalance0credit100(){
        Account ankita = new Account("Ankita", "3456787578", 0, TODAY);
        ankita.credit(100, new Date(2019, 5, 23));
        assertEquals( 100.0,ankita.getBalance(),1);
    }

    @Test public void itShouldNotChangeCurrentBalanceAfterGivingCreditAndDebitSameAmount(){
        Account ankita = new Account("Ankita", "3456787578", 100, TODAY);
        ankita.credit(10, new Date(2019, 5, 23));
        ankita.debit(10);
        assertEquals( 100.0,ankita.getBalance(),1);
    }
    @Test public void itShouldVerifyingThatOneAccountShouldNotEffectAnotherAccount(){
        Account ankita = new Account("Ankita", "3456787578", 0, TODAY);
        Account pooja = new Account("Pooja", "3456787578", 0, TODAY);
        ankita.credit(1000, new Date(2019, 5, 23));
        pooja.credit(200, new Date(2019, 5, 23));
        assertEquals( 1000.0,ankita.getBalance(),1);
        assertEquals( 200.0,pooja.getBalance(),1);
    }
    @Test public void itsShouldNotChangeBalanceIfDebitIsMoreThenBalance(){
        Account ankita = new Account("Ankita", "3456787578", 100, TODAY);
        ankita.debit(200);
        assertEquals(100 ,ankita.getBalance(),1);
    }
    @Test public void itShouldGiveNetAmountAfterTakingInterest(){
        Account ankita = new Account("Ankita", "3456787578", 100, TODAY);
        assertEquals(100 ,ankita.getBalance(0),1);
        assertEquals(110 ,ankita.getBalance(1),1);
        assertEquals(120 ,ankita.getBalance(2),1);
        assertEquals(200 ,ankita.getBalance(10),1);
    }
    @Test public void ifNoTransactionItShouldGiveEmptyList(){
        Account ankita = new Account("Ankita", "3456787578", 0, TODAY);
        List<Transaction> expected = new ArrayList<>();
        assertEquals(expected ,ankita.getPassbook());
    }
    @Test public void ifOneTransactionIsDoneGetBackOneTransaction(){
        Account ankita = new Account("Ankita", "3456787578", 0, TODAY);
        List<Transaction> expected = new ArrayList<>();
        Transaction credit = new Transaction("3456787578",TODAY,100);
        expected.add(credit);
        ankita.credit(100,TODAY);
        assertEquals(expected.get(0),ankita.getPassbook().get(0));

    }
}
