package ro.uvt.fi.dp;

public class DepositCommand implements AccountCommand{

    private Account account;
    private double amount;

    public DepositCommand(Account account, double amount)
    {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute()
    {
        account.depose(amount);
    }

    public void undo()
    {
        account.retrieve(amount);
    }

}
