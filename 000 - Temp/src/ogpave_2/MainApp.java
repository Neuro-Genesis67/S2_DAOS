package ogpave_2;

public class MainApp {

	public static void main(String[] args) {
		CommonClass cc = new CommonClass();
		ThreadExpedient expedient = new ThreadExpedient("Expedient", 0, cc);
		ThreadCustomer customer = new ThreadCustomer("Kunde", 0, cc);
		expedient.start();
		customer.start();

	}

}
