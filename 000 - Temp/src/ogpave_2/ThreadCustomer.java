package ogpave_2;

public class ThreadCustomer extends Thread {

	String name;
	int interval; // Hvis denne er 0 findes en random tid, ellers er den faste tid angivet.
	boolean randomInterval = false;
	CommonClass cc;

	public ThreadCustomer(String Name, int drawInterval, CommonClass cc) {
		this.name = name;
		this.interval = drawInterval; // Might not be needed
		this.cc = cc;

	}

	@Override
	public void run() {

		while (cc.getCustNum() < 100) {
			try {
				this.sleep(getInterval());
				cc.setCustNum(cc.getCustNum() + 1);
				cc.setQueue(cc.getQueue() + 1);
				System.out.println("Kunde trækker: " + cc.getCustNum());
			} catch (InterruptedException e) {
			}

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
