package semaphore;

public class MainApp {

	public static void main(String[] args) {
		Common common = new Common();
		ThreadClass tc1 = new ThreadClass("Tom", common);
		ThreadClass tc2 = new ThreadClass("Torben", common);
		tc1.start();
		tc2.start();
	}

}
