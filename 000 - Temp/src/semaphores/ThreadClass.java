package semaphores;

public class ThreadClass extends Thread {

	Common c = new Common();
	String name;

	public ThreadClass(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		try {
			c.sem.acquire();
			for (int i = 0; i <= 10; i++) {
				System.out.println(name + " swammed: " + i + " waterlengths");
				Thread.sleep(500);
			}
			c.sem.release();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
