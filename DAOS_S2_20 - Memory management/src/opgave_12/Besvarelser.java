package opgave_12;

public class Besvarelser {

	public static void main(String[] args) {
		int i = 1100 % 512;
		// i = 1100 / 512;
		System.out.println(i);
	}

	// Opgaveformuleringen findes under "lektion 20" som "lektion 20.pdf"

	// Der er en oplagt fejl i ovenstående pagetabeller – hvilken ?
	// - Process 1 og 2 har både allokeringer i memory på framenummer 3.

	// Der er access til den logiske adresse 1570 i proces 1, hvilken fysisk adresse
	// svarer det til?
	// - 1570 / 512 = page number = 3
	// 1570 % 512 = pageoffset = 34
	// svarer til frame number 4 offset 34
	// 4 * 512 + 34 = 2082 (Lidt ligegyldigt / festen er færdig)

	// Der er access til den logiske adresse 1100 i proces 2, hvilken fysisk adresse
	// svarer det til?
	// - 1100 / 512 = page number = 2
	// - 1100 % 512 = page offset = 76
	// svarer til frame number 0 offset 76
	// 0 * 512 + 76 = 76 (Lidt ligegyldigt / festen er færdig)

	// - When we are managing a large number of things, we like to organize them in
	// groups of some power of 10: I'm gonna buy 1 TV (100 ), 10 boxes (101 ), 100
	// apples (102 ), 1,000 songs (103 ), etc. It's just easier for us to keep track
	// of a large number of things by grouping them this way (what's easier to
	// remember: 8,723 donuts, or 8 groups of 1,000 donuts?). This is because our
	// numbering system is something called "base 10," meaning we think of all of
	// numberdom in terms of 10. A simple count of the fingers on our hands explains
	// why we made this so.
	// Computers, on the other hand, think in base 2 (each bit is either on or off,
	// only two states). While we like to group things in powers of 10, computers
	// feel most comfortable grouping things in powers of 2. If a computer were to
	// group boxes together, it'd be in groups like 1 (20 ), 2 (21 ), 4 (22 ), 8 (23
	// ), ... , 256 (28 ), 512 (29 ), 1024 (210 ), 2048 (211 ), etc. Those numbers
	// just make "sense" to the computer just like how 100, 1000, etc just make
	// "sense" to humans, and it allows the computer to access and use all of that
	// memory in efficient ways and keep track of all of it easily.

}
