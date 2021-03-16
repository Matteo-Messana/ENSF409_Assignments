import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Palindrome implements Runnable{	
	/**
	 * out sending out the message to the server
	 */
	public PrintWriter out;
	/**
	 * in reciving the message form server.
	 */
	public BufferedReader in;
	
	/**
	 * Constructor for Palindrome class
	 * @param in: BufferedReader input
	 * @param out: PrintWriter output
	 */
	public Palindrome(BufferedReader in, PrintWriter out)
	{
		this.out = out;
		this.in = in;
	}
	
	/**
	 * A runnable function for the client server application
	 */
	@Override
	public void run()
	{
		
		String line = null;
		while(true)
		{
			try {
				line = in.readLine();
				if(line.equals("QUIT"))
				{
					line = "Program terminated.";
					out.println(line);
					break;
				}
				if(isPalindrome(line) == true)
				{
					line = line + " is a Palindrome!";
					out.println(line);
				}
				else 
				{
					line = line + " is not a Palindrome!";
					out.println(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Checks to see if the input word is a Palindrome
	 * @param line: input string to check.
	 * @return boolean to see if true or false.
	 */
	public boolean isPalindrome(String line)
	{
		for(int i=0,j=line.length()-1;i<line.length();i++,j--)
		{
			if(line.charAt(i) != line.charAt(j))
			{
				return false;
			}
		}
		return true;
	}
	
}
