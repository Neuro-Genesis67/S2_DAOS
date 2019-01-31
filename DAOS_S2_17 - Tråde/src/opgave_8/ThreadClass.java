package opgave_8;

public class ThreadClass extends Thread {

	String threadName;
	CommonClass cc;
	int threadID;

	public ThreadClass(int threadID, String threadName, CommonClass cc) {
		this.threadID = threadID;
		this.threadName = threadName;
		this.cc = cc;
	}

	@Override
	public void run() {
		System.out.println("Tråd startet");
		for (int j = 0; j < 100; j++) {
			cc.opdaterGlobal();
			cc.TagerRandomTid(9999999);
		}
	}
}
