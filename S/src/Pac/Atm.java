package Pac;

import java.util.*;
import java.util.Scanner;


public class Atm
{
	 Atm()
	 {
		 
	 }
	 boolean flag=true;
	
	Scanner sc = new Scanner(System.in);
	TreeMap <Integer,Atm> atm = new TreeMap<>();
	int withdraw,deposit;
	int acno=0;
	double  Balance=10000;
	String name;
	Atm(String n,double bal)
	{
		name=n;
		Balance=bal;
	}
	
	void Check_Balance()
	{
		System.out.println("Your current balace is"+Balance);
	}
	
	void Deposit()
	{
		//System.out.println("Your Balance is:"+Balance);
		try
		{
			if(deposit<0)
			{
				throw new InvalidAmtException();
			}
			else
			{
				System.out.println("Enter AcNo.");
				acno= sc.nextInt();
				
				/*Iterator <Integer> it = atm.keySet().iterator();
				while(it.hasNext())
				{
					int key=(int)it.next();
					if(acno==key)
					{
						
						
						//atm.get(acno).Deposit(d);
					}
				}*/
				 
				
			   //Iterator <Atm> it1 = atm.get();
				
				for (Map.Entry<Integer,Atm> e : atm.entrySet())
				{
					int k=e.getKey();
					
			   
				   if(k==acno)
				   {
					   System.out.println("Your Balance Is : "+e.getValue().Balance);
					   System.out.println("Enter the Amount to deposit");
						int d=sc.nextInt();   
					  // atmet(it1);
					   Atm temp=e.getValue();
					   System.out.println("temp"+temp.name+" "+temp.Balance);
					   //Balance+=deposit;
					   e.getValue().Balance=e.getValue().Balance+d;
					   // Balance=e.getValue().Balance+d;
					   //b=b+d;
					   //double bal=Balance;
					   //atm.get(e).Balance=b;
					   Atm obj=e.getValue();
					   System.out.println("obj"+temp.name+" "+temp.Balance);
					   //atm.get(it1).Balance+=deposit;
					   e.setValue(obj);
					   //----atm.replace(k,temp,obj);
					   //atm.put(k, obj);
					  
					   System.out.println("Amount has been successfully deposited..");
					   System.out.println("Your Current Balance is:"+e.getValue().Balance);
					   
				   }
				   
				   
			}int l=atm.lastEntry().getKey();
			acno=l+1;
			
				//acno++;
			   }
		}
			catch(InvalidAmtException e)
		{
				e.printStackTrace();
		}
		
		
	}
	void display()
	{
		
		System.out.println("Name"+name);
		System.out.println("Balance"+Balance);
	}
	
    void Withdraw()
    {
    	System.out.println("Enter AcNo.");
		acno= sc.nextInt();
		Iterator <Integer> it1 = atm.keySet().iterator();
		while(it1.hasNext())
		{
			int key=(int)it1.next();
			if(acno==key)
			{
				System.out.println("Enter the Amount to Withdraw");
				//w=sc.nextInt();
				//atm.get(acno).Withdraw(w);
			}
		}
    	System.out.println("Your balance is:"+Balance);
    	try
    	{
    		if(Balance<500 || Balance<=withdraw)
    		{
    			throw new InSufficientAmtException();
    		}
    		else if(withdraw<0)
    		{
    			throw new  InvalidAmtException();
    		}
    		else
    		{
    			Balance-=withdraw;
    			System.out.println("Amount has been debited from your account..");
    			System.out.println("Your Current Balance is:"+Balance);
    		}
    	}
    	catch(InSufficientAmtException e)
    	{
    		e.printStackTrace();
    	}
    	catch( InvalidAmtException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    /*void  Create_acc()
    {
    	System.out.println("Enter Name");
    	name=sc.next();
    	System.out.println("Enter Balance");
    	Balance=sc.nextInt();
    
    }*/
    void operation()
    {
    	
    	int ch,d,w;
		String name;
		int Balance;
		Scanner sc = new Scanner(System.in);
		 
		//acno=1;
		
		/*Atm a1= new Atm("abc",5000);
		Atm a2= new Atm("ahs",7000);
		Atm a3= new Atm("bcd",8000);
		Atm a4= new Atm("cfg",15000);
		Atm a5= new Atm("xml",10000);
		HashMap <Integer,Atm> atm = new HashMap<>();
		atm.put(123,a1 );
		atm.put(124,a2 );
		atm.put(125,a3 );
		atm.put(126,a4 );
		atm.put(127,a5 );*/
		//System.out.println("Enter AcNo.");
		//acno= sc.nextInt();
		
		/*Iterator <Integer> it = atm.keySet().iterator();
		while(it.hasNext())
		{
			int key=(int)it.next();
			if(acno==key)
			
			{*/
		
				do
				{
				System.out.println("Welcome To ABC Bank");
				System.out.println("*********************");
				System.out.println("1. Deposite Money to Bank");
				System.out.println("2. Withdraw Money from Bank");
				System.out.println("3. Check Balance");
				System.out.println("4. Create Account");
				System.out.println("5. Display");
				
				System.out.println("Enter your Choice");
				ch=sc.nextInt();
				
				switch(ch)
				{
				
				case 1: Deposit();
				break;
				
				case 2:
				break;
				case 3: System.out.println("Enter AcNo.");
						acno= sc.nextInt();
						Iterator <Integer> it2 = atm.keySet().iterator();
						while(it2.hasNext())
						{
							int key=(int)it2.next();
							if(acno==key)
							{
								atm.get(acno).Check_Balance();
							}
						}
				break;
				case 4:
					for(int i=0;i<10;i++)
					{
					
						System.out.println("Enter Name");
		    			name=sc.next();
		    			System.out.println("Enter Balance");
		    			Balance=sc.nextInt();
		    			atm.put(acno,new Atm(name,Balance));
		    			acno++;
		    			
		    			System.out.println("Click 1 If want to see menu");
		    			int c= sc.nextInt();
		    			if(c==1)
		    			{
		    				//operation();
		    				break;
		    			}
		    			else
		    			{
		    				System.out.println("Thank you...");
		    				flag=false;
		    			}
		    			//i++;
		    			break;
		    			
		    			//operation();
					}
		    	break;
				case 5:
					for(int i=0;i<atm.size();i++)
					{
						atm.get(i).display();
					}
				break;
					default: System.out.println("Plz Enter Right Choice");
				}
				
				}
				while(flag);
				
    }
	public static void main(String[] args)
	{
		Atm a= new Atm();
		
		
			a.operation();
	}
			
		
}

