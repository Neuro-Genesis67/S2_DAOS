package opgave_9;

public class MainApp {

	public static void main(String[] args) {
		// Main-metoden opretter et objekt af typen Common samt to tråd-objekter,
		// hvorefter de to tråde
		// startes. Til slut udskrives værdier af den globale tæller

		CommonClass cc = new CommonClass();
		ThreadClass tc1 = new ThreadClass(0, "Thread 1", cc);
		ThreadClass tc2 = new ThreadClass(1, "Thread 2", cc);
		try {
			tc1.start();
			tc2.start();
			tc1.join();
			tc2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(cc.getGlobal());
	}

}
