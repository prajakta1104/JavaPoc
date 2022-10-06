package Pac;

import java.util.*;
import java.util.Scanner;


public class Atm1
{
	 Atm1()
	 {
		 
	 }
	 static boolean flag=true;
	 int execp=0;
	Scanner sc = new Scanner(System.in);
	TreeMap <Integer,Atm1> atm = new TreeMap<>();
	int withdraw,deposit;
	int acno=0;
	double  Balance=10000;
	String name;
	Atm1(String n,double bal)
	{
		name=n;
		Balance=bal;
	}
	
	void Check_Balance()
	{
		
		System.out.println("Enter AcNo.");
		acno= sc.nextInt();
		
		try
		{
			for (Map.Entry<Integer,Atm1> e : atm.entrySet())
			{
				int k=e.getKey();
				if(atm.containsKey(acno))
				{
					if(k==acno)
					   {
						   System.out.println("Your Balance Is : "+e.getValue().Balance);
					   }
				}
		   
			   
			   else
			   {
				   execp=1;
				   
			   }
			}
			if(execp==1)
			{
				throw new InvalidAccNumberException();
			}
			
		}
		catch(InvalidAccNumberException e)
		{
			e.printStackTrace();
		}
		
	}
	void Check_Details()
	{
		try
		{
			System.out.println("Enter Acno:");
			acno=sc.nextInt();
			
			for (Map.Entry<Integer,Atm1> e : atm.entrySet())
			{
				int k=e.getKey();
				
				if(atm.containsKey(acno))
				{
					 if(k==acno)
					   {
						   System.out.println("Your Account Number is : "+e.getKey());
						   System.out.println("Your Name: "+e.getValue().name);
						   System.out.println("Your Balance: "+e.getValue().Balance);
					   }
				}
				else
			   {
				   
					execp=1;
			   }
			}
			if(execp==1)
			{
				throw new InvalidAccNumberException();
			}
		}
			catch(InvalidAccNumberException e)
			{
				e.printStackTrace();
			}
	}
	
	void Deposit()
	{
		
		System.out.println("Enter AcNo.");
		acno= sc.nextInt();
		try
		{
		
			for (Map.Entry<Integer,Atm1> e : atm.entrySet())
			{
				int k=e.getKey();
				if(atm.containsKey(acno))
				{
					
					 if(k==acno)
					   {
						   System.out.println("Your Balance Is : "+e.getValue().Balance);
						   System.out.println("Enter the Amount to deposit");
						   int d=sc.nextInt();   
						   if(d<0)
							{
							   int l=atm.lastEntry().getKey();
								acno=l+1;
								throw new InvalidAmtException();
							}
						   else
						   {
							   Atm1 temp=e.getValue();
							  e.getValue().Balance=e.getValue().Balance+d;
							  Atm1 obj=e.getValue();
							   
							    e.setValue(obj);
							   
							   System.out.println("Amount has been successfully deposited..");
							   System.out.println("Your Current Balance is:"+e.getValue().Balance);
							}
							
					   }
				}
				
			   else
			   {
				   execp=1;
				  // System.out.println("$$$$$$$$$$$$$$$$$");
				   break;
				   //throw new InvalidAccNumberException();
			   }
			   
		}
			if(execp==1)
			{
				int l=atm.lastEntry().getKey();
				acno=l+1;
				throw new InvalidAccNumberException();
			}
			
			int l=atm.lastEntry().getKey();
		acno=l+1;
			
		}
			catch(InvalidAmtException e)
		{
				e.printStackTrace();
		}
		catch(InvalidAccNumberException e)
		{
			e.printStackTrace();
		}
		
	}
	void display()
	{
		System.out.println("--------------------------------------");
		System.out.println("Name 					|    Balance");
		System.out.println("--------------------------------------");
		for (Map.Entry<Integer,Atm1> e : atm.entrySet())
		{
			
			   System.out.println(e.getValue().name+ "   |"+e.getValue().Balance);
			   System.out.println("--------------------------------------");
			
		   
		   
		}
		
		
	}
	
    void Withdraw()
    {
    	 //int execp=0;
    	System.out.println("Enter AcNo.");
		acno= sc.nextInt();
		
    	try
    	{
			for (Map.Entry<Integer,Atm1> e : atm.entrySet())
			{
				int k=e.getKey();
				if(atm.containsKey(acno))
				{
					if(k==acno)
					   {
						   System.out.println("Your Balance Is : "+e.getValue().Balance);
						   System.out.println("Enter the Amount to withdraw");
							int w=sc.nextInt();
						   if(e.getValue().Balance<500 || e.getValue().Balance<=w)
				    		{
							   int l=atm.lastEntry().getKey();
								acno=l+1;
				    			throw new InSufficientAmtException();
				    		}
						   else
						   {
							   if(w<0 )
					    		{
									 int l=atm.lastEntry().getKey();
										acno=l+1;
					    			throw new  InvalidAmtException();
					    		}
								
								 else
								 {
									 Atm1 temp=e.getValue();
									  e.getValue().Balance=e.getValue().Balance-w;
									  Atm1 obj=e.getValue();
									   e.setValue(obj);
									    System.out.println("Amount has been successfully debited..");
									   System.out.println("Your Current Balance is:"+e.getValue().Balance); 
								 }
						   	  }
						   
					   		}
					  }
				else
				{
					execp=1;
					break;
				}
					
			}
			if(execp==1)
			{
				int l=atm.lastEntry().getKey();
				acno=l+1;
				throw new InvalidAccNumberException();
			}
		   
			int l=atm.lastEntry().getKey();
			acno=l+1;
			}
    	catch(InSufficientAmtException e)
    	{
    		e.printStackTrace();
    	}
    	catch( InvalidAmtException e)
    	{
    		e.printStackTrace();
    	}
    	catch( InvalidAccNumberException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    void Create_Acc()
    {
    	for(int i=0;i<10;i++)
		{
		
			System.out.println("Enter Name");
			name=sc.next();
			System.out.println("Enter Balance");
			Balance=sc.nextInt();
			atm.put(acno,new Atm1(name,Balance));
			acno++;
			
			System.out.println("Click 1 If want to see menu");
			int c= sc.nextInt();
			if(c==1)
			{
				
				break;
			}
			else
			{
				System.out.println("Thank you...");
				flag=false;
			}
			
			break;
		}
    	
    }
    
  
	public static void main(String[] args)
	{
		
			Atm1 a= new Atm1();
			int ch,d,w;
			String name;
			int Balance;
			Scanner sc = new Scanner(System.in);
			 
			
					do
					{
					System.out.println("Welcome To ABC Bank");
					System.out.println("*********************");
					System.out.println("1. Deposite Money to Bank");
					System.out.println("2. Withdraw Money from Bank");
					System.out.println("3. Check Balance");
					System.out.println("4. Create Account");
					System.out.println("5. Check Details ");
					System.out.println("6. Display");
					
					System.out.println("Enter your Choice");
					ch=sc.nextInt();
					
					switch(ch)
					{
					
					case 1: a.Deposit();
					break;
					
					case 2: a.Withdraw();
					break;
					case 3: a.Check_Balance();
						
					break;
					case 4:
							a.Create_Acc();
			    	break;
					case 5: a.Check_Details();
					break;
					case 6:
							a.display();
					break;
						default: System.out.println("Plz Enter Right Choice");
					}
					
					}
					while(flag);
					
	}
			
		
}

