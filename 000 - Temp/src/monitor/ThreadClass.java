package monitor;

public class ThreadClass extends Thread {

	String name;
	CommonClass cc;

	public ThreadClass(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {

			System.out.println(name + " is summoning a hellcreep");
			sleep(1000);
			cc.spawnHellCreep(1);
			System.out.println(name + " sees " + cc.hellCreeps + " hellcreeps in the world");
			// wait();
			System.out.println(name + " is now creating more hellcreeps...");
			sleep(5000);
			cc.spawnHellCreep(5);
			System.out.println(name + " created 5 more hellcreeps!");
			// notify();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
