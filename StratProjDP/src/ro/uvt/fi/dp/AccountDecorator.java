package ro.uvt.fi.dp;

public abstract class AccountDecorator implements Operations{

    protected Operations decoratedAccount;

    public AccountDecorator(Operations decoratedAccount)
    {
        this.decoratedAccount = decoratedAccount;
    }

    @Override
    public double getTotalAmount()
    {
        return decoratedAccount.getTotalAmount();
    }

    @Override
    public double getInterest()
    {
        return decoratedAccount.getInterest();
    }

    @Override
    public void depose(double amount)
    {
        decoratedAccount.depose(amount);
    }

    @Override
    public void retrieve(double amount)
    {
        decoratedAccount.retrieve(amount);
    }
}
