import java.util.Scanner;
import java.util.*;

public class MarathonArray 
{
	private ArrayList<Integer> times;
	private ArrayList<String> names;
	
	public MarathonArray()
	{
		times = new ArrayList<Integer>();
		names = new ArrayList<String>();
	}
	
	public int findFastestRunner()
	{
		int fastestTime = times.get(0);
		int fastestIndex = 0;
		for(int Index = 0; Index < times.size(); Index++)
		{
			if(fastestTime > times.get(Index))
			{
				fastestTime = times.get(Index);
				fastestIndex = Index;
			}
		}	
		return fastestIndex;
	}
	
	public static void main(String[] args) 
	{
		// Define two array lists here to store the names and the running times 
		MarathonArray list = new MarathonArray();
		
		// Read user input
		String sin;
		int indexOfFastestRunner;
		Scanner scan = new Scanner(System.in);
		while (true)
		{
			System.out.println("Please enter the name of the participant");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
			break;
			// Add the name to your ArrayList
			list.names.add(sin);
			
			System.out.println("Please enter the running time of the participant");
			sin = scan.nextLine();
			// Add the running time to your array list
			list.times.add(Integer.parseInt(sin));
		}
		int fastestIndex = list.findFastestRunner();
		String fastestName = list.names.get(fastestIndex);
		int fastestTime = list.times.get(fastestIndex);
		
		System.out.printf("The fastest runner is %s with a time of %d", fastestName, fastestTime);
		// Call the function findFastestRunner and pass the running times array list to it
		// Print the name of the fastest runner to the console
	}

}
