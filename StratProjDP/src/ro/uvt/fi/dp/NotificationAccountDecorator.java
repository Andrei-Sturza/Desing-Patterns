package ro.uvt.fi.dp;

public class NotificationAccountDecorator extends AccountDecorator{

    public NotificationAccountDecorator(Operations decoratedAccount)
    {
        super(decoratedAccount);
    }

    @Override
    public void depose(double amount)
    {
        super.depose(amount);
        System.out.println("Notification: Deposit made. ");
    }

    public void retrieve(double amount)
    {
        super.retrieve(amount);
        System.out.println("Notification: Withdrawal made. ");
    }
}
