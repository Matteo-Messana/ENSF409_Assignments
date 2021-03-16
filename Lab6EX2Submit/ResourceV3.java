import java.util.Random;

public class ResourceV3 {

	int index = 0;
	int [] randomNumber = new int[5];
	final int min = 1;
	final int max = 100;
	
	public void getRandomNumber() {
		Random rand = new Random();
		randomNumber[index] = rand.nextInt(max+1)+min;
		index++;
	}
	
}
