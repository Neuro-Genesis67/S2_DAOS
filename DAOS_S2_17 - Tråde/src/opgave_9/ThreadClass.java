package opgave_9;

public class ThreadClass extends Thread {

	String threadName;
	CommonClass cc;
	int ID;

	public ThreadClass(int threadID, String threadName, CommonClass cc) {
		this.ID = threadID;
		this.threadName = threadName;
		this.cc = cc;
	}

	@Override
	public void run() {
		System.out.println("Running " + ID);
		int other = (ID + 1) % 2;
		cc.setFlag(true, ID); // Setting the intention "I want to enter"
		cc.setTurn(other); // Setting whose turn it is to enter
		while (cc.getFlag(other) && cc.getTurn() == other) {
		}

		System.out.println("Tråd " + ID + " er i critical section");
		for (int j = 0; j < 100; j++) {
			cc.opdaterGlobal();
			cc.TagerRandomTid(2);
		}
		cc.setFlag(false, ID);
	}
}
