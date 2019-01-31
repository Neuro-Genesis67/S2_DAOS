package opgave_1;

public class ThreadExpedient extends Thread {

	String name;
	int interval; // 0 = random interval = 1-5sek.
	boolean randomInterval = false;
	CommonClass cc;
	int threadID;
	int calls = 0;

	public ThreadExpedient(int threadID, String name, int callInterval, CommonClass cc) {
		this.name = name;
		this.interval = callInterval; // Might not be needed
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

		while (calls < 100) {
			this.busyWaiting();
			if (cc.getQueue() == 0) {
			} else {
				try {
					this.sleep(getInterval());
					cc.setQueue(cc.getQueue() - 1);
					cc.setExpNum(calls + 1);
					System.out.println("Expnum: " + cc.calls() + " | Kø: " + cc.getQueue());
				} catch (InterruptedException e) {
				}
			}
			cc.setFlag(false, threadID);
		}
	}

	private void busyWaiting() {

		while (cc.getCustNum() == cc.calls) {
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