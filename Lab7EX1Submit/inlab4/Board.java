/**
 * 
 * The board class defines all of the methods used to
 * display the board for the game
 * 
 * @author Matteo Messana
 * @version 1.0
 * @since January 30th, 2019
 *
 */
package inlab4;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Board implements Constant 
{
	/**
	 * The data members of the Board class include a char array
	 * called theBoard and an int called markCount.
	 */
	private char theBoard[][];
	private int markCount;
	
	/**
	 * The constructor of Board creates a char array
	 * inside of theBoard and populates it with empty spaces.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
	/**
	 * getMark returns the mark at a specified point
	 * on the board.
	 * 
	 * @param row: index for the row.
	 * @param col: index for the column.
	 * @return theBoard[row][col]: location on the board for mark placement.
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * If the markCount reaches 9, the  method returns true,
	 * otherwise returns false.
	 * 
	 * @return boolean: returns true if markCount reaches 9.
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Checks to see if player x wins the game.
	 * 
	 * @return boolean: returns true if checkWinner returns true.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Checks to see if player o wins the game.
	 * 
	 * @return boolean: returns true if checkWinner returns true.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Display method creates the entire board playing space. 
	 * 
	 */
	public void display(PrintWriter socketOut) {
		displayColumnHeaders(socketOut);
		addHyphens(socketOut);
		for (int row = 0; row < 3; row++) {
			addSpaces(socketOut);
			socketOut.print("    row " + row + ' ');
			socketOut.flush();
			for (int col = 0; col < 3; col++)
			{
				socketOut.print("|  " + getMark(row, col) + "  ");
				socketOut.flush();
			}
			
			socketOut.println("|");
			socketOut.flush();
			addSpaces(socketOut);
			addHyphens(socketOut);
		}
		
	}

	/**
	 * Adds a specified mark (x or o) to the location specified 
	 * by row and col.
	 * 
	 * @param row: uses the index of the row for the location of the row.
	 * @param col: uses the index of the column for the location of the row.
	 * @param mark: uses the mark of the player.
	 */
	public void addMark(int row, int col, char mark) {

		theBoard[row][col] = mark;
		markCount++;
	}
	
	/**
	 * Clears the board playing space
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks every possible win condition for the specified mark
	 * sent to the function. Will return a 1 if a player wins.
	 * 
	 * @param mark: holds the mark of the player.
	 * @return boolean: returns true if any win condition is met.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Adds column headers for the board.
	 */
	void displayColumnHeaders(PrintWriter socketOut) {
		socketOut.print("          ");
		socketOut.flush();
		for (int j = 0; j < 3; j++)
		{
			socketOut.print("|col " + j);
			socketOut.flush();
		}
		socketOut.println();
		socketOut.flush();
	}

	/**
	 * Adds a set number of hyphens to the board playing space.
	 */
	void addHyphens(PrintWriter socketOut) {
		socketOut.print("          ");
		socketOut.flush();
		for (int j = 0; j < 3; j++)
		{
			socketOut.print("+-----");
			socketOut.flush();
		}
		socketOut.println("+");
		socketOut.flush();
	}

	/**
	 * Adds spaces to the board playing space.
	 */
	void addSpaces(PrintWriter socketOut) {
		socketOut.print("          ");
		socketOut.flush();
		for (int j = 0; j < 3; j++)
		{
			socketOut.print("|     ");
			socketOut.flush();
		}
		socketOut.println("|");
		socketOut.flush();
	}
}
