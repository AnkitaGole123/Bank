package bank;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
public class AccountTest {
    @Test public void itsCurrentBalance0credit100(){
        Account ankita = new Account("Ankita", "3456787578", 0, new Date(2019, 5, 21));
        ankita.credit(100);
        assertEquals( 100.0,ankita.getBalance(),1);
    }

    @Test public void itShouldNotChangeCurrentBalanceAfterGivingCreditAndDebitSameAmount(){
        Account ankita = new Account("Ankita", "3456787578", 100, new Date(2019, 5, 21));
        ankita.credit(10);
        ankita.debit(10);
        assertEquals( 100.0,ankita.getBalance(),1);
    }
    @Test public void itShouldVerifyingThatOneAccountShouldNotEffectAnotherAccount(){
        Account ankita = new Account("Ankita", "3456787578", 0, new Date(2019, 5, 21));
        Account pooja = new Account("Pooja", "3456787578", 0, new Date(2019, 5, 21));
        ankita.credit(1000);
        pooja.credit(200);
        assertEquals( 1000.0,ankita.getBalance(),1);
        assertEquals( 200.0,pooja.getBalance(),1);
    }
    @Test public void itsShouldNotChangeBalanceIfDebitIsMoreThenBalance(){
        Account ankita = new Account("Ankita", "3456787578", 100, new Date(2019, 5, 21));
        ankita.debit(200);
        assertEquals(100 ,ankita.getBalance(),1);
    }
    @Test public void itShouldGiveNetAmountAfterTakingInterest(){
        Account ankita = new Account("Ankita", "3456787578", 100, new Date(2019, 5, 21));
        assertEquals(100 ,ankita.getBalance(0),1);
        assertEquals(110 ,ankita.getBalance(1),1);
        assertEquals(120 ,ankita.getBalance(2),1);
        assertEquals(200 ,ankita.getBalance(10),1);
    }
}
