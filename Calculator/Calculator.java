public class Calculator {
	// instance variables (don't add any more)
	private double num1;
	private double num2;
	private char operator;

	// default constructor
	public Calculator() {
		num1 = 0;
		num2 = 0;
		operator = 0;
	}

	// initialization constructor
	public Calculator(char op, double n1, double n2) {
		num1 = n1;
		num2 = n2;
		operator = op;
	}

	// modifier method for num1
	public void setNum1(double n1) {
		num1 = n1;
	}

	// modifider method for num2
	public void setNum2(double n2) {
		num2 = n2;
	}

	// modifier method for operator
	public void setOperator(char op){
		operator = op;
		
	}

	// accessor method for num1
	public double getNum1() {
		return num1;
	}

	// accessor method for num2
	public double getNum2() {
		return num2;
	}

	// accessor method for operator
	public char getOperator(){
		return operator;
	}

	// Create method called calcResult to calculate the result
	public double calcResult() {
		double result;
		switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			// default should never run
			default:
				result = 0;
		}
		return result;
	}

	// Create the toString() method
	public String toString(){
		return (num1 + " " + operator + " " + num2 + " = " + calcResult());
	}
}