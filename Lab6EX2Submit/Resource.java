import java.util.Random;

public class Resource {

	int randomNumber;
	final int min = 1;
	final int max = 100;
	
	public int getRandomNumber() {
		Random rand = new Random();
		randomNumber = rand.nextInt(max+1)+min;
		return randomNumber;
	}
	
}
