package employeeWageComputation;

public class Employee {
	static final int PRESENT=1,WAGEPERHR=20;
	public static void main(String[] args)
	{
		int random=(int)Math.floor(Math.random()*10)%2;
		int workingHrs=0,salary;

		if(PRESENT==random)
		{
			System.out.println("Employee Is Present ");
			workingHrs=8;
		}
		else
			System.out.println("Employee Is Absent ");
		salary=WAGEPERHR*workingHrs;

		System.out.println("Employee Wage "+salary);
	}
}
