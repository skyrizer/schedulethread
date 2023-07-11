package Exercise4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Task implements Runnable {

	private String name;
	private int sum =0;
	
	/**
	 * Constructor - initialize field
	 * 
	 * @param name
	 */
	// test
	public Task(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		for(int i=0;i<100;i++) {
			sum = sum + random.nextInt(100);
		}
		// Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  
			
		// Get current time
		LocalDateTime now = LocalDateTime.now();  
				
		// Display task and execution time
		System.out.println("\nTask " + name + " executed on : " + dtf.format(now));

		System.out.println("The total summation of 100 random numbers are " + sum);
	}

}
