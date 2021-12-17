//import scanner and exception class
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contractor extends Employee {
	//initialize variables
	protected double hourlyRate;
	protected double numHours;
//print contractor info
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("%12s|\n", hourlyRate * numHours);
	}
//read contractor info
	@Override
	public void readInfo(Scanner input) {
		super.readInfo(input);
		//catch any invalid input
		while (true) {
			System.out.print("Enter Hourly Rate: ");

			try {
				hourlyRate = input.nextDouble();
				break;
			} catch (InputMismatchException e) {
				input.nextLine();
				System.err.println("Invalid Entry");

			}
		}
		while (true) {
			System.out.print("Enter Number Hours: ");

			try {
				numHours = input.nextDouble();
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
		hourlyRate = input.nextDouble();
		numHours = input.nextDouble();
		
	}
// no arg constructor 
	public Contractor() {

	}
// Parameterized constructor
	public Contractor(String firstName, String lastName, String email, long phoneNumber, int employeeNumber,
			double hourlyRate, double numHours) {
		super(firstName, lastName, email, phoneNumber, employeeNumber);
		this.hourlyRate = hourlyRate;
		this.numHours = numHours;
	}

}
