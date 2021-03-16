
import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 * The purpose of this class is to create all of the objects for the game
 * and run the game inside of main.
 * 
 * 
 * @author Matteo Messana
 * @version 1.0
 * @since January 28th, 2019
 *
 */
public class Game implements Constant {
	
	/**
	 * Game has two member variable, one of type Board and the other of type Referee.
	 */
	private Board theBoard;
	private Referee theRef;
	
	/**
	 * the default constructor for Game. Creates a board object and assigns 
	 * it to theBoard member variable.
	 */
    public Game( ) {
        theBoard  = new Board();
	}
    
    /**
     * Assigns r to the member variable theRef and executes
     * member method to run the game.
     * 
     * @param r: takes object of type referee.
     * @throws IOException
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
    /**
     * Main function that calls all necessary functions to
     * play the game.
     * 
     * @param args: used for command line inputs.
     * @throws IOException
     */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}
