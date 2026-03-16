package ro.uvt.fi.dp;

public class Test {

	public static void main(String[] args) {

		/**
		 * Create BCR bank with 2 clients
		 */
		Bank bcr = new Bank("BCR Bank");

		// Client Ionescu created with Builder
		Client cl1 = new Client.Builder("Ionescu Ion", "Timisoara")
				.setPhone("0712345678")
				.setEmail("ion@gmail.com")
				.build();

		cl1.addAccount(Account.TYPE.EUR, "EUR124", 200.9);
		bcr.addClient(cl1);

		// Client Marinescu created the old way
		Client cl2 = new Client("Marinescu Marin", "Timisoara", Account.TYPE.RON, "RON126", 100);
		bcr.addClient(cl2);

		/**
		 * Create bank CEC with one client
		 */
		Bank cec = new Bank("CEC Bank");
		Client clientCEC = new Client("Vasilescu Vasile", "Brasov", Account.TYPE.EUR, "EUR128", 700);
		cec.addClient(clientCEC);

		/**
		 * Perform operations on client accounts
		 */

		// depose in account RON126 of client Marinescu
		Client cl = bcr.getClient("Marinescu Marin");
		if (cl != null) {
			cl.getAccount("RON126").depose(400);
		}

		// retrieve from account RON126 of Marinescu client
		if (cl != null) {
			cl.getAccount("RON126").retrieve(67);
		}

		// transfer between accounts
		Account a1 = cl.getAccount("RON126");
		Account a2 = bcr.getClient("Ionescu Ion").getAccount("RON1234");
		a1.transfer(a2, 40);
	}
}

//Added Builder, Factory and Singleton patterns with unit tests GithubMessage