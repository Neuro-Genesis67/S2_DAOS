package opgave_3;

public class MainApp {

	public static void main(String[] args) {
		Common cc = new Common();
		Expedient TE = new Expedient(cc, 1);
		Customer TC1 = new Customer(0, cc, 1);
		Customer TC2 = new Customer(1, cc, 1);

		TE.start();
		TC1.start();
		TC2.start();
	}
}
