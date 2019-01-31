package opgave_4;

public class Customer extends Thread {

	Office office;
	NamesList names;
	int interval;

	public Customer(Office office, int interval) {
		this.office = office;
		this.interval = interval;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 50; i++) {
				while (office.isFull()) {
					System.out.println("|_Status_| The office is full and the customers are waiting outside\n");
					sleep(3000);
				}
				sleep(getInterval());
				office.enqueue();
			}
		} catch (Exception e) {
			System.out.println("Error occured with customer");
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
