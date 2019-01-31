package opgave_2;

public class Expedient extends Thread {

	int interval;
	Common cc;

	public Expedient(Common cc, int interval) {
		this.cc = cc;
		this.interval = interval;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				while (cc.queue == 0) {
				}
				sleep(getInterval());
				cc.makeCall();
				if (i == 99) {
					System.out.println("Expedient is done working and goes home.");
				}
			}
		} catch (InterruptedException e) {
			System.out.println("ThreadExpedient caused an error.");
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
