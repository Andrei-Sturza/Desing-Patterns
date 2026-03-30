package ro.uvt.fi.dp;

public class WithdrawCommand implements AccountCommand{

    private Account account;
    private double amount;

    public WithdrawCommand(Account account, double amount)
    {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute()
    {
        account.retrieve(amount);
    }

    @Override
    public void undo()
    {
        account.depose(amount);
    }
}
