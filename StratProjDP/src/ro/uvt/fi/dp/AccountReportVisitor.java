package ro.uvt.fi.dp;

public class AccountReportVisitor implements AccountVisitor{

    @Override
    public void visit(Account account)
    {
        System.out.println("Account report:");
        System.out.println("Code :" + account.getAccountCode());
        System.out.println("Amount: " + account.getTotalAmount());
    }
}
