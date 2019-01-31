package opgave_10;

public class ThreadClass extends Thread {

	String threadName;
	CommonClass cc;
	int threadId;

	public ThreadClass(int threadId, String threadName, CommonClass cc) {
		this.threadId = threadId;
		this.threadName = threadName;
		this.cc = cc;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread " + this.threadId + " is acquiring semaphor...");
			CommonClass.sem.acquire();
			sleep(2000);
			for (int j = 0; j < 100; j++) {
				cc.opdaterGlobal();
				cc.TagerRandomTid(9999999);
			}
			System.out.println("Thread " + this.threadId + " is releasing semaphor...");
			CommonClass.sem.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
