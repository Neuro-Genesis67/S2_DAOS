package opgave_7;

public class ThreadClass extends Thread {

	Long start;
	Long end;
	Long totalTime;
	LottoKupon[] kuponArr;
	LottoKupon rigtige;
	int[] antalRigtige = new int[8]; // (var 8)

	public ThreadClass(LottoKupon[] kuponArr, LottoKupon rigtige) {
		super();
		this.kuponArr = kuponArr;
		this.rigtige = rigtige;
	}

	@Override
	public void run() {

		start = System.nanoTime();
		for (int i = 1; i < 1000000; i++) {
			int x = kuponArr[i].antalrigtige(rigtige);
			antalRigtige[x]++;
		}
		end = System.nanoTime();
		totalTime = (end - start) / 1000000; // Tid i ms.
		System.out.println("Tid det tog at finde antal rigtige: \n" + Long.toString(totalTime) + "ms.\n");

		System.out.println("Antal rigtige på hver lottokupon: ");
		for (int i : antalRigtige) {
			System.out.println(i);
		}

	}

}
