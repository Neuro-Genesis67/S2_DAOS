package opgave_1;

public class Common {

	int ticket = 0;
	int call = 0;
	int queue = 0;
	int turn = 0;
	boolean flag[] = new boolean[2];

	public Common() {
		flag[0] = false;
		flag[1] = false;
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

	public void setFlag(boolean true_false, int ID) {
		this.flag[ID] = true_false;
	}

	public void getTicket(int threadId) {
		queue++;
		ticket++;
		System.out.println("Customer " + (threadId + 1) + " grabs ticket nr. " + ticket + "\nQueue: " + queue + "\n");
	}

	public void makeCall() {
		queue--;
		call++;
		System.out.println("---Expedient calls and services nr. " + call + "\nQueue: " + queue + "\n");
	}

}
