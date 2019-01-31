package ogpave_2;

public class ThreadExpedient extends Thread {

	String name;
	int interval; // 0 = random interval = 1-5sek.
	boolean randomInterval = false;
	CommonClass cc;

	public ThreadExpedient(String name, int callInterval, CommonClass cc) {
		this.name = name;
		this.interval = callInterval; // Might not be needed
		this.cc = cc;

	}

	@Override
	public void run() {

		while (cc.getExpNum() < 100) {
			this.busyWaiting();
			if (cc.getQueue() == 0) {
			} else {
				try {
					this.sleep(getInterval());
					cc.setQueue(cc.getQueue() - 1);
					cc.setExpNum(cc.getExpNum() + 1);
					System.out.println("Expnum: " + cc.getExpNum() + " | Kø: " + cc.getQueue());
				} catch (InterruptedException e) {
				}
			}

		}
	}

	private void busyWaiting() {

		while (cc.getCustNum() == cc.getExpNum()) {
			System.out.println("In busy waiting");
			try {
				this.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
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

// try {
// System.out.println("Sleeping");
// Thread.sleep(getCallTime() * 1000);
// cc.expNum++;
// } catch (Exception e) {
// System.out.println("Shit, we had an exception");
// }