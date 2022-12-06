public class GCD {
	// instance variables - DO NOT ADD ANY MORE INSTANCE VARIABLES
	private int numerator;
	private int denominator;

	// default constructor
	public GCD(){
		numerator = 1;
		denominator = 1;
	}

	// initialization constructor
	public GCD(int num, int denom){
		numerator = num;
		denominator = denom;
	}

	// modifier method for numerator
	public void setNumerator(int num){
		numerator = num;
	}

	// modifier method for denominator
	public void setDenominator(int denom){
		denominator = denom;
	}

	// accessor method for numerator
	public int getNumerator(){
		return numerator;
	}

	// accessor method for denominator
	public int getDenominator(){
		return denominator;
	}

	// method to determine gcd called calcGCD
	public int calcGCD() {
		int i;
		if (numerator <= denominator) {
			i = numerator;
		} else {
			i = denominator;
		}

		int gcd = 1; //will always exist
		while (i > 1) {
			if (numerator % i == 0 && denominator % i == 0) {
				gcd = i;
				i = 0; // basically a break statement
			} else {
				i--;
			}
		}

		return gcd;
	}

	// method to determine lowest term of numerator called numeratorSimplified
	public int numeratorSimplified(){
		return numerator/calcGCD();
	}

	// method to determine lowest term of denominator called denominatorSimplified
	public int denominatorSimplified(){
		return denominator/calcGCD();
	}

	// toString() method that only returns the GCD
	public String toString(){
		return "" + calcGCD();
	}
}