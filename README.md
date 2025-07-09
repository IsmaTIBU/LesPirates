[Clickez ici pour lire le document traduit au français](fr_README.md)

# Les Pirates - Java Board Game

A turn-based board game for 2 players set in the pirate world, developed in Java with terminal interface.

## Game Objective

**Win by being the first to reach square 30** or by eliminating your opponent (reducing their hearts to 0).

## Game Mechanics

### Players
- **Billy** (Blue) vs **Mandy** (Green)
- Each player starts with **5 hearts** of health
- Take turns rolling 2 dice and moving forward

### Board
- **30 squares** arranged in a 6x5 grid
- **Special squares** placed randomly:
  - **[V] Favorable Wind** (2 squares): Move 10 extra squares
  - **[C] Cannon** (5 squares): Attack or chase the enemy
  - **[R] Rum** (2 squares): +2 hearts but move back 3 squares

### Special Square Effects

#### Favorable Wind
- **Effect**: Move 10 additional squares
- **Benefit**: Accelerates your progress to the goal

#### Cannon
- **If enemy is ahead**: Attack them (-2 hearts, 2 turns immobilized)
- **If enemy is behind**: Advance to their position

#### Rum
- **Benefit**: Recover 2 hearts (max 5)
- **Penalty**: Move back 3 squares
- **Limit**: Cannot have more than 5 hearts

## How to Play

1. **Roll dice**: Press ENTER on your turn
2. **Move**: Automatically advance based on dice sum
3. **Effects**: Special squares activate automatically
4. **Victory**: Reach square 30 or eliminate opponent

## Win Conditions

- **Victory by arrival**: First player to reach square 30
- **Victory by elimination**: Reduce opponent's hearts to 0

## Code Structure

### Main Classes
- **`Control.java`**: Program entry point
- **`Jeu.java`**: Core game logic and turn loop
- **`Joueur.java`**: Represents each player (position, health, status)
- **`Plateau.java`**: Manages board and special squares
- **`Affichage.java`**: Handles all display and messages

### Square System
- **`Cases.java`**: Abstract base class for special squares
- **`Canon.java`**: Implements attack/chase logic
- **`Rhum.java`**: Implements health recovery with penalty
- **`VentFavo.java`**: Implements extra movement

### Utilities
- **`Des.java`**: Random number generator for dice

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Terminal/PowerShell
