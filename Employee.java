package employeeWageComputation;
import java.util.Scanner;

class Employee {
	
	int totalWage,wagePerHr,day,workingHr; // instance variable
	String companyName;
	
	// getting number of companies
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of Companies : ");
		int numOfComp=sc.nextInt();
		Employee[] CompEmpDetail = new Employee[numOfComp];
		
	    for (int i=0;i<numOfComp;i++) {
	    	Scanner sc2=new Scanner(System.in);
	    	System.out.print("Enter the Company Name : ");
	    	String compName = sc2.nextLine();
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
	    	
	    	CompEmpDetail[i]= new Employee(compName,wagePerHr,fullDayHr,halfDayHr,day , workingHr);
	 }
}	

public Employee(String compName,int wagePerHr,int fullDayHr,int halfDayHr,int day , int workingHr){
	this.companyName=compName;
	this.wagePerHr=wagePerHr;
	this.day=day;
	this.workingHr=workingHr;
	this.totalWage=calculateWage(fullDayHr ,halfDayHr);
	this.EmpWageBuilder();	
}
	
//calculate total wage for each company
public  int calculateWage(int fullDayHr , int halfDayHr){
	int workHrs=0 ,totalWage=0;
	for (int i=1;i<=this.day && workHrs<=this.workingHr;i++){
			switch(getrandom()){
			case 1:
					totalWage = gettotalWage(wagePerHr,fullDayHr,totalWage); 
					workHrs=getWorkingHrs(fullDayHr,workHrs);
					break;
			case 2:
					totalWage=gettotalWage(wagePerHr,halfDayHr,totalWage);
					workHrs=getWorkingHrs(halfDayHr,workHrs);
				break;
				default:
				}
		}
	return totalWage;
}

// Employee Wage Builder
public void EmpWageBuilder(){
	System.out.println("Company Name : "+ this.companyName);
	System.out.println("Wage : " +this.totalWage );
	System.out.println("************");
	
}

// return work hours of an employee in a company
public static int getWorkingHrs(int DayHr , int workHrs){
	workHrs=DayHr+workHrs;
	return workHrs;
}
// return random value
public static int getrandom(){
	int random=(int)Math.floor(Math.random()*10)%3;
	return random;
}

// return total wage
public static int gettotalWage(int wagePerHr,int dayHr,int totalWage ){
	 int dailyWage = wagePerHr*dayHr;
	 totalWage=totalWage+dailyWage;
	 return totalWage;
	}
}
