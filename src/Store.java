//import scanner and exception class
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Store {
	// array of employees
	private ArrayList<Employee> employees;

//array takes num of employees
	public Store(int numofEmployees) {
		employees = new ArrayList<Employee>(numofEmployees);
	}

//reads store details
	public void readDetails(Scanner input) {
		int i = nextEmptyIndex();
		int employeeType = 0;
		if(i == -1) {
		
		employees.add(null) ;
		i = nextEmptyIndex();
		}
		// catches error on employee type
		while (!(employeeType == 1 || employeeType == 2)) {
			System.out.println("Enter Employee type:\n1.Regular\n2.Contractor ");
			try {
				employeeType = input.nextInt();

			} catch (InputMismatchException e) {
				input.nextLine();
				System.err.println("Wrong Employee Type ");
			}
			if (!(employeeType == 1 || employeeType == 2)) {
				System.err.println("Wrong Employee Type ");
			}
		}
		if (employeeType == 1) {
			employees.set(i,  new Regular()) ;

		} else {
			employees.set(i,  new Contractor()) ;
		}
		employees.get(i).readInfo(input);
	}

	public void detailsFromFile(Scanner input) {
		while (input.hasNextLine()) {
			int i = nextEmptyIndex();
			if (i== -1) {
			employees.add(null) ;
			i = nextEmptyIndex();
			}
			String employeeType = input.next();
			if (employeeType.equals("r")) {
				
				employees.set(i,  new Regular()) ;
				
			} else if (employeeType.equals("c")) {
				employees.set(i,  new Contractor()) ;
			}
			employees.get(i).readFromFile(input);
		}
	}

	private int nextEmptyIndex() {
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i) == null) {
				return i;

			}
		}
		return -1;
	}

	public boolean emptyArrayCheck() {
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i) != null) {
				return false;
			}
		}
		return true;
	}

//print student details
	public void printEmployeeDetails() {
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i) != null) {

				employees.get(i).printInfo();
			}
		}
	}

//print line
	public static void printLine() {
		System.out.println("================================================================================");
	}

//print title
	public static void printTitle(String name) {
		printLine();
		System.out.println(name + " Store Management System");
		printLine();
		System.out.println("     Emp# |                 Name |           Email |        Phone |     Salary|");
		printLine();
	}

}
