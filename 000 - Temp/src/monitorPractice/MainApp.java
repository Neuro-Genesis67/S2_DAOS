package monitorPractice;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		CommonClass cc = new CommonClass();
		ThreadClass t1 = new ThreadClass(cc);
		ThreadClass t2 = new ThreadClass(cc);
		t1.run();
		t2.run();
		t1.join();
		t2.join();

		System.out.println(cc.count);
		// for (int i = 0; i < 1000; i++) {
		// cc.countUp();
		// System.out.println(cc.count);
		// }
	}

}
