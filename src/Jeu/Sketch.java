package Jeu;
import processing.core.PApplet;
import java.util.ArrayList;

public class Sketch extends PApplet {
	Des des = new Des();
	
	int rows = 7; 
	int cols = 7; 
	int squareSize; 
	int currentPlayer = 1; // (1 pour rouge, 2 pour bleu)
	int currentPlayerPosRed = 1; 
	int currentPlayerPosBlue = 1; 
	int[] diceResult; 

	int[][] grid = {
	  {1, 2, 3, 4, 5, 6, 7},
	  {0, 0, 0, 0, 0, 0, 8},
	  {23, 24, 25, 26, 27, 0, 9},
	  {22, 0, 0, 0, 28, 0, 10},
	  {21, 0, 0, 30, 29, 0, 11},
	  {20, 0, 0, 0, 0, 0, 12},
	  {19, 18, 17, 16, 15, 14, 13}
	};

	ArrayList<String> terminalMessages = new ArrayList<String>(); 
	int maxTerminalMessages = 4;

	public void setup() {
	  size(600, 685);
	  squareSize = width / cols;
	}

	public void draw() {
	  background(255);
	  drawBoard();
	  drawPlayers();
	  displayTerminal();
	}

	public void drawBoard() {
	  // Dessiner la grille
	  for (int y = 0; y < rows; y++) {
	    for (int x = 0; x < cols; x++) {
	      int xPos = x * squareSize;
	      int yPos = y * squareSize;
	      if (grid[y][x] != 0) {
	        fill(200);
	        rect(xPos, yPos, squareSize, squareSize);
	        fill(0);
	        textAlign(CENTER, CENTER);
	        text(grid[y][x], xPos + squareSize / 2, yPos + squareSize / 2);
	      } else {
	        fill(250, 235, 215); 
	        rect(xPos, yPos, squareSize, squareSize);
	      }
	    }
	  }
	}

	public void drawPlayers() { 
	  int playerXRed = 0;
	  int playerYRed = 0;
	  int playerXBlue = 0;
	  int playerYBlue = 0;
	  
	  for (int y = 0; y < rows; y++) {
	    for (int x = 0; x < cols; x++) {
	      if (grid[y][x] == currentPlayerPosRed) {
	        playerXRed = x * squareSize + squareSize / 4;
	        playerYRed = y * squareSize + squareSize * 3 / 4;
	      }
	      if (grid[y][x] == currentPlayerPosBlue) {
	        playerXBlue = x * squareSize + squareSize * 3 / 4;
	        playerYBlue = y * squareSize + squareSize / 4;
	      }
	    }
	  }
	  
	  fill(255, 0, 0); 
	  ellipse(playerXRed, playerYRed, squareSize / 2, squareSize / 2);
	  fill(0, 0, 255); 
	  ellipse(playerXBlue, playerYBlue, squareSize / 2, squareSize / 2);
	}

	public void displayTerminal() {
	  fill(0);
	  textAlign(LEFT);
	  textSize(15);
	  
	 
	  int startY = height - 75;
	  int lineHeight = 20;
	  int numMessagesToShow = min(4, terminalMessages.size());
	  for (int i = 0; i < numMessagesToShow; i++) {
	    text(terminalMessages.get(terminalMessages.size() - 1 - i), 10, startY + i * lineHeight);
	  }
	}

	@Override
	public void keyPressed() {
	  if (key == 'r' && currentPlayer == 1) { 
	    diceResult = des.lancerDes();
	    movePlayer(currentPlayer, diceResult);
	    switchPlayer();
	  }
	  
	  if (key == 'b' && currentPlayer == 2) { 
	    diceResult = des.lancerDes();
	    movePlayer(currentPlayer, diceResult);
	    switchPlayer();
	  }
	}

	public static void main(String[] args) {
        PApplet.main("Jeu.Sketch");
    }
	
	public void movePlayer(int player, int[] diceResult2) {
	    int totalDice = diceResult2[0] + diceResult2[1]; // Suma de los dos dados.
	    if (player == 1) {
	        currentPlayerPosRed += totalDice;
	        if (currentPlayerPosRed > 30) {
	            currentPlayerPosRed -= totalDice * 2; // Asegúrate de que esta lógica es la deseada
	        }
	        terminalMessages.add("Joueur rouge a lancé " + totalDice + " au dé.");
	        checkForSpecialCase(currentPlayerPosRed);
	    } else {
	        currentPlayerPosBlue += totalDice;
	        if (currentPlayerPosBlue > 30) {
	            currentPlayerPosBlue -= totalDice * 2; // Lo mismo aquí
	        }
	        terminalMessages.add("Joueur bleu a lancé " + totalDice + " au dé.");
	        checkForSpecialCase(currentPlayerPosBlue);
	    }
	}

	public void checkForSpecialCase(int playerPosition) {
	  if (playerPosition == 10) {
	    terminalMessages.add("Joueur sur la case 10 !");
	  }
	  if (playerPosition == 30) {
	    terminalMessages.add("Joueur sur la case youpi hihi!");
	  }
	  if (terminalMessages.size() > maxTerminalMessages) {
	    terminalMessages.remove(0); 
	  }
	}

	public void switchPlayer() {
	  currentPlayer = (currentPlayer == 1) ? 2 : 1; // Changer de joueur
	}
}
