package opgave_8;

import java.util.Random;

public class CommonClass {

	int global = 0;

	public CommonClass() {

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

}
