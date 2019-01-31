package opgave_9;

import java.util.Random;

public class CommonClass {

	// PETERSON //
	int turn;
	boolean flag[];
	// PETERSON //

	int global = 0;

	public CommonClass() {
		flag = new boolean[2];
		flag[0] = false;
		flag[1] = false;
		turn = 0;
	}

	public void TagerRandomTid(int max) {

		Random random = new Random();
		int tal = Math.abs(random.nextInt() % 20 * 9999);

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < tal; j++) {
				tal += 9999999;
			}
		}

	}

	public int getGlobal() {
		return global;
	}

	public void opdaterGlobal() {
		int temp;
		temp = global;
		TagerRandomTid(999);
		global = temp + 1;

	}

	public void setFlag(boolean true_false, int ID) {
		this.flag[ID] = true_false;
	}

	public boolean getFlag(int ID) {
		return flag[ID];
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getTurn() {
		return turn;
	}

}
