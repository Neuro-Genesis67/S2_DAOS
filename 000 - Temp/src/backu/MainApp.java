package backu;

public class MainApp {

	public static void main(String[] args) {
		CommonClass cc = new CommonClass();
		ThreadExpedient expedient = new ThreadExpedient(0, "Expedient", 1, cc);
		ThreadCustomer customer0 = new ThreadCustomer(0, "Kunde", 1, cc);
		ThreadCustomer customer1 = new ThreadCustomer(1, "Kunde", 1, cc);
		expedient.start();
		customer0.start();
		customer1.start();

	}

}
