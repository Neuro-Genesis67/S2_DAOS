package opgave_1;

public class Customer extends Thread {

	Common cc;
	int threadId;
	int interval;

	public Customer(int threadId, Common cc, int interval) {
		this.threadId = threadId;
		this.cc = cc;
		this.interval = interval;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 50; i++) {
				int other = (threadId + 1) % 2;
				cc.setFlag(true, threadId);
				cc.setTurn(other);
				while (cc.getFlag(other) && cc.getTurn() == other) {
					sleep(getInterval());
					cc.getTicket(threadId);
					cc.setFlag(false, threadId);
				}
			}
		} catch (Exception e) {
			System.out.println("Thread " + threadId + " caused an error.");
		}
	}

	private int getInterval() {
		int result = 0;
		boolean set = false;
		if (interval == 0) {
			set = true;
		} else {
			result = interval;
		}
		if (set) {
			result = 1 + (int) (Math.random() * ((5 - 1) + 1));
		}
		return result *= 1000;
	}
}
