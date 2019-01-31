package opgaver;

public class MainApp {

	//
	// Opgave 1.1 = arrayet er korrekt udregnet.
	//
	// opgave 1.2 = Need matrix:
	// ----A--B--C--D
	// P0--7--5--3--4
	// P1--2--1--2--2 Done
	// P2--3--4--4--2
	// P3--2--3--3--1
	// P4--4--1--2--1
	// P5--3--4--3--3
	//
	// Opgave 1.3 = Bonkers algorithm
	// Available:
	// A-B-C-D
	// 6-3-5-4
	//
	// Try solving p0:
	// Available:_6-3-5-4
	// Needed:____7-5-3-4
	// Conclusion: Not possible.

	// Try solving p1:
	// Available:_6-3-5-4
	// Needed:____2-1-2-2
	// Conclusion: Possible.
	// 6-3-5-4 - 2-1-2-2 = 4-2-3-2
	// P1 solved.
	// Available: 8-4-7-6

	// Try solving p2:
	// Available:_8-4-7-6
	// Needed:____3-4-4-2
	// Conclusion: Possible.
	// 8-4-7-6 - 3-4-4-2 = 5-0-3-4
	// P2 solved.
	// Available: 11-8-11-8

	// Now the rest can be solved quite easily regardless of which one to do first.

	// Opgave 1.4 = Resulterer det i deadlock?
	// 6-3-5-4 - 3-2-3-3 = 3-1-2-1
	// Kan vi løse en process med nuværende materialer?
	// Nopes.

	// Opgave 2.1 + 2.2
	// Done on paper
	// Obs.Når der laves en get på en resource noget allerede har lavet get på, så
	// bliver det til et ønske om at acquire ressourcen, istedet for ejerskab af
	// ressourcen.

}
