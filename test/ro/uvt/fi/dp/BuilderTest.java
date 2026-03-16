package ro.uvt.fi.dp;

import org.junit.Test;
import static org.junit.Assert.*;

public class BuilderTest {

    @Test
    public void testRequired() {
        Client client = new Client.Builder("Ion", "Timisoara").build();

        assertEquals("Ion", client.getName());
        assertEquals("Timisoara", client.getAddress());
        assertNull(client.getPhone());
        assertNull(client.getEmail());
    }

    @Test
    public void testOptional() {
        Client client = new Client.Builder("Ana", "Cluj")
                .setPhone("0711111111")
                .setEmail("ana@gmail.com")
                .build();

        assertEquals("Ana", client.getName());
        assertEquals("Cluj", client.getAddress());
        assertEquals("0711111111", client.getPhone());
        assertEquals("ana@gmail.com", client.getEmail());
    }
}