package materiale;

public class threadClass extends Thread {

	String dyrelyd;

	public threadClass(String dyrelyd) {
		super();
		this.dyrelyd = dyrelyd;
	}

	@Override
	public void run() {
		System.out.println(dyrelyd);
	}

}
