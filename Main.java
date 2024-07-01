
import java.util.ArrayList;

abstract class Employee {
	
	private String name;
	
	private int id;
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public abstract double calculateSalary();
	
	@Override
	public String toString() {
		return "Employee [Name: "+name+" ,Id: "+id+" ,Salary: "+calculateSalary()+"]";
	}

}

class FullTimeEmployee extends Employee {
	private double monthlySalary;
	
	public FullTimeEmployee(String name, int id, double monthlySalary) {
		super(name, id);
		this.monthlySalary = monthlySalary;
	}
	
	@Override
	public double calculateSalary() {
		return monthlySalary;
	}
}

class PartTimeEmployee extends Employee {
	private int hoursworked;
	private double hourlyrate;
	
	public PartTimeEmployee(String name, int id, int hoursworked, double hourlyrate) {
		super(name, id);
		this.hoursworked = hoursworked;
		this.hourlyrate = hourlyrate;
	}
	
	@Override 
	public double calculateSalary() {
		return hoursworked * hourlyrate;
	}
}

class PayroleSystem {
	private ArrayList<Employee> employeeList;
	
	public PayroleSystem() {
		employeeList = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void removeEmployee(int id) {  //we can find which employee to remove using their id's
		Employee employeeToRemove = null;  //variable whose type is employee
		for(Employee employee: employeeList) {
			if(employee.getId() == id) {
				employeeToRemove = employee;
				break;
			}
		}
		
		if(employeeToRemove != null) {
			employeeList.remove(employeeToRemove);
		}
	}
	
	public void displayEmployee() {
		for(Employee employee: employeeList) {
			System.out.println(employee);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		PayroleSystem payrolesystem = new PayroleSystem();
		FullTimeEmployee emp1 = new FullTimeEmployee("vikas", 1, 10000);
		PartTimeEmployee emp2 = new PartTimeEmployee("subham", 2, 12, 100);
		
		payrolesystem.addEmployee(emp1);
		payrolesystem.addEmployee(emp2);
		System.out.println("Initial Employee Details");
		payrolesystem.displayEmployee();
		System.out.println("Removing Employees");
		payrolesystem.removeEmployee(2);
		System.out.println("Remaining Employees");
		payrolesystem.displayEmployee();
		
	}
}
