package opgave_3;

public class Common {

	int ticket = 0;
	int call = 0;
	int queue = 0;

	public Common() {
	}

	public synchronized void getTicket(int threadId) {
		queue++;
		ticket++;
		System.out.println("Customer " + (threadId + 1) + " grabs ticket nr. " + ticket);
		getQueue();
		notify();
		try {
			wait();
		} catch (Exception e) {
			System.out.println("getTicket error");
		}
	}

	public synchronized void getQueue() {
		System.out.println("Queue: " + queue + "\n");
		notify();
		try {
			wait();
		} catch (Exception e) {
			System.out.println("getQueue error");
		}
	}

	public synchronized void makeCall() {
		call++;
		queue--;
		System.out.println("---Expedient calls and services nr. " + call);
		getQueue();
		notify();
		try {
			wait();
		} catch (Exception e) {
			System.out.println("makeCall error");
		}
	}
}
