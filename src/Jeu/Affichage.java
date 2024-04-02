package Jeu;

import CasesSpe.*;

public class Affichage {

	public void affichDebut(String nom, String couleur) {
		System.out.println("À ton tour, " + nom + " (" + couleur + ")" + " appuye sur ENTER pour lancer les dés");
	}

	public void affichFin(String nom) {
		System.out.println("Felicitations, c'est " + nom + " qui a gagné");
	}

	public void affichDes(Joueur joueur, int[] des) {
		System.out.println("T'as sorti un " + des[0] + " et un " + des[1] + ", t'es à la case "
				+ joueur.getPositionJoueur() + "\n");
	}

	public void affichCase(Joueur joueur) {
		int numCase = joueur.getPositionJoueur();

		if (numCase == 0) {
			System.out.println(joueur.getNom() + " t'es à la case initiale.");
		} else {
			System.out.println(joueur.getNom() + " t'es à la case " + numCase);
		}
	}

	public void affichCanonAvant(Joueur jouActu, Joueur jouAdv) {
		if (jouAdv != null) {
			System.out.println(jouActu.getNom() + " lance un coup de boulet à " + jouAdv.getNom());
		}
	}

	public void affichCanonDerr(Joueur jouActu, Joueur jouAdv) {
		if (jouAdv != null) {
			System.out.println(jouActu.getNom() + " se lance contre " + jouAdv.getNom());
			affichCase(jouActu);
		}
	}

	public void affichMort(Joueur joueur1, Joueur joueur2) {
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_RESET = "\u001B[0m";
		System.out.println("Désolé " + joueur2.getNom() + ", ils te restent " + ANSI_RED + 0 + ANSI_RESET + " coueurs, "
				+ joueur1.getNom() + " t'as tué");
	}

	public void affichVentFavorable(Joueur joueur) {
		System.out.println(joueur.getNom() + " t'as eu de la chance, t'avance de 10 cases!");
	}

	public void affichVie(Joueur joueur) {
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_RESET = "\u001B[0m";
		System.out.println("-------------------------------------------------------------\n");
		System.out.println("T'as " + ANSI_RED + joueur.getVie() + ANSI_RESET + " coueurs réstants");
	}

	public void affPlateau(Plateau plat, Joueur[] joueurs) {
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_YELLOW = "\u001B[33m";
		final String ANSI_RED = "\u001B[31m";
		int index = 1;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				boolean isPlayerPosition = false;
				for (Joueur joueur : joueurs) {
					if (index == joueur.getPositionJoueur()) {
						System.out.print((joueur == joueurs[0] ? ANSI_BLUE : ANSI_GREEN) + "[X]\t" + ANSI_RESET);
						isPlayerPosition = true;
						break;
					}
				}
				if (!isPlayerPosition) {
					Cases casillaEspecial = plat.getCasillaEspecial(index);
					if (casillaEspecial instanceof VentFavo) {
						System.out.print(ANSI_YELLOW + "[V]\t" + ANSI_RESET);
					} else if (casillaEspecial instanceof Canon) {
						System.out.print(ANSI_RED + "[C]\t" + ANSI_RESET);
					} else {
						System.out.print("[" + index + "]\t");
					}
				}
				index++;
			}
			System.out.println("");
		}
		System.out.println("\n");
	}

}
