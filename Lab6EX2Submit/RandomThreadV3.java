import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RandomThreadV3 extends Thread implements Runnable{
	
	ResourceV3 resource;
	
	public RandomThreadV3(ResourceV3 resource)
	{
		this.resource = resource;
		
	}
	
	public void run() {
		try {
			synchronized(resource) {
				resource.getRandomNumber();
			};			
		Thread.sleep(1);
		
		
		} catch (InterruptedException e) {
			e.printStackTrace();			}
		}
	
	public static void main(String args[]) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		int sum;
		ResourceV3 resource = new ResourceV3();
		for(int i = 0; i<5; i++)
		{
			RandomThreadV3 v = new RandomThreadV3(resource);
			executor.execute(v);
		}
		executor.shutdown();
		try {
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The first random number is: " + resource.randomNumber[0]);
		System.out.println("The second random number is: " +resource.randomNumber[1]);
		System.out.println("The third random number is: " +resource.randomNumber[2]);
		System.out.println("The fourth random number is: " +resource.randomNumber[3]);
		System.out.println("The fifth random number is: " +resource.randomNumber[4]);
		
		sum = (resource.randomNumber[0] + resource.randomNumber[1] + resource.randomNumber[2] + resource.randomNumber[3] + resource.randomNumber[4]);
		System.out.println("The sum is: " + sum);
	}
}
