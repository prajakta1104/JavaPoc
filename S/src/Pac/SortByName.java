package Pac;

import java.util.Comparator;

public class SortByName implements Comparator<StudentPojo>
{

	@Override
	public int compare(StudentPojo s1, StudentPojo s2) 
	{
		return s1.name.compareTo(s2.name);
	}

}
