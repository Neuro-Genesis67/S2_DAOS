package semaphores;

public class Main {

	public static void main(String[] args) {
		ThreadClass c1 = new ThreadClass("Billy");
		ThreadClass c2 = new ThreadClass("Boolayyy");
		c1.start();
		c2.start();
	}

}
