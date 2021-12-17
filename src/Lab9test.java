// importing exception and scanner
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab9test {

	public static void main(String[] args) {
		// declaring variables
		String name;
		int numemployees;
		Scanner input = new Scanner(System.in);
		// Prompt user for name of store
		System.out.println("Enter Name of Store: ");
		name = input.nextLine();
		// Catch any error using try catch and loop so the user can re-enter correct
		// input

		while (true) {

			System.out.print("How many employees do you have?");

			try {
				numemployees = input.nextInt();

				input.nextLine();

				break;
			} catch (InputMismatchException e) {
				input.nextLine();
				System.err.println("Invalid Entry");

			}

		}
		// create store object
		Store S1 = new Store(numemployees);

		while (true) {
			System.out
					.println("1.Read Employee Details\n2.Read Details From The File\n3.Print Employee Details\n4.Quit");
			int read;
			while (true) {
				System.out.print("Select Option");

				try {
					read = input.nextInt();
					if (read >= 1 && read <= 4) {
						break;
					} else
						System.err.println("Invalid Entry");

				} catch (InputMismatchException e) {
					input.nextLine();
					System.err.println("Invalid Entry");

				}
			}
			if (read == 1) {
				S1.readDetails(input);
			} else if (read == 3) {
				if (S1.emptyArrayCheck()) {
					System.err.println("*** NO ELEMENTS IN THE ARRAY ***");
				} else {
					Store.printTitle(name);
					S1.printEmployeeDetails();
				}
			} else if (read == 2) {
				Scanner Scanner;
				try {
					Scanner = new Scanner(new File("employees.txt"));
					S1.detailsFromFile(Scanner);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else
				{System.out.println("Goodbye...Have a nice day!");break;
				
			}
		}
	}
}




