package semaphore;

import java.util.concurrent.Semaphore;

public class Common {

	int count = 0;
	final static Semaphore sem = new Semaphore(1);

	public Common() {

	}

	public synchronized void countUp() {
		try {
			sem.acquire();
			count++;
			sem.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
