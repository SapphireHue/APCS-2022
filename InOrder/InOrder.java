public class InOrder
{
    // Do not add any more attributes (aka instance variables)
	private int numOne;
	private int numTwo;
	private int numThree;
	
	public InOrder()
	{
		numOne = 0;
		numTwo = 0;
		numThree = 0;
	}
	
	public InOrder(int n1, int n2, int n3)
	{
		numOne = n1;
		numTwo = n2;
		numThree = n3;
	}
	
	public void setNumOne(int n1)
	{
		numOne = n1;
	}
	
	public void setNumTwo(int n2)
	{
		numTwo = n2;
	}
	
	public void setNumThree(int n3)
	{
		numThree = n3;
	}
	
	public int getNumOne()
	{
		return numOne;
	}
	
	public int getNumTwo()
	{
		return numTwo;
	}
	
	public int getNumThree()
	{
		return numThree;
	}
	
	public boolean areTheyInOrder(){
		return (numOne<=numTwo && numTwo<=numThree);
	}
	
	public void sortThem(){
		while (!areTheyInOrder()){
			if (numOne > numTwo){
				int x = numOne;
				numOne = numTwo;
				numTwo = x;
			}
			if (numTwo > numThree){
				int x = numTwo;
				numTwo = numThree;
				numThree = x;
			}
		}
	}
	// numOne = lowest value, numTwo = middle value, numThree = highest value
	
	
	public String toString()
	{
		return "" + numOne + " " + numTwo + " " + numThree;  // DO NOT MODIFY
	}
}