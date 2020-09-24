package employeeWageComputation;
import java.util.*;


interface IEmployee{
	public void EmpWageBuilder(String compName,int wagePerHr,int fullDayHr,int halfDayHr,int day , int workingHr);
	public void calculateWage();
}


public class Employee implements IEmployee {
	
	int count=0 ; // instance variable
	String companyName;
	ArrayList<CompEmpWage> arrayList= new ArrayList<CompEmpWage>();
	
	ArrayList<Integer> dailyWageArrayList ;
	
	static Employee obj = new Employee();
	
	// input  number of companies and details
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of Companies : ");
		int numOfComp=sc.nextInt();
		
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
	    	obj.EmpWageBuilder(compName,wagePerHr,fullDayHr,halfDayHr,day ,workingHr);
	    }	
	    obj.calculateWage();
}
		
// Employee Wage Builder
public void EmpWageBuilder(String compName,int wagePerHr,int fullDayHr,int halfDayHr,int day , int workingHr){
		arrayList.add( new CompEmpWage(compName,wagePerHr,fullDayHr,halfDayHr,day , workingHr));
}
	
public void calculateWage(){
		for(CompEmpWage detail: arrayList){
			detail.setTotalWage(calculateWage(detail));
            detail.print();
            System.out.println(" Daily Wage :  " + dailyWageArrayList);
		}
}	

//calculate total wage for each company
public  int calculateWage(CompEmpWage companyDetail){
	int workHrs=0 ,totalWage=0, zeroDayHr=0;
	dailyWageArrayList = new ArrayList<Integer>();
	for (int i=1;i<=companyDetail.day && workHrs<=companyDetail.workingHr;i++){
			switch(getrandom()){
			case 1:
			totalWage = gettotalWage(companyDetail.wagePerHr, companyDetail.fullDayHr ,totalWage); 
			workHrs=getWorkingHrs(companyDetail.fullDayHr,workHrs);
			break;
			case 2:
			totalWage=gettotalWage(companyDetail.wagePerHr, companyDetail.halfDayHr ,totalWage);
			workHrs=getWorkingHrs(companyDetail.halfDayHr,workHrs);
			break;
			default:
				totalWage=gettotalWage(companyDetail.wagePerHr, zeroDayHr ,totalWage);
				workHrs=getWorkingHrs(zeroDayHr,workHrs);
			}	
	}
	return totalWage;
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
public  int gettotalWage(int wagePerHr,int dayHr,int totalWage ){
	 int dailyWage = wagePerHr*dayHr;
	 dailyWageArrayList.add(dailyWage);
	 totalWage=totalWage+dailyWage;
	 return totalWage;
	}
}

class CompEmpWage {
	int totalWage,wagePerHr,day,workingHr,fullDayHr,halfDayHr;
	String companyName;
	
	public CompEmpWage(String compName,int wagePerHr,int fullDayHr,int halfDayHr,int day , int workingHr){
	this.companyName=compName;
	this.wagePerHr=wagePerHr;
	this.day=day;
	this.workingHr=workingHr;	
	this.fullDayHr=fullDayHr;
	this.halfDayHr=halfDayHr;
	}
	
	public void setTotalWage(int totalWage){
	this.totalWage=totalWage;
	}
	
	
	public void print(){
		System.out.println("Company : " + this.companyName + "   TotalWage : " + this.totalWage);
	}
}


