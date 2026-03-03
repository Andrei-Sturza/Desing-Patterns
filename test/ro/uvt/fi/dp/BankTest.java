package ro.uvt.fi.dp;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void testAddClient() //Basic test case
    {
        Bank bank = new Bank("BCR"); //creating the bank
        Client client = new Client("Yamal", "Barcelona", Account.TYPE.EUR, "EUR100", 100000); //creating the client

        bank.addClient(client); //adding the client to the bank

        Client result = bank.getClient("Yamal"); //searching for the client

        assertNotNull(result);
        assertEquals("Yamal", result.getName());
    }

    @Test
    public void notFound() //not found test client
    {
        Bank bank = new Bank("BCR"); //creating just the bank

        Client result = bank.getClient("Messi"); //searching for a client the doesn't exist

        assertNull(result);
    }

}
