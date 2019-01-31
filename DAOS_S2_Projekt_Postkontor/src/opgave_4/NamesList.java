package opgave_4;

public class NamesList {

	int index = 99;
	String[] names = { "Abel", "Birgit", "Morten", "Regitze", "Birger", "Hans", "Simon", "Ilse", "Mogens", "Lene",
			"Smilla", "Amalie", "Selma", "Jens", "Hanne", "Ole", "Niels", "Bremer", "Gertrud", "Gunhild", "Bettina",
			"Yrsa", "Solvej", "Torben", "Jesper", "Daniel", "Kasper", "Marina", "Helle", "Søren", "Knud", "Jan", "Inge",
			"Ingelise", "Ingrid", "Lea", "Valborg", "Maren", "Kent", "Julie", "Anna", "Anne", "Nina", "Ling", "Lao",
			"Heihachi", "Jin", "Kazumi", "Paul", "Lee", "Lei", "Chloe", "Julia", "Xiao", "Gert", "Frederik", "Sanne",
			"Dennis", "Didrik", "Martin", "Lilian", "Vivian", "Carsten", "Steen", "Aage", "Ursula", "Yvonne", "Pedro",
			"Polle", "Erik", "Etta", "Matthew", "Anthony", "Tom", "Herbert", "Zannie", "Markus", "Henning", "Letty",
			"Christa", "Madelyn", "Danika", "Huey", "Socorro", "Deane", "Gayle", "Noe", "Norton", "Burton", "Rose",
			"Melany", "Harmony", "Sasha", "Jose", "Debra", "Dexter", "Alysa", "Annemarie", "Paige" };

	public String getName() {
		String name = names[index - 1];
		index--;
		return name;
	}
}
