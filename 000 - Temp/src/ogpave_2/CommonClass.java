package ogpave_2;

import java.util.concurrent.Semaphore;

public class CommonClass {

	int custNum;
	int expNum;
	int queue = 0;
	private final Semaphore semap = new Semaphore(1);

	public CommonClass() {
		this.custNum = 0;
		this.expNum = 0;

	}

	public int getCustNum() {
		return custNum;
	}

	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}

	public int getExpNum() {
		return expNum;
	}

	public void setExpNum(int expNum) {
		this.expNum = expNum;
	}

	public int getQueue() {
		return queue;
	}

	public void setQueue(int queue) {
		this.queue = queue;
	}

}
