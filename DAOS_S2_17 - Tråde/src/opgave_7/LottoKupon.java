package opgave_7;

import java.util.Random;

public class LottoKupon {
	public boolean[] raek = new boolean[37];

	public LottoKupon() {
		int antal = 0;
		Random random = new Random();

		// Boolean arrayet "raek" fyldes med false på alle pladser
		for (int j = 0; j < 37; j++)
			raek[j] = false;

		while (antal < 7) {
			// Tal sættes et sted mellem 1 og 36
			int tal = Math.abs(random.nextInt() % 36 + 1);

			// 7 pladser i raek sættes til true;
			if (!raek[tal]) {
				raek[tal] = true;
				antal++;
			}
		}
	};

	// Finder antal rigtige i rækken
	public int antalrigtige(LottoKupon rigtig) {
		int x = 0;
		for (int j = 1; j < 37; j++)
			if (this.raek[j] && rigtig.raek[j])
				x++;
		return x;
	};
};