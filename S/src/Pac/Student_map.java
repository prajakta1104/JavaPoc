package Pac;

import java.util.*;
import java.math.*;
public class Student_map {
	 int rno;
	  float avg=0;
	 String name;
	 int marks[];
 float total=0;
	 float per=0;
	 float t=600;
	Scanner sc = new Scanner(System.in);
	Student_map() {
		
	}
	
	Student_map(int r,String n,int m[])
	{
		 name=n;
		 rno=r;
		marks=m;
	}
	
	
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
		
		HashMap<Integer,Student_map> map= new HashMap<>();
		for(int i=1;i<6;i++)
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
			//sobj.add(new Student_map(rno,name,marks));
				map.put(i, new Student_map(rno,name,marks));
			
				 display_nonduplicate(map);
				
		}
	
		for(int i=1;i<=map.size();i++)
		{
		 avg=avg+map.get(i).Cal();
		 
			System.out.println(" Data for Student"+i);
			map.get(i).Display();
			
			}
		double a=avg/5;
		
		System.out.println("The average percentage of the student "+a);
		
		System.out.println("Non Duplicate");
		//Student_map sm= new Student_map();
		//display_nonduplicate(map);
		
	}
	static void display_nonduplicate(HashMap<Integer, Student_map> map)
	{
		Set <Student_map> obj=new HashSet<Student_map>();
		obj.addAll((Collection<? extends Student_map>) map);
		Iterator itr= obj.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
	
	


}
