package semaphore;

import java.util.concurrent.Semaphore;

public class ThreadClass extends Thread {

	Common common;
	String name = "";
	

	public ThreadClass(String name, Common common) {
		this.name = name;
		this.common = common;
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < 100; i++) {
			
				System.out.println(name + " is in critical section");
				sleep(500);
				common.countUp();
				System.out.println(common.count);
				
			}

		} catch (InterruptedException e) {
			System.out.println(name + " had an error");
		}

	}
}
