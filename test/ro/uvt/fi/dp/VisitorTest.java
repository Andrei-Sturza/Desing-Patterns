package ro.uvt.fi.dp;

import org.junit.Test;
import static org.junit.Assert.*;

public class VisitorTest {

    @Test
    public void testVisitorDoesNotChangeAccountAmount() {
        Account acc = new Account("RON123", 200, Account.TYPE.RON);
        AccountVisitor visitor = new AccountReportVisitor();

        acc.accept(visitor);

        assertEquals(206, acc.getTotalAmount(), 0.0001);
    }

    @Test
    public void testVisitorDoesNotChangeAccountCode() {
        Account acc = new Account("RON555", 500, Account.TYPE.RON);
        AccountVisitor visitor = new AccountReportVisitor();

        acc.accept(visitor);

        assertEquals("RON555", acc.getAccountCode());
    }
}