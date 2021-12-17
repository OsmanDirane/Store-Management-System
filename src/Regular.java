//importing exception and scanner class
import java.util.InputMismatchException;
import java.util.Scanner;

public class Regular extends Employee {
// initialize variable
	protected double salary;
// print regular info
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("%12.2f|\n", salary);
	}
// read regular info
	@Override
	public void readInfo(Scanner input) {
		super.readInfo(input);
		// catch any invalid input
		while (true) {
			System.out.print("Enter Annual Salary: ");

			try {
				salary = input.nextDouble() / 12;
				break;
			} catch (InputMismatchException e) {
				input.nextLine();
				System.err.println("Invalid Entry");

			}
		}

	}
	@Override
	
	public void readFromFile(Scanner input) {
		super.readFromFile(input);
	    salary = input.nextDouble() / 12;
		
	}
// no arg constructor
	public Regular() {

	}
// Parameterized constructor
	public Regular(String firstName, String lastName, String email, long phoneNumber, int employeeNumber,
			double salary) {
		super(firstName, lastName, email, phoneNumber, employeeNumber);
		this.salary = salary;
	}

}
