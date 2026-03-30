package ro.uvt.fi.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTest {

    @Test
    public void testDepositCommand()
    {
        Account acc = new Account("RON123", 100, Account.TYPE.RON);
        CommandManager manager = new CommandManager();

        AccountCommand command = new DepositCommand(acc, 50);
        manager.executeCommand(command);

        assertEquals(154.5, acc.getTotalAmount(), 0.0001);
    }

    @Test
    public void testUndoDepositCommand()
    {
        Account acc = new Account("RON123", 100, Account.TYPE.RON);
        CommandManager manager = new CommandManager();

        AccountCommand command = new DepositCommand(acc, 50);
        manager.executeCommand(command);
        manager.undoLastCommand();

        assertEquals(103, acc.getTotalAmount(), 0.0001);
    }
}
