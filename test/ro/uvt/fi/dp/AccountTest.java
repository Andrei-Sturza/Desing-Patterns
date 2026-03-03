package ro.uvt.fi.dp;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void testDeposit()
    {
        Account acc = new Account("RON123", 140, Account.TYPE.RON);

        acc.depose(50);

        assertEquals(195.7, acc.getTotalAmount(), 0.0001);
    }

    @Test
    public void testWithdraw()
    {
        Account acc = new Account("RON123", 100, Account.TYPE.RON);

        acc.retrieve(90);

        assertEquals(10.3, acc.getTotalAmount(), 0.0001);
    }

    @Test
    public void testOverWithdraw()
    {
        Account acc = new Account("RON 123", 250, Account.TYPE.RON);

        acc.retrieve(300);

        assertEquals(257.5, acc.getTotalAmount(), 0.0001);
    }
}
