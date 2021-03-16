import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * The player class defines all of the specific attributes for each player, such as performing
 * a move on a players turn or general checks for who wins the game.
 * 
 * 
 * @author Matteo Messana
 * @version 1.0
 * @since January 30th, 2019
 *
 */
public class Player implements Constant 
{
	/**
	 * Member variables for the class are name, which is a string that holds the name of the player,
	 * board, which contains the board for the game, opponent which defines the opposing player,
	 * and the mark for a given player.
	 */
	private String name;
	private Board board;
	private Player opponent;
	private char mark;
	
	/**
	 * The constructor for the player which sets both the name and the mark used
	 * by the player.
	 * 
	 * @param name: holds the name of the player.
	 * @param mark: holds the mark of the current player.
	 */
	public Player(String name, char mark)
	{
		this.name = name;
		this.mark = mark;
	}	
	
	/**
	 * A setter that sets the board member variable.
	 * 
	 * @param board: holds the board object.
	 */
	public void setBoard(Board board)
	{
		this.board = board;
	}
	
	/**
	 * A setter that sets the opponent of the player.
	 * @param opponent: holds the opponent of the current player.
	 */
	public void setOpponent(Player opponent)
	{
		this.opponent = opponent;
	}
	
	/**
	 * The makeMove method prompts the player to enter a location for both the
	 * row and column that the mark is to be placed and checks to make sure that the 
	 * location entered is valid.
	 * 
	 * @throws IOException
	 */
	public void makeMove() throws IOException
	{
		System.out.printf("\nIt's %s's turn", name);
		BufferedReader stdin;
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter the row of the mark location.");
		String xPos= stdin.readLine();
		System.out.print("\nEnter the column of the mark location.");
		String yPos= stdin.readLine();
		if(xPos.length() != 1 || yPos.length() != 1 || (xPos.charAt(0) < '0' || xPos.charAt(0) > '9') || (yPos.charAt(0) < '0' || yPos.charAt(0) > '9'))
		{
			System.err.println("Error: Invalid entry, try again");
			
			makeMove();
			
		}
		int row = Integer.parseInt(xPos);
		int col = Integer.parseInt(yPos);
		
		if(row < 3 && col < 3)
		{
			if(board.getMark(row, col) == SPACE_CHAR) 
				board.addMark(row, col, mark);
			else
			{
				System.out.println("Space is already filled! try again.");
				makeMove();
			}
		}
		else
		{
			System.out.println("This location is outside of the board! Try again");
			makeMove();
		}
		
	}
	
	/**
	 * The play method is a loop that continuously loops turns for the players and checks
	 * to see if a player meets the win condition or if the board is filled. If any of those conditions are met,
	 * the game will display a message according to the condition met.
	 * @throws IOException
	 */
	public void play() throws IOException
	{
		int turn = 0;
		while(true)
		{		
			switch(turn)
			{
				case 0:
					this.makeMove();
					board.display();
					turn = 1;
					break;
				case 1:
					opponent.makeMove();
					board.display();
					turn = 0;
					break;
			}
			if(board.xWins())
			{
				System.out.printf("%s wins!",name);
				return;
			}
			
			else if(board.oWins())
			{
				System.out.printf("%s wins!",name);
				return;
			}
			else if(board.isFull())
			{
				System.out.printf("It's a tie!");
				return;
			}
			
		}		
	}
	
}
