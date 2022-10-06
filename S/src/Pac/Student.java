package Pac;

import java.util.Scanner;


public class Student {
	 int rno;
	  float avg=0;
	 String name;
	 int marks[];
 float total=0;
	 float per=0;
	 float t=600;
	Scanner sc = new Scanner(System.in);
	
	void accept(int r,String n,int m[])
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
		Student s= new Student();
		Scanner sc= new Scanner(System.in);
		Student sobj[]= new Student[5];
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
			
			sobj[i]=new Student();
			sobj[i].accept(rno,name,marks);
			//accept();
			
		}
	
		for(int i=0;i<5;i++)
		{
		 avg=avg+sobj[i].Cal();
		 
			System.out.println(" Data for Student"+i);
			sobj[i].Display();
			//System.out.println(" percentage"+sobj[i].per);
			
		}
		double a=avg/5;
		
		System.out.println("The verage percentage of the student"+a);
	}

}
