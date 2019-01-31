package opgave_2;

import java.util.concurrent.Semaphore;

public class Common {

	public volatile int ticket = 0;
	public volatile int call = 0;
	public volatile int queue = 0;
	final static Semaphore sem = new Semaphore(1);

	public Common() {

	}

	public void getTicket(int threadId) throws InterruptedException {
		sem.acquire();
		ticket++;
		System.out.println("Customer " + (threadId + 1) + " grabs ticket nr. " + (ticket));
		getQueue();
	}

	public void getQueue() {
		queue++;
		System.out.println("Queue: " + (queue) + "\n");
		sem.release();
	}

	public void makeCall() throws InterruptedException {
		sem.acquire();
		queue--;
		call++;
		System.out.println("---Expedient calls and services nr. " + (call) + "\nQueue: " + queue + "\n");
		sem.release();
	}

}
