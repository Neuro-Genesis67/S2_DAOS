package monitor;

public class MainApp {

	public static void main(String[] args) {
		ThreadClass T1 = new ThreadClass("Geese");
		ThreadClass T2 = new ThreadClass("Anna");
		T1.start();
		T2.start();

	}

}
