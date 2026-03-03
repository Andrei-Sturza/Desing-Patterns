package ro.uvt.fi.dp;

import java.util.Arrays;
import java.util.logging.Logger; //imporing the logger

import ro.uvt.fi.dp.Account.TYPE;

public class Client {
	public static final int MAX_ACCOUNTS_NO = 5;

	private String name;
	private String address;
	private Account accounts[];
	private int accountsNo = 0;
	private static final Logger logger = Logger.getLogger(Client.class.getName()); //added a logger field

	public Client(String nume, String adresa, TYPE tip, String numarCont, double suma) {
		this.name = nume;
		this.address = adresa;
		accounts = new Account[MAX_ACCOUNTS_NO];
		addAccount(tip, numarCont, suma);
	}

	public void addAccount(TYPE type, String numarCont, double suma) {
		if (MAX_ACCOUNTS_NO > accountsNo)
			accounts[accountsNo++] = new Account(numarCont, suma, type);
	}

	public Account getAccount(String accountCode) {
		for (int i = 0; i < accountsNo; i++) {
			if (accounts[i].getAccountCode().equals(accountCode)) {
				return accounts[i];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "\n\tClient [name=" + name + ", address=" + address + ", acounts=" + Arrays.toString(accounts) + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		logger.info("Name setting complete");
	}
}
