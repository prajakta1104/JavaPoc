package Pac;

import java.util.*;


public class ListOperationExample {

	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) 
	{
		 
		ListOperationExample s2= new ListOperationExample();
		StudentPojo studentPojo= new StudentPojo();
		int marks_total=0;
		float percentage;
		int rollNumber;
		String name;
		ArrayList<StudentPojo> al = new ArrayList<>();
		
		
		System.out.println("Enter data for student ");
		for(int i=0;i<2;i++)
		{
			int Student_marks[]= new int [3];
			System.out.println("Enter roll no:");
			rollNumber=sc.nextInt();
		
			System.out.println("Enter name:");
			name=sc.next();
			//s.setName(n);
			
			System.out.println("Enter marks");
			for(int j=0;j<Student_marks.length;j++)
			{
				
				Student_marks[j]=sc.nextInt();
				
				marks_total=marks_total+Student_marks[j];
				
			}
			percentage=marks_total/3;
			
			studentPojo.setRno(rollNumber);
			studentPojo.setName(name);
			studentPojo.setMarks(Student_marks);
			studentPojo.setTotal(marks_total);
			studentPojo.setPercent(percentage);
			
			al.add(new StudentPojo(rollNumber,name,Student_marks,marks_total,percentage));
			marks_total=0;
			
		}
		
		/*for (StudentPojo stud1 : al) {
			System.out.println(stud1.getName() +"."+Arrays.toString(stud1.getMarks())+"...."+stud1.getPercent());
		}*/
		Set<StudentPojo> set1= new HashSet<>();
		 set1=ConvertListToSet(al);
		Object set[]=set1.toArray();
		Set <StudentPojo> sort1= new TreeSet<
				StudentPojo>(new SortByName());
		sort1.addAll(set1);
		 
		Object set2[]=sort1.toArray();
	
		int[] ary= new int[6];
		
		
		//*******************Arraylist Display*******************
		
		for(int i=0;i<al.size();i++)
		{
			ary=al.get(i).getMarks();
			System.out.println("Roll Number :"+al.get(i).getName());
			System.out.println("Name : "+al.get(i).getName());
			System.out.println("Marks :");
			//for(intj=0;j<)
			System.out.println("Marks"+i);
			
			System.out.println("Total :"+al.get(i).getTotal());
			System.out.println("Percentage :"+al.get(i).getPercent());
		}
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.printf("%10s %20s %20s  %20s %20s ","Roll No","Name","Marks","Total","Percentage");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		for(int i=0;i<al.size();i++)
		{
			 ary=al.get(i).getMarks();
				System.out.format("%12s %22s %22s %22s %22s",al.get(i).getRno(),al.get(i).getName(),Arrays.toString(ary),al.get(i).getTotal(),al.get(i).getPercent());
				
				/*Stud1 a=al.get(i);
				for(int j=0;j<m.length;j++)
				{
					int p=a.getMarks()[j];
					System.out.format("%22s",p);
				}*/
				//System.out.format("%22s %22s",al.get(i).getTotal(),al.get(i).getPercent());
				
				System.out.println();
				   System.out.println("--------------------------------------------------------------------------------------------------------");
			
		}
		
		s2.display_set(set);
		s2.display_sorted(set2);
		
	}
		
		static <T> Set<T> ConvertListToSet(List<T>al)
		{
			
			Set <T> obj=new HashSet<>();
			for(T t:al)
			{
				obj.add(t);
				
			}
			return obj;

		}
		
		void display_set(Object arr[])
		{
			System.out.println();
			System.out.println("Non duplicate elements");
			
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.printf("%10s %20s %20s  %20s","Roll No","Name","Total","Percentage");
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			
			for(int i=0;i<arr.length;i++)
			{
				StudentPojo a1= (StudentPojo) arr[i];
				
				System.out.format("%12s %22s %22s  %22s",a1.getRno(),a1.getName(),a1.getTotal(),a1.getPercent());
				
				System.out.println();
				   System.out.println("--------------------------------------------------------------------------------------------------------");
			}
			
			
		}
		
		void display_sorted(Object arr[])
		{
			System.out.println();
			System.out.println("Sorted elements");
			
			
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.printf("%10s %20s %20s  %20s","Roll No","Name","Total","Percentage");
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			for(int i=0;i<arr.length;i++)
			{
				StudentPojo a1=(StudentPojo)arr[i];
				
				System.out.format("%12s %22s %22s  %22s",a1.getRno(),a1.getName(),a1.getTotal(),a1.getPercent());
				
				System.out.println();
				   System.out.println("--------------------------------------------------------------------------------------------------------");
				
			}
		}
		
		
	

}
