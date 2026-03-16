package ro.uvt.fi.dp;

import org.junit.Test;
import static org.junit.Assert.*;

public class CompanyTest {

    @Test
    public void testRON()
    {
        Account acc = CompanyAccount.createAccount(Account.TYPE.RON, "RON123", 100);

        assertNotNull(acc); //veryfing if the object is created
        assertEquals("RON123", acc.getAccountCode()); //comparing if the IBAN is the same
        assertEquals(103, acc.getTotalAmount(), 0); //comparing the sum for the creating part to the actual account
    }

    @Test
    public void testEUR() //Same logic but for EUR
    {
        Account acc = CompanyAccount.createAccount(Account.TYPE.EUR, "EUR987", 100);

        assertNotNull(acc);
        assertEquals("EUR987", acc.getAccountCode());
        assertEquals(101, acc.getTotalAmount(), 0);
    }
}
