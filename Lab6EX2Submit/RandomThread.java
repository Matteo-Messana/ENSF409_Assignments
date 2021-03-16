
public class RandomThread extends Thread implements Runnable{
	
	Resource resource;
	int randomNumber;
	
	public void run() {
			try {
				synchronized(resource) {
					randomNumber = resource.getRandomNumber();
				};			
			Thread.sleep(1);
			
			
			} catch (InterruptedException e) {
				e.printStackTrace();			}
	}
	
	public RandomThread(Resource resource)
	{
		this.resource = resource;
		randomNumber = 0;
	}
	
	public static void main(String args[]) throws InterruptedException {
		int sum;
		Resource resource = new Resource();

		RandomThread t = new RandomThread(resource);
		RandomThread s = new RandomThread(resource);
		RandomThread u = new RandomThread(resource);
		RandomThread v = new RandomThread(resource);
		RandomThread w = new RandomThread(resource);
		
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
		
		System.out.println(t.randomNumber);
		System.out.println(s.randomNumber);
		System.out.println(u.randomNumber);
		System.out.println(v.randomNumber);
		System.out.println(w.randomNumber);
		
		sum = (t.randomNumber + s.randomNumber + u.randomNumber + v.randomNumber + w.randomNumber);
		System.out.println(sum);
	}
}
