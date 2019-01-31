package opgave_4;

public class Expedient extends Thread {
	Office office;
	String name;
	int interval;

	public Expedient(String expedientName, Office office, int interval) {
		this.name = expedientName;
		this.office = office;
		this.interval = interval;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 50; i++) {
				while (office.isEmpty()) {
					System.out.println("|_Status_| The office is empty and the expedients are playing minesweeper\n");
					sleep(3000);
				}
				sleep(getInterval());
				office.dequeue(name);
			}
			System.out.println("\n" + name + " goes home after a long day's work");
		} catch (Exception e) {
			System.out.println("expedient exception: " + name);
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
