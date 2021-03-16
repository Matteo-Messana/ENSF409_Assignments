import java.util.Scanner;

public class sentenceChanger 
{
	private char [][] outputSentences;
	public sentenceChanger()
	{
		outputSentences = new char[3][60];
	}
	
	
	public void sentence1Modification(String input)
	{
		int i = input.length()-1;
		for(int j = 0; j<input.length(); j++)
		{
			this.outputSentences[0][j] = input.charAt(i);
			i--;
		}
	}
	
	public void sentence2Modification(String input)
	{
		int indexVal = input.length()-1;
		int tempLength = 0;
		int tempIndex = 0;
		for(int i = indexVal; i>=0; i--)
		{
			if(input.charAt(i) == ' ')
			{
				for(int j = i+1; j<=indexVal; j++)
				{
					this.outputSentences[1][tempIndex] = input.charAt(j);
					tempIndex++;
					tempLength++;
				}
				this.outputSentences[1][tempIndex] = ' ';
				tempIndex++;
				indexVal = (indexVal - tempLength)-1;
				tempLength = 0;
			}
			if(i == 0)
			{
				for(int j = i; j<=indexVal; j++)
				{
					this.outputSentences[1][tempIndex] = input.charAt(j);
					tempIndex++;
				}
			}
			
		}
		
	}
	
	public void sentence3Modification(String input)
	{
		int indexCounter = 0;
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
			{
				indexCounter++;
			}
			
			if((indexCounter % 5) == 0)
			{
				this.outputSentences[2][i] = Character.toUpperCase(input.charAt(i));
			}
			else
			{
				this.outputSentences[2][i] = input.charAt(i);
			}
		}
	}
	
	public void sentenceCheck(char[] input) 
	{
		
		if(input.length > 60)
		{
			System.err.println("Error: Sentence is longer than 60 characters. Try again");
			System.exit(0);
		}
		else if(input.length == 0) 
		{
			System.err.println("Error: You didn't enter anything. Try again");
			System.exit(0);
		}
		
	}
	
	public static void main (String args [])
	{ 
		System.out.println("Enter the first short sentence (less than 60 characters)");
		Scanner scanner = new Scanner(System.in);
		String inputSentence1 = scanner.nextLine();
		
		sentenceChanger output = new sentenceChanger();
		
		if(inputSentence1.length() > 60)
		{
			System.err.println("Error: Sentence is longer than 60 characters.");
			System.exit(0);
		}
		else if(inputSentence1.length() == 0) 
		{
			System.err.println("Error: You didn't enter anything.");
			System.exit(0);
		}
		for(int i = 0; i<inputSentence1.length(); i++)
		{
			output.outputSentences[0][i] = inputSentence1.charAt(i);
		}
		
		
		
		System.out.println("Enter the second short sentence (less than 60 characters)");
		String inputSentence2 = scanner.nextLine();
		if(inputSentence2.length() > 60)
		{
			System.err.println("Error: Sentence is longer than 60 characters. Try again");
			System.exit(0);
		}
		else if(inputSentence2.length() == 0) 
		{
			System.err.println("Error: You didn't enter anything. Try again");
			System.exit(0);
		}
		
		for(int i = 0; i<inputSentence2.length(); i++)
		{
			output.outputSentences[1][i] = inputSentence2.charAt(i);
		}
		
		
		System.out.println("Enter the last short sentence (less than 60 characters)");
		String inputSentence3 = scanner.nextLine();
		if(inputSentence3.length() > 60)
		{
			System.err.println("Error: Sentence is longer than 60 characters. Try again");
			System.exit(0);
		}
		else if(inputSentence3.length() == 0) 
		{
			System.err.println("Error: You didn't enter anything. Try again");
			System.exit(0);
		}
		
		for(int i = 0; i<inputSentence3.length(); i++)
		{
			output.outputSentences[2][i] = inputSentence3.charAt(i);
		}
		
		
		
		System.out.println("The modified sentences are:");
		for(int i = 0; i<inputSentence1.length(); i++)
		{
			output.sentence1Modification(inputSentence1);
			System.out.print(output.outputSentences[0][i]);			
		}
		System.out.print("\n");
		
		for(int i = 0; i<inputSentence2.length();i++)
		{
			output.sentence2Modification(inputSentence2);
			System.out.print(output.outputSentences[1][i]);
		}
		System.out.print("\n");
		
		for(int i = 0; i<inputSentence3.length();i++)
		{
			output.sentence3Modification(inputSentence3);
			System.out.print(output.outputSentences[2][i]);
		}
		
	}

}
