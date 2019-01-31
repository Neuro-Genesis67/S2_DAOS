package backu;

public class ThreadCustomer extends Thread {

	String name;
	int interval; // Hvis denne er 0 findes en random tid, ellers er den faste tid angivet.
	boolean randomInterval = false;
	CommonClass cc;
	int ticketBox;

	public ThreadCustomer(int ticketBox, String Name, int drawInterval, CommonClass cc) {
		this.name = name;
		this.interval = drawInterval; // Might not be needed
		this.cc = cc;
		this.ticketBox = ticketBox;
	}

	@Override
	public void run() {
		System.out.println("run cust thread");
		int other = (ticketBox + 1) % 2;
		cc.setFlag(true, ticketBox); // Setting the intention "I want to enter"
		cc.setTurn(other); // Setting whose turn it is to enter
		while (cc.getFlag(other) && cc.getTurn() == other) {
		}

		while (cc.getCustNum() < 100) {
			try {
				this.sleep(getInterval());
				cc.getTicket();
				System.out.println("Kunde trækker nr. " + cc.getCustNum() + " fra ticket box nr. " + ticketBox + 1);
			} catch (InterruptedException e) {
			}
			cc.setFlag(false, ticketBox);

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
