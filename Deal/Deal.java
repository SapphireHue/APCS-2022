public class Deal
{
	// instance variables
	private int prizeLoc;   // do NOT add any more instance variables
	private int userGuess;  // do NOT add any more instance variables
	
	// default constructor
	public Deal()
	{
		setPrizeLoc();
		setUserGuess();
	}
	
	// initialization constructor (1st parameter is the prize location, 2nd parameter is the guess)
	public Deal(int a, int b){
		prizeLoc = a;
		userGuess = b;
	}
	
	// modifier method for userGuess (set to return value from rand1to3 method)
	public void setUserGuess(){
		userGuess = rand1to3();
	}
	
	// modifier method for prizeLoc (set to return value from rand1to3 method)
	public void setPrizeLoc(){
		prizeLoc = rand1to3();
	}
	
	// accessor method for userGuess
	public int getUserGuess(){
		return userGuess;
	}
	
	// accessor method for prizeLoc
	public int getPrizeLoc(){
		return prizeLoc;
	}
	
	// method to generate random number between 1 & 3 called rand1to3
	public int rand1to3(){
		return ((int) (Math.random()*3) + 1);
	}
	
	// method to determine the door that will be opened by Monty Hall called getView
	public int getView(){
		int door = 1;
		if (prizeLoc==userGuess){
			do{door = rand1to3();}
			while (door == userGuess);
		}
		else{
			while(door == userGuess || door == prizeLoc){
				door++;
			}
		}
		return door;
	}
	
	// method to to determine contestants new guess called getNewGuess
	public int getNewGuess(int reveal){
		int door = 1;
			while(door == userGuess || door == reveal){
				door++;
			}
		return door;
	}
	
	// toString method (do NOT change)
	public String toString()
	{
		return "user guess: " + userGuess + " prizeLoc: " + prizeLoc;  // do NOT change
	}
	
}