package Pac;

import java.util.Scanner;
import java.util.*;

public class Student_Linkedlist {
	 int rno;
	  float avg=0;
	 String name;
	 int marks[];
 float total=0;
	 float per=0;
	 float t=600;
	Scanner sc = new Scanner(System.in);
	
	Student_Linkedlist(int r,String n,int m[])
	{
		 name=n;
		 rno=r;
		marks=m;
	}
	
	/*float Cal_Avg()
	{
		
		return avg; 
	}*/
	float Cal()
	{
		
		for(int i =0;i<6;i++)
		{
			total=total+marks[i];
		}
		System.out.println(total);
		per=total/6;
		total=0;
		return per;
		
	}
	void Display()
	{
		System.out.println("Roll no:"+rno);
		System.out.println("Name:"+name);
		System.out.println("Percentage:"+Cal());
		
	}

	public static void main(String[] args) {
		double avg=0.0;
		
		Scanner sc= new Scanner(System.in);
		
		LinkedList <Student_Linkedlist> sobj= new LinkedList<>();
		for(int i=0;i<5;i++)
		{
			 int marks[] = new int [6];
			 System.out.println("Enter Data for Student"+i);
				System.out.println("Enter Rollno:");
				int rno=sc.nextInt();
				System.out.println("Enter Name:");
				String name=sc.next();
				System.out.println("Enter Marks");
				for(int j=0;j<6;j++)
				{
					
					marks[j]=sc.nextInt();
					
				}
			sobj.add(new Student_Linkedlist(rno,name,marks));
			
			
		}
	
		for(int i=0;i<sobj.size();i++)
		{
		 avg=avg+sobj.get(i).Cal();
		 
			System.out.println(" Data for Student"+i);
			sobj.get(i).Display();
			
			
		}
		double a=avg/5;
		
		System.out.println("The average percentage of the student"+a);
	}

}
