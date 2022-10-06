package Pac;

import java.util.Comparator;

public class SortByRollno implements Comparator<StudentPojo>
{

	@Override
	public int compare(StudentPojo o1, StudentPojo o2)
	{
		return o2.getRno()-o1.getRno();
	}

}
