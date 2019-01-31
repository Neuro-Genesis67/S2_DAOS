package opgave_6;

public class threadClass extends Thread {

	String dyrelyd;

	public threadClass(String dyrelyd) {
		// super();
		this.dyrelyd = dyrelyd;
	}

	@Override
	public void run() {
		try {
			System.out.println(dyrelyd);
			sleep(1000);
			System.out.println(dyrelyd);
			sleep(1000);
			System.out.println(dyrelyd);
			sleep(1000);
			System.out.println(dyrelyd);
			sleep(1000);
			System.out.println(dyrelyd);
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
