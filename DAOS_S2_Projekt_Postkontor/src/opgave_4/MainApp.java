package opgave_4;

public class MainApp {

	public static void main(String[] args) {
		NamesList namesList = new NamesList();
		Office office = new Office(10, namesList);
		Customer customers1 = new Customer(office, 1);
		Customer customers2 = new Customer(office, 1);
		Expedient expedient1 = new Expedient("Lily Labeu", office, 1);
		Expedient expedient2 = new Expedient("Pema Chodron", office, 1);

		customers1.start();
		customers2.start();
		expedient1.start();
		expedient2.start();
	}
}
