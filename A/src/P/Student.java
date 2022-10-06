package P;

import java.util.Scanner;

public class Student 
{
	int rno;
	String name;
	int marks[];
	int per,total;
	Scanner sc = new Scanner(System.in);
	
	void accept()
	{
		 marks = new int [6];
		System.out.println("Enter Rollno:");
		rno=sc.nextInt();
		System.out.println("Enter Name:");
		name=sc.next();
		System.out.println("Enter Marks");
		for(int i=0;i<6;i++)
		{
			marks[i]=sc.nextInt();
		}
		
	}
	
	double Cal()
	{
		
		for(int i =0;i<6;i++)
		{
			total+=marks[i];
		}
		per=total/6;
		return per;
	}
	void Display()
	{
		System.out.println("Roll no:"+rno);
		System.out.println("Name:"+name);
		System.out.println("Percentage:"+Cal());
	}

	public static void main(String[] args) 
	{
		Student s= new Student();
		s.accept();
		s.Display();

	}
}


