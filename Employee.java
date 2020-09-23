package employeeWageComputation;
import java.util.Scanner;

class Employee {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Companies : ");
		int numOfComp=sc.nextInt();
		Employee(numOfComp);
	}


public static void Employee(int numofComp){
	
	for (int i=1;i<=numofComp;i++){
		
	 Scanner sc = new Scanner(System.in);
	 System.out.println("Enter the Company Name : ");
	 String compName = sc.nextLine();
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
	 calculateWage(compName,wagePerHr,fullDayHr,halfDayHr,day , workingHr);
	 
	}
}	


public static void calculateWage(String compName,int wagePerHr,int fullDayHr,int halfDayHr,int day, int workingHr){
	int Wage=0;
	int workHrs=0;
	int workingDays=0;
	for (int i=1;i<=day && workHrs<=workingHr;i++){
			
			switch(getrandom()){
			case 1:
					Wage = gettotalWage(wagePerHr,fullDayHr,Wage); 
					workHrs=getWorkingHrs(fullDayHr,workHrs);
					break;
			case 2:
					Wage=gettotalWage(wagePerHr,halfDayHr,Wage);
					workHrs=getWorkingHrs(halfDayHr,workHrs);
				break;
				default:
				}
			
			
			workingDays=i;
		}
	System.out.println("Company Name : "+ compName+" Wage : " + Wage + "  Working Hr : " + workHrs + " Working Days : " + workingDays);
		
	}


public static int getWorkingHrs(int DayHr , int workHrs){
	workHrs=DayHr+workHrs;
	return workHrs;
}

public static int getrandom(){
	int random=(int)Math.floor(Math.random()*10)%3;
	return random;
}


public static int gettotalWage(int wagePerHr,int dayHr,int Wage ){
	 int dailyWage = wagePerHr*dayHr;
	 Wage=Wage+dailyWage;
	 return Wage;
	}
}
