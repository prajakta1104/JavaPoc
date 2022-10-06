package Pac;

import java.util.*;

public class Student_arraylist {
	 int rno;
	  float avg=0;
	 String name;
	 int marks[];
 float total=0;
	 float per=0;
	 float t=600;
	Scanner sc = new Scanner(System.in);
	Set <Student_arraylist> set1;
	
	Student_arraylist()
	{
		
	}
	
	Student_arraylist(int r,String n,int m[])
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

	public static void main(String[] args) 
	{
		double avg=0.0;
		//Set <Student_arraylist> set1=ConvertListToSet(sobj);
		Scanner sc= new Scanner(System.in);
		
		ArrayList<Student_arraylist> sobj= new ArrayList<>();
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
			sobj.add(new Student_arraylist(rno,name,marks));
			//Collection<? extends Student_map> sourceList = Arrays.asList(sobj); Set<Integer> targetSet = new HashSet<>(sourceList);
			//display_nonduplicate(sobj);
			//Set <Student_map> obj=new HashSet<Student_map>(sourceList);
			
		}
		
		//System.out.println("Non Duplicate values");
		
		Set <Student_arraylist> set1=ConvertListToSet(sobj);
		Object set[]=set1.toArray();
		//Student_arraylist arr1[]=set1.toArray();
		//arr1[]=set1.toArray();
		Student_arraylist sa= new Student_arraylist();
		sa.display_set(set);
		
		/*Iterator itr= set1.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}*/
		
		//System.out.println(set1);
		//List<Student_arraylist> sourceList = Arrays.asList(sobj); 
		//Set <Student_arraylist> obj=new HashSet<>(sourceList);
	
		for(int i=0;i<sobj.size();i++)
		{
		 avg=avg+sobj.get(i).Cal();
		 
			System.out.println(" Data for Student"+i);
			sobj.get(i).Display();
			
			
		}
		double a=avg/5;
		
		System.out.println("The average percentage of the student"+a);
		
		
	}
	
	void display_set(Object arr[])
	{
		
		System.out.println("Non duplicate elements");
		
		for(int i=0;i<arr.length;i++)
		{
			Student_arraylist a1= (Student_arraylist) arr[i];
			System.out.println(a1.name);
		}
	}
	
	static <T> Set<T> ConvertListToSet(List<T>sobj)
	{
		//List<Student_arraylist> sourceList = Arrays.asList(sobj);
		Set <T> obj=new HashSet<>();
		for(T t:sobj)
		{
			obj.add(t);
			
		}
		return obj;
	}

}
