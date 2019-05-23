package bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class AccountTest {

    public static final Date TODAY = new Date(2019, 5, 21);

    @Test public void itsCurrentBalance0credit100(){
        Account ankita = new Account("Ankita", "345", 0, TODAY);
        ankita.credit(100, new Date(2019, 5, 23));
        assertEquals( 100.0,ankita.getBalance(),1);
    }

    @Test public void itShouldNotChangeCurrentBalanceAfterGivingCreditAndDebitSameAmount(){
        Account ankita = new Account("Ankita", "345", 100, TODAY);
        ankita.credit(10, new Date(2019, 5, 23));
        ankita.debit(10,TODAY);
        assertEquals( 100.0,ankita.getBalance(),1);
    }
    @Test public void itShouldVerifyingThatOneAccountShouldNotEffectAnotherAccount(){
        Account ankita = new Account("Ankita", "345", 0, TODAY);
        Account pooja = new Account("Pooja", "345", 0, TODAY);
        ankita.credit(1000, new Date(2019, 5, 23));
        pooja.credit(200, new Date(2019, 5, 23));
        assertEquals( 1000.0,ankita.getBalance(),1);
        assertEquals( 200.0,pooja.getBalance(),1);
    }
    @Test public void itsShouldNotChangeBalanceIfDebitIsMoreThenBalance(){
        Account ankita = new Account("Ankita", "3456", 100, TODAY);
        ankita.debit(200,TODAY);
        assertEquals(100 ,ankita.getBalance(),1);
    }
    @Test public void itShouldGiveNetAmountAfterTakingInterest(){
        Account ankita = new Account("Ankita", "3456", 100, TODAY);
        assertEquals(100 ,ankita.getBalance(0),1);
        assertEquals(110 ,ankita.getBalance(1),1);
        assertEquals(120 ,ankita.getBalance(2),1);
        assertEquals(200 ,ankita.getBalance(10),1);
    }
    @Test public void ifNoTransactionItShouldGiveEmptyList(){
        Account ankita = new Account("Ankita", "3456", 0, TODAY);
        List<Transaction> expected = new ArrayList<>();
        assertEquals(expected ,ankita.getPassbook());
    }
    @Test public void ifOneTransactionIsDoneGetBackOneTransaction(){
        Account ankita = new Account("Ankita", "345", 0, TODAY);
        List<Transaction> expectedTransaction = new ArrayList<>();
        Transaction credit = new Transaction("345",TODAY,100);
        expectedTransaction.add(credit);
        ankita.credit(100,TODAY);
        assertEquals(expectedTransaction,ankita.getPassbook());
    }
    @Test public void ifDebitTransactionIsDoneGetBackDebitTransactionInPassbook(){
        Account ankita = new Account("Ankita", "123", 200, TODAY);
        List<Transaction> expectedTransaction = new ArrayList<>();
        Transaction debit = new Transaction("123",TODAY,100);
        expectedTransaction.add(debit);
        ankita.debit(100,TODAY);
        assertEquals(expectedTransaction,ankita.getPassbook());
    }
    @Test public void ifDebitIsMoreThenBalanceNoTransaction(){
        Account ankita = new Account("Ankita", "123", 0, TODAY);
        List<Transaction> noTransactions = new ArrayList<>();
        ankita.debit(100,TODAY);
        assertEquals(noTransactions,ankita.getPassbook());
    }
    @Test public void ifPassbookShouldHaveMultipleTransaction(){
        Account ankita = new Account("Ankita", "123", 500, TODAY);
        List<Transaction> expectedTransaction = new ArrayList<>();
        Transaction debit = new Transaction("123",TODAY,100);
        Transaction credit = new Transaction("123",TODAY,200);
        expectedTransaction.add(debit);
        expectedTransaction.add(credit);
        ankita.debit(100,TODAY);
        ankita.credit(200,TODAY);
        assertEquals(expectedTransaction,ankita.getPassbook());
    }
}
