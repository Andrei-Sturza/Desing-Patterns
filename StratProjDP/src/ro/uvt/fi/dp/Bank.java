package ro.uvt.fi.dp;

import java.util.Arrays;
import java.util.logging.Logger; //added the java logger packet

public class Bank {

	private final static int MAX_CLIENTS_NUMBER = 100;
	private Client clients[];
	private int clientsNumber;
	private String bankCode = null;
	private static final Logger logger = SingletonLogger.getInstance().getLogger(); //changed from multiple loggers to Singleton Logger

	public Bank(String codBanca) {
		this.bankCode = codBanca;
		clients = new Client[MAX_CLIENTS_NUMBER];
		//logger.info("Bank created for client: " + codBanca); //logg for constructor
	}

	public void addClient(Client c)
	{
		clients[clientsNumber++] = c;
		logger.info("Client added"); //logg for adding a client
	}

	public Client getClient(String nume) {
		for (int i = 0; i < clientsNumber; i++) {
			if (clients[i].getName().equals(nume)) {
				logger.info("Client found: " + nume);
				return clients[i];
			}
		}
		logger.warning("Client not found: " + nume);
		return null;
	}
	
	@Override
	public String toString()
	{
		return "Bank [code=" + bankCode + ", clients=" + Arrays.toString(clients) + "]";
	}

}
