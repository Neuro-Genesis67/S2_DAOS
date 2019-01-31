package opgave_7;

public class MainApp {

	public static void main(String[] args) {
		LottoKupon vindertal = new LottoKupon();
		LottoKupon[] kuponer = new LottoKupon[1000000];
		int i = 1;
		while (i < 1000000) {
			kuponer[i] = new LottoKupon();
			i++;
		}

		ThreadClass tc1 = new ThreadClass(kuponer, vindertal);
		tc1.run();

	}

}

// Det tog mellem 75-85ms. at køre tråden.
// Den gamle opgave (uden tråd) kørte omkring 70-80.