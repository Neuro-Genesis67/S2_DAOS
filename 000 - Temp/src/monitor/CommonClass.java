package monitor;

public class CommonClass {

	int hellCreeps = 0;

	public CommonClass() {

	}

	 public void spawnHellCreep(int creeps) {
		 synchronized(this) {
			 
		for (int i = 0; i < creeps; i++) {
			System.out.println("Hellcreep spawned");
			hellCreeps++;
		}
		 }
	}
}
