// import Scanner and exception class
import java.util.InputMismatchException;
import java.util.Scanner;
//create abstract class and variables 
public abstract class Person {
	protected String firstName;
	protected String lastName;
	protected String email;
	protected long phoneNumber;
// no-arg constructor
	public Person() {

	}
//paramaterized constructor
	public Person(String firstName, String lastName, String email, long phoneNumber) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
//method that reads person info
	public void readInfo(Scanner input) {
		//prompt user for info
		System.out.print("Enter First Name: ");
		firstName = input.nextLine();
		System.out.print("Enter Last Name: ");
		lastName = input.nextLine();
		System.out.print("Enter email: ");
		email = input.nextLine();
		//run exception handling to catch any invlid input
		while (true) {
			System.out.print("Enter Phone Number: ");

			try {
				phoneNumber = input.nextLong();
				break;
			} catch (InputMismatchException e) {
				input.nextLine();
				System.err.println("Invalid Phone Number");

			}
		}
	}
//abstract method that prints information
	public abstract void printInfo();
	
	public void readFromFile(Scanner input) {
		firstName = input.next();
		lastName = input.next();
		email = input.next();
		phoneNumber = input.nextLong();
	}
}

