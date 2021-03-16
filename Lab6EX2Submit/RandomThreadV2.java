
public class RandomThreadV2 extends Thread implements Runnable{
	
	ResourceV2 resource;
	
	public void run() {
			try {
				synchronized(resource) {
					resource.getRandomNumber();
				};			
			Thread.sleep(1);
			
			
			} catch (InterruptedException e) {
				e.printStackTrace();			}
	}
	
	public RandomThreadV2(ResourceV2 resource)
	{
		this.resource = resource;
	}
	
	public static void main(String args[]) throws InterruptedException {
		int sum;
		ResourceV2 resource = new ResourceV2();

		RandomThreadV2 t = new RandomThreadV2(resource);
		RandomThreadV2 s = new RandomThreadV2(resource);
		RandomThreadV2 u = new RandomThreadV2(resource);
		RandomThreadV2 v = new RandomThreadV2(resource);
		RandomThreadV2 w = new RandomThreadV2(resource);
		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(s);
		Thread t3 = new Thread(u);
		Thread t4 = new Thread(v);
		Thread t5 = new Thread(w);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		
		System.out.println("The first random number is: " + resource.randomNumber[0]);
		System.out.println("The second random number is: " +resource.randomNumber[1]);
		System.out.println("The third random number is: " +resource.randomNumber[2]);
		System.out.println("The fourth random number is: " +resource.randomNumber[3]);
		System.out.println("The fifth random number is: " +resource.randomNumber[4]);
		
		sum = (resource.randomNumber[0] + resource.randomNumber[1] + resource.randomNumber[2] + resource.randomNumber[3] + resource.randomNumber[4]);
		System.out.println(sum);
	}
}
