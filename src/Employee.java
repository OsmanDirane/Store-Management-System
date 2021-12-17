//importing scanner and exception class
import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee extends Person {

	protected int employeeNumber;
// print employee info
	@Override
	public void printInfo() {
		System.out.printf("%10s|%22s|%17s|%14s|", employeeNumber, firstName + " " + lastName, email, phoneNumber);
	}
// read employee info
	@Override
	public void readInfo(Scanner input) {
// catch any invalid error
		while (true) {
			System.out.print("Enter Employee Number: ");

			try {
				employeeNumber = input.nextInt();
				input.nextLine();
				break;
			} catch (InputMismatchException e) {
				input.nextLine();
				System.err.println("Invalid Employee Number");

			}
		}
		super.readInfo(input);
	}
// no arg constructor
	public Employee() {

	}
//Parameterized constructor
	public Employee(String firstName, String lastName, String email, long phoneNumber, int employeeNumber) {
		super(firstName, lastName, email, phoneNumber);
		this.employeeNumber = employeeNumber;
	}
	@Override
	public void readFromFile(Scanner input) {
	
		employeeNumber = input.nextInt();
		super.readFromFile(input);
	}

}
