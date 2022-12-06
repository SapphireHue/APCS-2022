import java.util.Scanner;

public class CalculatorRunner {
	public static void main(String[] args) {
		double num1;
		double num2;
		char operator;

		// instantiate a Scanner
		Scanner scan = new Scanner(System.in);

		// prompt the user for the operator (how do you read in a character?)
		System.out.println("Enter the operator:");
		// assign the input from the user to operator variable
		operator = scan.next().charAt(0);
		// setup a set of conditions below to determine if the operator is valid
		if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {

			// get the remaining inputs from the user
			System.out.println("Enter the first operand:");
			num1 = scan.nextDouble();
			System.out.println("Enter the next operand:");
			num2 = scan.nextDouble();

			// check for division by zero
			if (num2 != 0 || operator != '/') {
				// instantiate Calculator object with the values entered by the user
				Calculator calc = new Calculator(operator, num1, num2);
				System.out.println("result = " + calc.calcResult());
				// call the toString() method to print the results
				System.out.println(calc);
			} else {
				System.out.println("Cannot Divide by Zero");
			}
		} else {
			System.out.println("Invalid Operator");
		}

	}
}