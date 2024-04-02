package Jeu;


public class Affichage {
	private final String ANSI_RESET = "\u001B[0m";
	private final String ANSI_BLUE = "\u001B[34m";
	private final String ANSI_GREEN = "\u001B[32m";
	private final String ANSI_YELLOW = "\u001B[33m";
	private final String ANSI_RED = "\u001B[31m";

	private String getColorizedName(String name, String colorCode) {
		String color;
		switch (colorCode.toUpperCase()) {
		case "BLEU":
			color = ANSI_BLUE;
			break;
		case "VERT":
			color = ANSI_GREEN;
			break;
		default:
			color = ANSI_RESET;
		}
		return color + name + ANSI_RESET;
	}

	public void affichDebut(String nom, String couleur) {
		System.out.println("À ton tour, " + getColorizedName(nom, couleur) + " appuye sur ENTER pour lancer les dés");
	}

	public void affichFin(String nom, String couleur) {
		System.out.println("Felicitations, c'est " + getColorizedName(nom, couleur) + " qui a gagné");
	}

	public void affichDes(Joueur joueur, int[] des) {
		System.out.println("T'as sorti un " + des[0] + " et un " + des[1] + ", t'es à la case "
				+ joueur.getPositionJoueur() + "\n");
	}

	public void affichCase(Joueur joueur) {
		int numCase = joueur.getPositionJoueur();
		System.out.println(
				getColorizedName(joueur.getNom(), joueur.getCouleur()) + " t'es maintenant à la case " + numCase);
	}

	public void affichCanonAvant(Joueur jouActu, Joueur jouAdv) {
		if (jouAdv != null) {
			System.out.println(getColorizedName(jouActu.getNom(), jouActu.getCouleur()) + " lance un coup de boulet à "
					+ getColorizedName(jouAdv.getNom(), jouAdv.getCouleur()));
		}
	}

	public void affichEtourdi(Joueur joueur) {
		System.out.println("Désolé " + getColorizedName(joueur.getNom(), joueur.getCouleur())
				+ " à cause du coup de boulé t'es atourdi, tu seras pret(e) en " + joueur.getToursImmo() + " tours");
	}

	public void affichCanonDerr(Joueur jouActu, Joueur jouAdv) {
		if (jouAdv != null) {
			System.out.println(getColorizedName(jouActu.getNom(), jouActu.getCouleur()) + " se lance contre "
					+ getColorizedName(jouAdv.getNom(), jouAdv.getCouleur()));
			affichCase(jouActu);
		}
	}

	public void affichMort(Joueur joueur1, Joueur joueur2) {
		System.out.println("Désolé " + getColorizedName(joueur1.getNom(), joueur1.getCouleur()) + ", ils te restent "
				+ ANSI_RED + 0 + ANSI_RESET + " coueurs, " + getColorizedName(joueur2.getNom(), joueur2.getCouleur())
				+ " t'as tué");
	}

	public void affichVentFavorable(Joueur joueur) {
		System.out.println(getColorizedName(joueur.getNom(), joueur.getCouleur())
				+ " t'as eu de la chance, t'avance de 10 cases!");
	}

	public void affichVie(Joueur joueur) {
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("T'as " + ANSI_RED + joueur.getVie() + ANSI_RESET + " coueurs réstants");
	}

	public void affPlateau(Plateau plat, Joueur[] joueurs) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				int index = i * 5 + j + 1;
				String symbol = getSymbolForCell(plat, joueurs, index, index);
				System.out.print(symbol);
			}
			System.out.println();
		}
		System.out.println();
	}

	private String getSymbolForCell(Plateau plat, Joueur[] joueurs, int index, int cellNumber) {
		for (Joueur joueur : joueurs) {
			if (joueur.getPositionJoueur() == index) {
				String color = joueur.getCouleur().equals("BLEU") ? ANSI_BLUE : ANSI_GREEN;
				return color + "[X]" + ANSI_RESET + "     ";
			}
		}
		if (plat.getCaseSpe(index) instanceof VentFavo) {
			return ANSI_YELLOW + "[V]" + ANSI_RESET + "     ";
		} else if (plat.getCaseSpe(index) instanceof Canon) {
			return ANSI_RED + "[C]" + ANSI_RESET + "     ";
		}
		return String.format("[%d]", cellNumber) + "\t";
	}

}
