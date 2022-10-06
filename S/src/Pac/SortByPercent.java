package Pac;

import java.util.Comparator;

public class SortByPercent implements Comparator<StudentPojo>
{

	@Override
	public int compare(StudentPojo o1, StudentPojo o2) 
	{
		//return o2.getTotal()-o2.getTotal();
		return (int) (o2.getPercent()-o1.getPercent());
	}

}
