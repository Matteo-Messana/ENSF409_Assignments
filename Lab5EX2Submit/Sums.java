
import java.io.*;

public class Sums {

    public static void sum(BufferedReader in){ 
        // takes a sequence of integers as inputs, and outputs their sum

	int s, nextInt = 0;
	s = 0;
	boolean check;
	System.out.println("Please input the sequence of integers to sum, terminated by a 0");
       do
       {
    	   check = false;
    	   try {
			nextInt = Integer.parseInt(in.readLine());
    	   		} 
    	   catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("This is not a number. Please try again.");
			check = true;
    	   	} 
    	   catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid entry. Please try again.");
			check = true;
			}
       }
       while(check);
                //Read next datum in input. An integer is expected

	while (nextInt!=0) {
	    s = s + nextInt;
	    do
	    {
	    	check = false;
	    try {
			nextInt = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("This is not a number. Please try again.");
			check = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid entry. Please try again.");
			check = true;
		}
	    }while(check);
	}

        System.out.println("The sum is " + s);
    }

    public static void main(String[] arg) {         

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                         //"in" will receive data from the standard input stream
	String c = null;
 
	boolean check;
	
	System.out.println("Do you wish to calculate a sum? (y/n)");

	do
	{
		check = false;
	try {
		c = in.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Invalid entry. Please try again.");
		check = true;
	}
	}while(check);
         //Read next datum in input. A string "y" or "n" is expected
	
	while (!c.equals("y") && !c.equals("n")) {
	    System.out.println("Please answer y or n");
	    do
		{
			check = false;
		try {
			c = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid entry. Please try again.");
			check = true;
		}
		}while(check);
	}

	while (c.equals("y")) {
	    sum(in);
	    System.out.println("Do you wish to calculate another sum? (y/n)");
	    do
		{
			check = false;
		try {
			c = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid entry. Please try again.");
			check = true;
		}
		}while(check);

	    while (!c.equals("y") && !c.equals("n")) {
		System.out.println("Please answer y or n");
		do
		{
			check = false;
		try {
			c = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid entry. Please try again.");
			check = true;
		}
		}while(check);
	    }
	}

	System.out.println("Goodbye");
    }
}
