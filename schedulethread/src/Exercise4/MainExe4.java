package Exercise4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;



public class MainExe4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Get a pool to schedule threads
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
	
		// Execute task 10 seconds after the application starts
	    Runnable task = new Task("Summation 100 integers");
	    ScheduledFuture<?> result = 
	    		scheduledExecutor.schedule(task, 5, TimeUnit.SECONDS);

	    // Formatting current date
		String pattern = "dd/MM/yyyy HH:mm:ss";
 		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);  	 	
 		LocalDateTime now = LocalDateTime.now();  
	 		
	 	// Display current time to mark the execution from the main( ) 
	     System.out.println("Task scheduled to execute after 5 seconds at : " 
		    		+ dtf.format(now));
	     
	     System.out.println("Shutdown and await requested at : " 
		    		+ dtf.format(now));
		    
		 shutdownAndAwaitTermination(scheduledExecutor);
	
	}
	
		static void shutdownAndAwaitTermination(ExecutorService executorService) {
		
		executorService.shutdown();
		
		try {
			if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException ie) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}

}
