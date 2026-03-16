package ro.uvt.fi.dp;

import org.junit.Test;
import static org.junit.Assert.*;

public class SingletonLoggerTest {

    @Test
    public void SingletonTest()
    {
        SingletonLogger test1 = SingletonLogger.getInstance();
        SingletonLogger test2 = SingletonLogger.getInstance();

        assertSame(test1, test2); // assertSame verify if the 2 variables point on the same object
    }
}
