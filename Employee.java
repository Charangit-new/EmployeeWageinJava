package employeeWageComputation;

public class Employee {
	static final int HALFDAY=1,FULLDAY=2,WAGEPERHR=20,MONTH=20;
	public static void main(String[] args)
	{

		int workingHrs=0,salary,totalSalary=0;
		for(int day=1;day<=MONTH;day++)
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

			salary=WAGEPERHR*workingHrs;
			totalSalary+=salary;
		}


		System.out.println("Employee Wage "+totalSalary+" This Month");

	}
}
