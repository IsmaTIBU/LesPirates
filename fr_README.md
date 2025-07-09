# Les Pirates - Jeu de Plateau Java
Un jeu de plateau au tour par tour pour 2 joueurs dans l'univers des pirates, développé en Java avec interface terminal.
## Objectif du Jeu
**Gagner en étant le premier à atteindre la case 30** ou en éliminant votre adversaire (réduire ses cœurs à 0).
## Mécaniques de Jeu
### Joueurs
- **Billy** (Bleu) vs **Mandy** (Vert)
- Chaque joueur commence avec **5 cœurs** de santé
- Jouent à tour de rôle en lançant 2 dés et avançant
### Plateau
- **30 cases** disposées dans une grille 6x5
- **Cases spéciales** placées aléatoirement :
  - **[V] Vent Favorable** (2 cases) : Avancer de 10 cases supplémentaires
  - **[C] Canon** (5 cases) : Attaquer ou poursuivre l'ennemi
  - **[R] Rhum** (2 cases) : +2 cœurs mais reculer de 3 cases
### Effets des Cases Spéciales
#### Vent Favorable
- **Effet** : Avancer de 10 cases supplémentaires
- **Avantage** : Accélère votre progression vers l'objectif
#### Canon
- **Si l'ennemi est devant** : L'attaquer (-2 cœurs, 2 tours d'immobilisation)
- **Si l'ennemi est derrière** : Avancer jusqu'à sa position
#### Rhum
- **Avantage** : Récupérer 2 cœurs (max 5)
- **Pénalité** : Reculer de 3 cases
- **Limite** : Ne peut pas avoir plus de 5 cœurs
## Comment Jouer
1. **Lancer les dés** : Appuyer sur ENTRÉE à votre tour
2. **Se déplacer** : Avancer automatiquement selon la somme des dés
3. **Effets** : Les cases spéciales s'activent automatiquement
4. **Victoire** : Atteindre la case 30 ou éliminer l'adversaire
## Conditions de Victoire
- **Victoire par arrivée** : Premier joueur à atteindre la case 30
- **Victoire par élimination** : Réduire les cœurs de l'adversaire à 0
## Structure du Code
### Classes Principales
- **`Control.java`** : Point d'entrée du programme
- **`Jeu.java`** : Logique de jeu principale et boucle de tours
- **`Joueur.java`** : Représente chaque joueur (position, santé, statut)
- **`Plateau.java`** : Gère le plateau et les cases spéciales
- **`Affichage.java`** : Gère tout l'affichage et les messages
### Système de Cases
- **`Cases.java`** : Classe de base abstraite pour les cases spéciales
- **`Canon.java`** : Implémente la logique d'attaque/poursuite
- **`Rhum.java`** : Implémente la récupération de santé avec pénalité
- **`VentFavo.java`** : Implémente le mouvement supplémentaire
### Utilitaires
- **`Des.java`** : Générateur de nombres aléatoires pour les dés
### Prérequis
- Java Development Kit (JDK) 8 ou supérieur
- Terminal/PowerShell
