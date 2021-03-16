package inlab4;
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
public class Game implements Constant, Runnable {
	
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
        theRef.setBoard(theBoard);
		theRef.getxPlayer().setBoard(theBoard);
		theRef.getoPlayer().setBoard(theBoard);
    	
    }

    /**
     * run s the game
     */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			theRef.runTheGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
