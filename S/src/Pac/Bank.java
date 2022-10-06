package Pac;

import java.util.Scanner;

public class Bank
{
	
	int Balance=10000,withdraw,deposit;
	
	void Check_Balance()
	{
		System.out.println("Your current balace is"+Balance);
	}
	
	void Deposit(int deposit)
	{
		System.out.println("Your Balance is:"+Balance);
		try
		{
			if(deposit<0)
			{
				throw new InvalidAmtException();
			}
			else
			{
				Balance+=deposit;
				System.out.println("Amount has been successfully deposited..");
				System.out.println("Your Current Balance is:"+Balance);
			}
		}
			catch(InvalidAmtException e)
		{
				e.printStackTrace();
		}
		
		
	}
	
    void Withdraw(int withdraw)
    {
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
	public static void main(String[] args)
	{
		int ch,d,w;
		Scanner sc = new Scanner(System.in);
		Bank b=new Bank();
		do
		{
		System.out.println("Welcome To ABC Bank");
		System.out.println("1. Deposite Money to Bank");
		System.out.println("2. Withdraw Money from Bank");
		System.out.println("3. Check Balance");
		
		System.out.println("Enter your Choice");
		ch=sc.nextInt();
		
		switch(ch)
		{
		case 1: System.out.println("Enter the Amount to deposit");
				d=sc.nextInt();
				b.Deposit(d); 
		break;
		
		case 2:	System.out.println("Enter the Amount to Withdraw");
				w=sc.nextInt();
			  b.Withdraw(w);
		break;
		case 3: b.Check_Balance();
		break;
		default: System.out.println("Plz Enter Right Choice");
		}
		
		}
	while(true);
	}

}
