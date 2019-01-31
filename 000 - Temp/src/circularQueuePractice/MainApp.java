package circularQueuePractice;

public class MainApp {

	public static void main(String[] args) {
		CircularArrayQueue caq = new CircularArrayQueue(10);
		System.out.println(caq);
		System.out.println("isEmpty(): " + caq.isEmpty());
		System.out.println("isFull(): " + caq.isFull() + "\n");
		System.out.println("Adding 10 items to queue: ");
		caq.enqueue(1);
		caq.enqueue(2);
		caq.enqueue(3);
		caq.enqueue(4);
		caq.enqueue(5);
		caq.enqueue(6);
		caq.enqueue(7);
		caq.enqueue(8);
		caq.enqueue(9);
		caq.enqueue(10);
		System.out.println(caq);
		System.out.println("isEmpty(): " + caq.isEmpty());
		System.out.println("isFull(): " + caq.isFull() + "\n");

		System.out.println("Adding one more item: ");
		caq.enqueue(11);

		System.out.println("\nDequeueing 5 times: ");
		for (int i = 0; i < 5; i++) {
			caq.dequeue();
		}
		System.out.println(caq);
		System.out.println("isEmpty(): " + caq.isEmpty());
		System.out.println("isFull(): " + caq.isFull());

		System.out.println("\nEnqueueing 5 times: ");
		caq.enqueue(1);
		caq.enqueue(2);
		caq.enqueue(3);
		caq.enqueue(4);
		caq.enqueue(5);
		System.out.println(caq);
		System.out.println("isEmpty(): " + caq.isEmpty());
		System.out.println("isFull(): " + caq.isFull());

		System.out.println("\nDequeueing once: ");
		caq.dequeue();
		System.out.println(caq);

	}

}
