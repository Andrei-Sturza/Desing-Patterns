package ro.uvt.fi.dp;

public class CompanyAccount {

    //Company decides which type of account to create for the employee
    //Basically I moved the creating logic from Account class to a separate one

    public static Account createAccount(Account.TYPE type, String numarCont, double amount) {
        if (type == Account.TYPE.RON) {
            return new Account(numarCont, amount, Account.TYPE.RON);

        }

        if (type == Account.TYPE.EUR) {
            return new Account(numarCont, amount, Account.TYPE.EUR);
        }
        return null;
    }
}
