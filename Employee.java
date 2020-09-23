package employeeWageComputation;

public class Employee {
	static final int HALFDAY=1,FULLDAY=2,WAGEPERHR=20,MONTH=20,MAXWORKINGHRS=100;
	public static void main(String[] args)
	{

		int workingHrs=0,salary,totalSalary=0,totalWorkingHrs=0,day;
		for(day=1;day<=MONTH && totalWorkingHrs<=MAXWORKINGHRS;day++)
		{
			int random=(int)Math.floor(Math.random()*10)%3;

			switch(random)
			{
				case HALFDAY:
								workingHrs=4;
								break;
				case FULLDAY:
								workingHrs=8;
								break;
				default:
								workingHrs=0;
			}

			
			totalWorkingHrs+=workingHrs;
			salary=WAGEPERHR*workingHrs;
			totalSalary+=salary;
		}

		System.out.println("Employee Wage "+totalSalary+" This Month");

	}
}
