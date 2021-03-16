import java.io.*;
/**
 * Class referee is a class that controls the game. It sets each player for
 * the game, displays the game board, and then initiates the initial play.
 * 
 * @author Matteo Messana
 * @version 1.0
 * @since January 30th, 2019
 * 
 *
 */
public class Referee 
{
	/**
	 * The member variables for this method are xPlayer and oPlayer 
	 * which both hold the individual players of the game as well as the
	 * board which contains the board for the game.
	 */
	private Player xPlayer;
	private Player oPlayer;
	private Board board;
		
	/**
	 * Constructor for referee, does not need to set any value as
	 * the program has setters that set the member variables already.
	 */
	public Referee()
	{
		
	}
	
	/**
	 * A setter used to set the o Player.
	 * @param oPlayer: holds an object of the oPlayer.
	 */
	public void setoPlayer(Player oPlayer)
	{
		this.oPlayer = oPlayer;
	}
	
	/**
	 * A setter used to set the x Player.
	 * @param xPlayer: holds an object of the xPlayer.
	 */
	public void setxPlayer(Player xPlayer)
	{
		this.xPlayer = xPlayer;
	}
	
	/**
	 * A setter used to set the board for the game.
	 * @param board: holds the object of board.
	 */
	public void setBoard(Board board)
	{
		this.board = board;
	}
	
	/**
	 * A method used to control the initiation of the game such as setting the player's
	 * opponents, display the board, and then initiates the x Player to start.
	 * 
	 * @throws IOException
	 */
	public void runTheGame() throws IOException
	{
		this.xPlayer.setOpponent(this.oPlayer);
		this.oPlayer.setOpponent(this.xPlayer);
		this.board.display();
		xPlayer.play();
	}
}
