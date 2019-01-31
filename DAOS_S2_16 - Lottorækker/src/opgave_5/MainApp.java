package opgave_5;

public class MainApp {

	public static void main(String[] args) {
		Long time1;
		Long time2;
		Long timeResult;

		// Step 1:
		time1 = System.nanoTime();
		lottoraek[] lottorækker = new lottoraek[1000000];
		time2 = System.nanoTime();
		timeResult = (time2 - time1) / 1000000;
		System.out.println(
				"Tid det tog at oprette et array med 1000000 lottorækker: " + Long.toString(timeResult) + "ms\n");

		int i = 1;
		while (i < 1000000) {
			lottorækker[i] = new lottoraek();
			i++;
		}

		// Step 2
		// En række med rigtige laves
		lottoraek rigtigeRaek = new lottoraek();

		// Step 3
		Long t1; // Tidtagning 1
		Long t2; // Tidtagning 2

		int[] antalRigtige = new int[8];

		time1 = System.nanoTime();
		// Tæller hvor mange rigtige der er på hver plads af vores 1000000 lottokuponer
		for (int t = 1; t < 1000000; t++) {
			int x = lottorækker[t].antalrigtige(rigtigeRaek);
			antalRigtige[x]++;
		}
		time2 = System.nanoTime();
		timeResult = (time2 - time1) / 1000000;

		// result += (t2 - t1) / 1000000;

		System.out.println("Tid det tog at finde antal rigtige: " + Long.toString(timeResult) + "ms\n");

		// Step 4
		for (int k = 1; k < antalRigtige.length; k++) {

			System.out.println("Rigtige på plads " + k + ": " + antalRigtige[k]);
		}

	}
}
