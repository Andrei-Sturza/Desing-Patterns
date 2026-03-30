package ro.uvt.fi.dp;

public class CommandManager {

    private AccountCommand lastCommand;

    public void executeCommand(AccountCommand command)
    {
        command.execute();
        lastCommand = command;
    }

    public void undoLastCommand()
    {
        if(lastCommand != null)
        {
            lastCommand.undo();
        }
    }
}
