package monitorPractice;

public class ThreadClass extends Thread {

	CommonClass cc;

	public ThreadClass(CommonClass cc) {
		this.cc = cc;
	}

	@Override
	public void run() {

		for (int i = 0; i < 50000; i++) {
			cc.countUp();
		}

	}

}
