package employeeWageComputation;

public class Employee {
	static final int HALFDAY=1,FULLDAY=2,WAGEPERHR=20;
	public static void main(String[] args)
	{
		int random=(int)Math.floor(Math.random()*10)%3;
		int workingHrs=0,salary;

		switch(random)
		{
			case HALFDAY:
							System.out.println("Employee Is Present For Halfday");
							workingHrs=4;
							break;
			case FULLDAY:
							System.out.println("Employee Is Present For Fullday");
							workingHrs=8;
							break;
			default:
							System.out.println("Employee Is Absent ");
		}

		salary=WAGEPERHR*workingHrs;

		System.out.println("Employee Wage "+salary);

	}
}
