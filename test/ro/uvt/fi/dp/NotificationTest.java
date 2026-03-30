package ro.uvt.fi.dp;

import org.junit.Test;
import static org.junit.Assert.*;
public class NotificationTest {

    @Test
    public void testDeposit() //test for depositing
    {
        Operations acc = new Account("RON123", 100, Account.TYPE.RON);
        Operations decoratedAcc = new NotificationAccountDecorator(acc);

        decoratedAcc.depose(50);

        assertEquals(154.5, decoratedAcc.getTotalAmount(), 0.0001);
    }

    @Test
    public void testWithdraw() //test for withdrawal
    {
        Operations acc = new Account("RON123", 100, Account.TYPE.RON);
        Operations decoratedAcc = new NotificationAccountDecorator(acc);

        decoratedAcc.retrieve(30);

        assertEquals(72.1, decoratedAcc.getTotalAmount(), 0.0001);
    }

}
