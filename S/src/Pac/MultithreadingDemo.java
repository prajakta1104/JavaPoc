package Pac;


	
		class MultithreadingDemo extends Thread 
		{
		    public void run()
		    {
		        try {
		           
		            System.out.println(
		                "Thread " + Thread.currentThread().getId()
		                + " is running");
		            Thread.sleep(3000);
		        }
		        catch (Exception e) 
		        {
		            // Throwing an exception
		            System.out.println("Exception is caught");
		        }
		    }
		}
		 
		