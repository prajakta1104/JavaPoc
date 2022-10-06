package Pac;

public class MultiThreadingDemo2 implements Runnable
{

	
		    public void run()
		    {
		        try {
		            // Displaying the thread that is running
		            System.out.println(
		                "Thread " + Thread.currentThread().getId()
		                + " is running");
		        }
		        catch (Exception e) {
		            // Throwing an exception
		            System.out.println("Exception is caught");
		        }
		    }
		}

		 
		
	
