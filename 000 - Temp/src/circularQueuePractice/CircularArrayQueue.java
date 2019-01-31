package circularQueuePractice;

public class CircularArrayQueue {

	int[] queue;
	int queueSize = 0;
	int head = -1;
	int tail = -1;

	public CircularArrayQueue(int queueSize) {
		this.queueSize = queueSize;
		queue = new int[queueSize];
	}

	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("Can't add item, queue is full (enqueue)");
			return;
		} else if (isEmpty()) {
			head = tail = 0;
		} else {
			tail = (tail + 1) % queueSize;
		}
		queue[tail] = item;
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Can't dequeue, queue is empty (dequeue)");
			return;

		} else if (head == tail) {
			head = tail = -1;

		} else {
			head = (head + 1) % queueSize;
		}
	}

	public boolean isEmpty() {
		return (head == -1 && tail == -1);
	}

	public boolean isFull() {
		return (tail + 1) % queueSize == head ? true : false;
	}

	@Override
	public String toString() {
		String result = "[ ";

		if (isEmpty()) {
			return "[ ]";
		}

		int count = (tail + queueSize - head) % queueSize + 1;

		for (int i = 0; i < count; i++) {
			int index = (head + i) % queueSize;
			result += queue[index] + " ";
		}
		return result + "]";
	}

}
