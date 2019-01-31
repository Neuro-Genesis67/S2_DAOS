package opgave_1;

public class MainApp {

	public static void main(String[] args) {
		CommonClass cc = new CommonClass();
		ThreadExpedient expedient = new ThreadExpedient(0, "Expedient", 0, cc);
		ThreadCustomer customer = new ThreadCustomer(1, "Kunde", 0, cc);
		expedient.start();
		customer.start();

	}

}
