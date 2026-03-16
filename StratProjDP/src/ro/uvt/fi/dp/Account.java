package ro.uvt.fi.dp;

import java.util.logging.Logger; //importing the logger

public class Account implements Operations, Transfer {

	public static enum TYPE {
		EUR, RON
	};

	String accountCode = null; //IBAN
	double amount = 0;
	Account.TYPE type = Account.TYPE.RON;
	private static final Logger logger = SingletonLogger.getInstance().getLogger(); //declaring the logger

	protected Account(String accountCode, double amount, Account.TYPE type) {
		this.accountCode = accountCode;
		this.type = type;
		depose(amount);
	}

	@Override
	public double getTotalAmount() {

		return amount + amount * getInterest();
	}

	@Override
	public void depose(double amount) {

		this.amount += amount;
		logger.info("Money deposited successfully!"); //logger for deposit
	}

	@Override
	public void retrieve(double amount) {
		if(amount <= this.amount)
			this.amount -= amount;

		logger.info("Withdrawal successfully!"); //logger for withdrawal
	}

	@Override
	public String toString() {
		if (Account.TYPE.RON == this.type)
			return "Account RON: code=" + accountCode + ", amount=" + amount;
		else
			return "Account EUR: code=" + accountCode + ", amount=" + amount;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public double getInterest() {
		if (Account.TYPE.RON == this.type) {
			if (amount < 500)
				return 0.03;
			else
				return 0.08;
		} else {
			return 0.01;
		}

	}

	@Override
	public void transfer(Account c, double s) {
		if (Account.TYPE.RON == this.type) {
			c.retrieve(s);
			depose(s);
		}
	}

}
