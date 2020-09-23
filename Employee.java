package employeeWageComputation;
import java.util.Scanner;

class Employee {
	public static void main(String[] args){
		dailyWage();
	}

public static void dailyWage(){
	 Scanner sc = new Scanner(System.in);
	 System.out.print("Enter the Wage per Hour : ");
	 int wagePerHr = sc.nextInt();
	 System.out.print("Enter Full Day Hour : ");
	 int fullDayHr=sc.nextInt();
	 System.out.print("Enter Half Day Hour : ");
	 int halfDayHr=sc.nextInt();
	 System.out.print("Enter the days in a month : ");
	 int day=sc.nextInt();
	 System.out.print("Enter the working hour in a month : ");
	 int workingHr=sc.nextInt();
	 calculateWage(wagePerHr,fullDayHr,halfDayHr,day , workingHr);
}	


public static void calculateWage(int wagePerHr,int fullDayHr,int halfDayHr,int day, int workingHr){
	int Wage=0;
	int workHrs=0;
	for (int i=1;i<=day && workHrs<=workingHr;i++){
			
			int random=(int)Math.floor(Math.random()*10)%3;
			switch(random){
			case 1:
					Wage = totalWage(wagePerHr,fullDayHr) + Wage;
					workHrs=workHrs+fullDayHr;
					break;
			case 2:
				Wage=totalWage(wagePerHr,halfDayHr)+ Wage;
				workHrs=workHrs+halfDayHr;
				break;
				default:
				}
			System.out.println("Wage : " + Wage + "  Working Hr : " + workHrs + "  Days : " + i );
		}
		
	}

public static int totalWage(int wagePerHr,int dayHr ){
	 int dailyWage = wagePerHr*dayHr;
	 return dailyWage;
	}
}
