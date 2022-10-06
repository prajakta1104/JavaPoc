package Pac;

import java.util.ArrayList;
import java.util.Objects;

public class StudentPojo 
{

	String name;
	int rno;
	ArrayList<Integer> marks;
	int total;
	float percent;
	String status;
	
	StudentPojo(int r,String n,ArrayList<Integer> m,int t,float p,String s)
	{
		rno=r;
		name= n;
		marks=m;
		total=t;
		percent=p;
		status=s;
	}
	StudentPojo()
	{
		
	}
	public String getName() {
		return name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getPercent() {
		return percent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	public void setMarks(ArrayList<Integer> student_marks) {
		this.marks = student_marks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public ArrayList<Integer> getMarks() {
		return marks;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(marks, name, rno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentPojo other = (StudentPojo) obj;
		return marks == other.marks && Objects.equals(name, other.name) && rno == other.rno;
	}
	
}
