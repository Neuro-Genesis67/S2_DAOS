package backu;

public class CommonClass {

	int custNum;

	int queue = 0;
	int turn;
	boolean flag[];

	public CommonClass() {
		this.custNum = 0;
		flag = new boolean[2];
		flag[0] = false;
		flag[1] = false;
		turn = 0;

	}

	public void getTicket() {
		this.custNum++;
		this.queue++;
	}

	public int getCustNum() {
		return custNum;
	}

	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}

	public int getQueue() {
		return queue;
	}

	public void setQueue(int queue) {
		this.queue = queue;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public boolean getFlag(int id) {
		return flag[id];
	}

	public void setFlag(boolean true_false, int id) {
		this.flag[id] = true_false;
	}

}
