package opgave_5;

public class Nanotimez {

	public static void main(String[] args) {
		Long t1 = System.nanoTime();
		int[] intArr = new int[100000000];
		Long t2 = System.nanoTime();

		Long result = (t2 - t1) / 1000000; // Tid i ms.
		System.out.println(Long.toString(result) + "ms");

	}

}
