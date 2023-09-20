package hw3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TicTacToe {
	// Add your own PRIVATE fields here.
	// They must have type char, int, boolean, String, or they can be 1D or 2D arrays of these types.
	
	private char[][] gameBoard;
	private int[] columnCount;
	private char turnPlayer;
	private char winningPlayer;
	private int turnCount;
	private boolean isGameOver;
	
	/**
	 * Constructs a new empty connect 4 game board with player X being the first player
	 * and player 'O' being the second player.
	 */
	public TicTacToe() {
		//Notes: [rows][columns]
		
		//Init variables
		gameBoard = new char[6][7];
		columnCount = new int[7];
		turnCount = 1;
		turnPlayer = 'X';
		winningPlayer = ' ';
		
		//Setup board
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[0].length; j++) {
				gameBoard[i][j] = '*';
			}
			
		}
		
		//Setup column counter
		for (int i = 0; i < columnCount.length; i++) {
			columnCount[i] = 0;
		}	
	}

	/**
	 * Gets the current player (either 'X' or 'O')
	 * 
	 * @return the current player
	 */
	public char currentPlayer() {
		if (turnCount%2 == 0)
			return 'O';
		else
			return 'X';
	}

	/**
	 * The current player tries to make a move in a given column.  If the move
	 * is valid, the board is updated and {@code true} is returned.  If the move
	 * is invalid (not a valid column number of the column is already full)
	 * the board remains unchanged and {@code false} is returned.  If the game is
	 * already over, a RuntimeException is thrown instead.
	 * 
	 * @param column the column in which to make a move.  For the move to be valid,
	 * the column value must an {@code int} between 1 and 7 inclusive, and
	 * there must have been fewer than 6 moves already made in the given column.
	 * @return {@code true} if the move is valid and false if it is not valid.
	 * @throws RuntimeException if the game is already over.
	 */
	public boolean play(int column) {
		
		if (gameOver() == true) 
			throw new RuntimeException("GAME OVER");
		
		if (column < 1 || column > 7 || columnCount[column-1] >= 6 || isGameOver == true) { 
			return false;
		}
		
		
		// Switch turns
		if (turnCount % 2 == 0)
			turnPlayer = 'O';
		else
			turnPlayer = 'X';
		

		
		// Drop turnPlayer's move onto the board
		for (int i = 5; i > -1; i--) {
			if (gameBoard[i][column-1] == '*') {
				gameBoard[i][column-1] = turnPlayer;
				columnCount[column-1] += 1;
				turnCount++;
				break;
			}
		}
		
		return true;
	}

	

	/**
	 * Determines if the game is already over.
	 * 
	 * @return {@ccode true} if the game is over and {@code false} if it is not over.
	 */
	public boolean gameOver() {
		
		
		// Row win?
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[0].length-3; j++) {
				if (gameBoard[i][j] == turnPlayer && gameBoard[i][j+1] == turnPlayer && gameBoard[i][j+2] == turnPlayer && gameBoard[i][j+3] == turnPlayer) {
					winningPlayer = turnPlayer;
					isGameOver = true;
					return isGameOver;
				}
			}
		}
		
		// Column win?
		for (int i = 0; i < gameBoard.length-3; i++) {
			for (int j = 0; j < gameBoard[0].length; j++) {
				if (gameBoard[i][j] == turnPlayer && gameBoard[i+1][j] == turnPlayer && gameBoard[i+2][j] == turnPlayer && gameBoard[i+3][j] == turnPlayer) {
					winningPlayer = turnPlayer;
					isGameOver = true;
					return isGameOver;
				}
			}
		}
		
		// Up diagonal win?
		for (int i = 3; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[0].length - 3; j++) {
				if (gameBoard[i][j] == turnPlayer && gameBoard[i-1][j+1] == turnPlayer && gameBoard[i-2][j+2] == turnPlayer && gameBoard[i-3][j+3] == turnPlayer) {
					winningPlayer = turnPlayer;
					isGameOver = true;
					return isGameOver;
				}
			}
		}
		// Down diagonal win?
		for (int i = 0; i < gameBoard.length - 3; i++) {
			for (int j = 0; j < gameBoard[0].length-3; j++) {
				if (gameBoard[i][j] == turnPlayer && gameBoard[i+1][j+1] == turnPlayer && gameBoard[i+2][j+2] == turnPlayer && gameBoard[i+3][j+3] == turnPlayer) {
					winningPlayer = turnPlayer;
					isGameOver = true;
					return isGameOver;
				}
			}
		}
		
		if (columnCount[0] == 6 && 
				columnCount[1] == 6 &&
				columnCount[2] == 6 &&
				columnCount[3] == 6 &&
				columnCount[4] == 6 &&
				columnCount[5] == 6 &&
				columnCount[6] == 6) {
			winningPlayer = ' ';
			isGameOver = true;
			return isGameOver;
				
		}
		return isGameOver;
	}

	/**
	 * Determine the winner (assuming the game is over).
	 * 
	 * @return {@code 'X'} or {@code 'O'} if either player has won and {@code ' '}
	 * if the game is not over or if the game is a draw.
	 */
	public char winner() {
		return winningPlayer;
	}

	/**
	 * Construct a string describing the state of the game.  You are not requried to implement
	 * this method, however, implementing this method will make debugging much easier so
	 * you are encrouaged to implement this to return a string that looks like the game board.
	 * 
	 * @return a string representation of the game
	 */
	public String toString() {
		//Initialize string
		String displayBoard = "";
		
		//Formatting 
		displayBoard += "*************************";
		displayBoard += "\r\n";
		displayBoard += "** Charles H - CSC 402 **";
		displayBoard += "\r\n";
		displayBoard += "*************************";
		displayBoard += "\r\n";
		displayBoard += "\r\n";
		
		//Loop that traverses through 1d array and appends each field to our new string
		for (int i = 0; i < 7; i++ ) {
			displayBoard += columnCount[i];
			displayBoard += "   ";
		}
		
		//Formatting
		displayBoard += "\r\n";
		displayBoard += "|   |   |   |   |   |   |   ";
		displayBoard += "\r\n";
		
		
		//Loop that traverses through 2d array and appends each field to our new string
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				displayBoard += gameBoard[i][j];
				displayBoard += "   ";
				
			}
			//adds a new line to our string after each row
			displayBoard += "\r\n";
			
		}
		return displayBoard;
	}

	/*
	 * This main can be used to play a game of Connect 4.  In order to display the game board
	 * you must have defined the toString method.
	 */
	public static void main(String[] args) {
		TicTacToe b = new TicTacToe();
		while (!b.gameOver()) {
			boolean legalMove = false;
			while (!legalMove) {
				StdOut.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
				StdOut.println(b);
				StdOut.println("Current player: " + b.currentPlayer());
				StdOut.println("Enter column number for next move: ");
				int col = StdIn.readInt();
				legalMove = b.play(col);
			}
		}
		StdOut.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		StdOut.println(b);
		StdOut.println("GAME OVER");
		if (b.winner() == ' ')
			StdOut.println("It's a draw");
		else
			StdOut.println(b.winner() + " WINS!!!");
	}
}
