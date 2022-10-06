package Pac;

import java.util.*;


public class StudentERPSystem 
{

	static Scanner sc = new Scanner(System.in);
	StudentERPSystem s2;
	
	//Arraylist to store student 
	ArrayList<StudentPojo> al;
	
	public static void main(String[] args) 
	{
		StudentERPSystem s2= new StudentERPSystem();
		s2.menu();
		ArrayList<Integer> ary= new ArrayList<>();
		
	}
	
	//This method is used to create student account	
	ArrayList<StudentPojo> Create_Student_Account()
		{
			ArrayList<Integer> Student_marks;
			StudentPojo studentPojo= new StudentPojo();
			ArrayList<StudentPojo> al = new ArrayList<>();
			int marks_total=0;  //To store student total marks
			float percentage;  // To store Student Percentage
			int rollNumber;   //To store Student RollNo
			String status;   //To store Student Status
			String name;    //To store Student Name
			
			
			//Accepts the student data
			System.out.println("Enter data for student ");
			for(int i=0;i<2;i++)
			{
				
				Student_marks= new ArrayList<>();
				
				System.out.println("Enter roll no:");
				rollNumber=sc.nextInt();
			
				System.out.println("Enter name:");
				name=sc.next();
				
				System.out.println("Enter marks");
				for(int j=0;j<3;j++)
				{
					int m=sc.nextInt();
					Student_marks.add(m);
					
					marks_total=marks_total+m;
					
				}
				percentage=marks_total/3;
				
				 status="pass";
				
					
				studentPojo.setRno(rollNumber);
				studentPojo.setName(name);
				studentPojo.setMarks(Student_marks);
				studentPojo.setTotal(marks_total);
				studentPojo.setPercent(percentage);
				
				 ArrayList<Integer> ary=Student_marks;
					for(int l=0;l<ary.size();l++)
					{
						int p= ary.get(l);
						if(p<35)
						{
							 status="fail";
						}
					}
				studentPojo.setStatus( status);
				
				al.add(new StudentPojo(rollNumber,name,Student_marks,marks_total,percentage, status));
				
				marks_total=0;
			}
			return al;
		}
		
		void menu()
		{
			int ch;
			boolean flag=true;
			StudentERPSystem s2= new StudentERPSystem();
			ArrayList<StudentPojo> arr = new ArrayList<StudentPojo>();
			
			//Displaying main menuto perform Operations
			do
			{
				System.out.println("Menu");
				System.out.println("1. Create");
				System.out.println("2. Update");
				System.out.println("3. Delete");
				System.out.println("4. Display");
				System.out.println("5. Exit");
				System.out.println("Enter Your Choice");
				ch=sc.nextInt();
				
				switch(ch)
				{
				case 1: arr=Create_Student_Account();
					break;
				case 2: System.out.println("Enter Roll Number to update Marks");
						int r=sc.nextInt();
						s2.update_RollNumber(r,arr);
					break;
				case 3: System.out.println("Enter Roll Number to Delete Student");
				        r=sc.nextInt();
				       ArrayList<StudentPojo>temp= arr;
				        s2.delete_student(r,temp);
					break;
				case 4: s2.display_StudentList(arr);
					break;
				case 5:flag=false;
					break;
					default:
				}
			}
			while(flag);
		}
		
		
		//Method to convert List into Set
		static <T> Set<T> ConvertListToSet(List<T>al)
		{
			
			Set <T> obj=new HashSet<>();
			for(T t:al)
			{
				obj.add(t);
				
			}
			return obj;

		}
		
		//Menu to display Student List
		void display_StudentList(ArrayList<StudentPojo> arraylist)
		{
			boolean flag=true;
			int ch;
			Set<StudentPojo> set1= new HashSet<>();
			StudentERPSystem s2= new StudentERPSystem();
			
			//storing converted(from List to Set) values
			set1=ConvertListToSet(arraylist);
			
			
			do
			{
				
				System.out.println("Menu");
				System.out.println("1.Display  Entered Student Data");
				System.out.println("2.Display  Student Information");
				System.out.println("3. Sort Student Informatio By Roll no.");
				System.out.println("4. Sort Student Information By Name ");
				System.out.println("5. Sort Student Information By Percentage");
				System.out.println("6. Exit");
				System.out.println("Enter your choice");
				ch=sc.nextInt();
				
				switch(ch)
				{
				case 1: s2.display_Arraylist(arraylist);
					break;
				case 2: 
				 		Object set[]=set1.toArray();
				 		//calling Display method
				 		s2.display_set(set);
					break;
				case 3:	Set <StudentPojo> sort3= new TreeSet<StudentPojo>(new SortByRollno());
						//Adding all the elements in set
						sort3.addAll(set1);
						//converting Set to Array
						Object set4[]=sort3.toArray();
						//calling method to display  elements sorted by Rollno
						s2.display_sortByRollno(set4);
					break;
				case 4:	Set <StudentPojo> sort1= new TreeSet<StudentPojo>(new SortByName());
						//Adding all the elements in set
				        sort1.addAll(set1);
				        //converting Set to Array
						Object set2[]=sort1.toArray();
						//calling method to display  elements sorted by Name
						s2.display_sorted(set2);
						
					break;
				case 5:	Set <StudentPojo> sort2= new TreeSet<StudentPojo>(new SortByPercent());
						//Adding all the elements in set	
						sort2.addAll(set1);
						 //converting Set to Array
						Object set3[]=sort2.toArray();
						//calling method to display  elements sorted by Percentage
						s2.display_sortedByPercent(set3);
					break;
				case 6: flag=false;
					break;
					default:
				}
				
			}
			while(flag);
		}
		
		
		//Method to display non duplicate Elements
		
		void display_set(Object arr[])
		{
			System.out.println();
			System.out.println("Non duplicate elements");
			
			//Displaying in tabular format
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.printf("|%10s| %20s| %20s | %20s|","Roll No","Name","Total","Percentage");
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			
			for(int i=0;i<arr.length;i++)
			{
				StudentPojo a1= (StudentPojo) arr[i];
				
				System.out.format("|%12s| %22s| %22s|  %22s|",a1.getRno(),a1.getName(),a1.getTotal(),a1.getPercent());
				
				System.out.println();
				   System.out.println("--------------------------------------------------------------------------------------------------------");
			}
			
			
		}
		
		
		//Method to sort the Elements
		void display_sorted(Object arr[])
		{
			System.out.println();
			System.out.println("Sorted elements");
			
			//Displaying in tabular format
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.printf("|%10s| %20s| %20s | %20s|","Roll No","Name","Total","Percentage");
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			for(int i=0;i<arr.length;i++)
			{
				StudentPojo a1=(StudentPojo)arr[i];
				
				System.out.format("|%12s| %22s| %22s | %22s|",a1.getRno(),a1.getName(),a1.getTotal(),a1.getPercent());
				
				System.out.println();
				   System.out.println("--------------------------------------------------------------------------------------------------------");
				
			}
			
			
		}
		
		
		//Method to Sort the students By Percentage
		void display_sortedByPercent(Object arr[])
		{
			
			System.out.println();
			System.out.println("Sorted elements");
			
			//Displaying in tabular format
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.printf("|%10s| %20s| %20s| %20s|","Roll No","Name","Total","Percentage");
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			for(int i=0;i<arr.length;i++)
			{
				StudentPojo a1=(StudentPojo)arr[i];
				
				System.out.format("|%12s| %22s| %22s | %22s|",a1.getRno(),a1.getName(),a1.getTotal(),a1.getPercent());
				
				System.out.println();
				   System.out.println("--------------------------------------------------------------------------------------------------------");
				
			}
		}
		
		//Method to Sort the students By RollNo
		void display_sortByRollno(Object arr[])
		{
			System.out.println();
			System.out.println("Sorted elements");
			
			
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.printf("|%10s| %20s| %20s| %20s|","Roll No","Name","Total","Percentage");
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			for(int i=0;i<arr.length;i++)
			{
				StudentPojo a1=(StudentPojo)arr[i];
				
				System.out.format("|%12s| %22s| %22s|  %22s|",a1.getRno(),a1.getName(),a1.getTotal(),a1.getPercent());
				
				System.out.println();
				   System.out.println("--------------------------------------------------------------------------------------------------------");
				
			}
		}
		
		//Method to calculate total marks
		int calculate_total(ArrayList<Integer> arraylist)
		{
			int total=0;
			
			for(int i=0;i<arraylist.size();i++)
			{
				total=total+arraylist.get(i);
			}
			
			return total;

		}
		

		//Method to Delete the Student Account
		void delete_student(int  rno, ArrayList<StudentPojo>arraylist)
		{
			for(StudentPojo stud :arraylist)
			{
				if(stud.getRno()==rno)
				{
					//Displaying the student Informtion before Deleteing
					System.out.println("Roll number :"+stud.getRno());
					System.out.println("Name :"+stud.getName());
					System.out.println("Marks :"+stud.getMarks());
					System.out.println("Total :"+stud.getTotal());
					System.out.println("Percentage :"+stud.getPercent());
				
					StudentPojo temp= stud;
					arraylist.remove(temp);
				}
				
			}
			//Calling display method after deleting account
			display_Arraylist(arraylist);
		}
		
		
		//To Display the students
		void display_Arraylist(ArrayList<StudentPojo>arraylist)
		{
			//Displaying in tabular format
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.printf("|%5s| %15s| %10s|%10s|%10s|%10s| %10s|%10s|" ,"Roll No","Name","Marks 1","Marks 2","Marks 3","Total","Percent","Status");
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			for(StudentPojo stud :arraylist)
			{
				ArrayList<Integer> ary=stud.getMarks();
					System.out.format("|%5s| %15s|",stud.getRno(),stud.getName());
					
					StudentPojo a=stud;
					for(int j=0;j<ary.size();j++)
					{
						int p=ary.get(j);
						System.out.format("|%10s|",p);
					}
					System.out.format("%10s| %10s|%10s|",stud.getTotal(),stud.getPercent(), stud.getStatus());
					
					System.out.println();
					   System.out.println("--------------------------------------------------------------------------------------------------------");
				
			}
		}
		
		
		//Method to update Students marks
		void update_RollNumber(int  rno, ArrayList<StudentPojo>arraylist)
		{
			int ch,m,new_marks;
		
			for(int i=0;i<arraylist.size();i++ )
			{
				if(arraylist.get(i).getRno()==rno)
				{
					System.out.println("Roll number :"+arraylist.get(i).getRno());
					System.out.println("Name :"+arraylist.get(i).getName());
					System.out.println("Marks :"+arraylist.get(i).getMarks());
					System.out.println("Total :"+arraylist.get(i).getTotal());
					System.out.println("Percentage :"+arraylist.get(i).getPercent());
					boolean flag=true;
					String s="pass";
					ArrayList<Integer> ary;
					do 
					{
						//Menu to update students marks
						System.out.println("***********************************");
						System.out.println("Enter Choice To Update Marks");
						System.out.println("1. Marks 1");
						System.out.println("2. Marks 2");
						System.out.println("3. Marks 3");
						System.out.println("4. Exit");

						
						System.out.println("Enter your choice");
						ch=sc.nextInt();
						
						switch(ch)
						{
						case 1: 
								m=0;
								System.out.println("Enter New Marks To update");
								new_marks=sc.nextInt();
								
								arraylist.get(i).getMarks().set(m,new_marks);
								
								int t=calculate_total(arraylist.get(i).getMarks());
								
								
								System.out.println("Roll number :"+arraylist.get(i).getRno());
								System.out.println("Name :"+arraylist.get(i).getName());
								System.out.println("Marks :"+arraylist.get(i).getMarks());
								System.out.println("Total :"+t);
								float per=t/3;
								ary=arraylist.get(i).getMarks();
								for(int l=0;l<ary.size();l++)
								{
									int p= ary.get(l);
									if(p<35)
									{
										 s="fail";
									}
								}
								
								
								arraylist.set(i,(new StudentPojo(rno,arraylist.get(i).getName(),arraylist.get(i).getMarks(),t,per,s)));
								System.out.println("Percentage :"+per);
								display_Arraylist(arraylist);

								break;
						case 2:
								m=1;
								System.out.println("Enter New Marks To update");
								new_marks=sc.nextInt();
								arraylist.get(i).getMarks().set(m,new_marks);
								
								 t=calculate_total(arraylist.get(i).getMarks());
								
								 StudentPojo temp1= arraylist.get(i);
								 temp1.setTotal(t);
								 
								 
								System.out.println("Roll number :"+arraylist.get(i).getRno());
								System.out.println("Name :"+arraylist.get(i).getName());
								System.out.println("Marks :"+arraylist.get(i).getMarks());
								System.out.println("Total :"+t);
								 per=t/3;
								 ary=arraylist.get(i).getMarks();
									for(int l=0;l<ary.size();l++)
									{
										int p= ary.get(l);
										if(p<35)
										{
											 s="fail";
										}
									}
									
									
									arraylist.set(i,(new StudentPojo(rno,arraylist.get(i).getName(),arraylist.get(i).getMarks(),t,per,s)));
								System.out.println("Percentage :"+per);
								display_Arraylist(arraylist);

								break;
						case 3:
								m=2;
								System.out.println("Enter New Marks To update");
								new_marks=sc.nextInt();
								arraylist.get(i).getMarks().set(m,new_marks);
								t=calculate_total(arraylist.get(i).getMarks());
		 						
								System.out.println("Roll number :"+arraylist.get(i).getRno());
								System.out.println("Name :"+arraylist.get(i).getName());
								System.out.println("Marks :"+arraylist.get(i).getMarks());
								System.out.println("Total :"+t);
								per=t/3;
								ary=arraylist.get(i).getMarks();
								for(int l=0;l<ary.size();l++)
								{
									int p= ary.get(l);
									if(p<35)
									{
										 s="fail";
									}
								}
								
								
								arraylist.set(i,(new StudentPojo(rno,arraylist.get(i).getName(),arraylist.get(i).getMarks(),t,per,s)));
								System.out.println("Percentage :"+per);
								display_Arraylist(arraylist);
								break;
						case 4: flag=false;
							
						break;
						default: System.out.println("No such Subject");
						}
						
						
						
					}
					while(flag);
					
					
					
				}
			}
			
			
		}
	

}
