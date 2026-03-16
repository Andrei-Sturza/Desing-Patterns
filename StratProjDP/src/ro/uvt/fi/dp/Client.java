package ro.uvt.fi.dp;

import java.util.Arrays;
import java.util.logging.Logger;

import ro.uvt.fi.dp.Account.TYPE;

public class Client {
	public static final int MAX_ACCOUNTS_NO = 5;

	private String name;
	private String address;
	private String phone; //added optional field
	private String email; //added optional field

	private Account accounts[];
	private int accountsNo = 0;

	private static final Logger logger = Logger.getLogger(Client.class.getName());

	public Client(String nume, String adresa, TYPE tip, String numarCont, double suma) {
		this.name = nume;
		this.address = adresa;
		accounts = new Account[MAX_ACCOUNTS_NO];
		addAccount(tip, numarCont, suma);
	}

	private Client(Builder builder) { //Creating a constructor for Builder
		this.name = builder.name;
		this.address = builder.address;
		this.phone = builder.phone;
		this.email = builder.email;
		accounts = new Account[MAX_ACCOUNTS_NO];
	}

	public void addAccount(TYPE type, String numarCont, double suma) {
		if (MAX_ACCOUNTS_NO > accountsNo)
			accounts[accountsNo++] = CompanyAccount.createAccount(type, numarCont, suma);
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
		return "\n\tClient [name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", acounts=" + Arrays.toString(accounts) + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		logger.info("Name setting complete");
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public static class Builder { //Creating the inner class

		private String name;
		private String address;
		public String phone;
		private String email;

		public Builder(String name, String address) {
			this.name = name;
			this.address = address;
		}

		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Client build() {
			return new Client(this);
		}
	}
}