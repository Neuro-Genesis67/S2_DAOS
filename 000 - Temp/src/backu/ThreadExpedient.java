package backu;

public class ThreadExpedient extends Thread {

	String name;
	int interval; // 0 = random interval = 1-5sek.
	boolean randomInterval = false;
	CommonClass cc;
	int ticketBox;
	int calls = 0;

	public ThreadExpedient(int ticketBox, String name, int callInterval, CommonClass cc) {
		this.name = name;
		this.interval = callInterval; // Might not be needed
		this.cc = cc;
		this.ticketBox = ticketBox;
	}

	@Override
	public void run() {
		while (calls < 100) {
			this.busyWaiting();
			if (cc.getQueue() == 0) {
			} else {
				try {
					this.sleep(getInterval());
					callCustomer();
					System.out.println("Ekspedient kalder og servicerer nr. " + calls + " | Kø: " + cc.getQueue());
				} catch (InterruptedException e) {
				}
			}
		}
	}

	private void busyWaiting() {
		while (cc.getCustNum() == calls) {
			System.out.println("In busy waiting");
			try {
				this.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private void callCustomer() {
		calls++;
		cc.queue--;
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
