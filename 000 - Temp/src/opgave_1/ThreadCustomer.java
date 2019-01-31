package opgave_1;

public class ThreadCustomer extends Thread {

	String name;
	int interval; // Hvis denne er 0 findes en random tid, ellers er den faste tid angivet.
	boolean randomInterval = false;
	CommonClass cc;
	int threadID;

	public ThreadCustomer(int threadId, String Name, int drawInterval, CommonClass cc) {
		this.name = name;
		this.interval = drawInterval; // Might not be needed
		this.cc = cc;
		this.threadID = threadID;

	}

	@Override
	public void run() {
		int other = (threadID + 1) % 2;
		cc.setFlag(true, threadID); // Setting the intention "I want to enter"
		cc.setTurn(other); // Setting whose turn it is to enter
		while (cc.getFlag(other) && cc.getTurn() == other) {
		}
		while (cc.getCustNum() < 100) {
			try {
				this.sleep(getInterval());
				cc.setCustNum(cc.getCustNum() + 1);
				cc.setQueue(cc.getQueue() + 1);
				System.out.println("Kunde trækker: " + cc.getCustNum());
			} catch (InterruptedException e) {
			}
			cc.setFlag(false, threadID);

		}
	}

	private int getInterval() {
		int result = 0;
		if (interval == 0) {
			randomInterval = true;
		} else {
			result = interval;
			result *= 1000;
			return result;
		}
		if (randomInterval) {
			result = 1 + (int) (Math.random() * ((5 - 1) + 1));
			result *= 1000;
		}
		return result;

	}

}
