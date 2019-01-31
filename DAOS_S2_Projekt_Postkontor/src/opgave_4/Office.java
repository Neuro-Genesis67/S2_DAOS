package opgave_4;

public class Office {

	String[] queue;
	NamesList names;
	int queueSize = 0;
	int head = -1;
	int tail = -1;

	public Office(int queueSize, NamesList namesList) {
		this.queueSize = queueSize;
		queue = new String[queueSize];
		this.names = namesList;
	}

	public synchronized void enqueue() {
		if (isEmpty()) {
			head = tail = 0;
		} else {
			tail = (tail + 1) % queueSize;
		}
		queue[tail] = names.getName();
		System.out.println(queue[tail] + " entered the queue");
		System.out.println(this + "\n");
		notify();
		try {
			wait();
		} catch (Exception e) {
			System.out.println("Enqueue exception");
		}
	}

	public synchronized void dequeue(String expedient) {
		String customer = "";
		if (head == tail) {
			customer = queue[head];
			head = tail = -1;
		} else {
			customer = queue[head];
			head = (head + 1) % queueSize;
		}
		System.out.println("---" + expedient + " calls and services " + customer);
		System.out.println(this + "\n");
		notify();
		try {
			wait();
		} catch (Exception e) {
			System.out.println("dequeue exception");
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
			if (i == count - 1) {
				result += queue[index];
			} else {
				result += queue[index] + " | ";
			}
		}
		return result + " ]";
	}
}
