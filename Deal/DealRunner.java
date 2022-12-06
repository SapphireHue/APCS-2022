//import Scanner
import java.util.Scanner;


public class DealRunner
{
	public static void main(String[] args)
	{
		// instantiate Scanner object
		Scanner scan = new Scanner(System.in);
		
		// prompt the user for the number of simulations to run
		System.out.println("How many simulations do you want to run?");
		
		// assign input to variable
		int numGames = scan.nextInt();
		
		// declare variables to store prize location, contestant's guess,
		// door revealed, the contestant's new guess, win counts for 
		// changing and NOT changing.
		int prize, guess, reveal, newGuess;
		int switchCount = 0;
		int stayCount = 0;
		
		int bad = 0;
		// loop through the number of game simulations
		for (int i=0; i < numGames; i++){
			// instantiate a Deal object inside the loop
			Deal deal = new Deal();
			
			// get the contestant's guess and assign to a variable 
			guess = deal.getUserGuess();
			
			// get the prize location and assign to a variable
			prize = deal.getPrizeLoc();
			
			// get the door which is revealed and assign to a variable
			reveal = deal.getView();
			
			// get the contestant's new guess and assign to a variable
			newGuess = deal.getNewGuess(reveal);
			
			// determine if the new guess matches the prize location
			if (newGuess==prize){
				switchCount++;
			}
			// update the win count by changing doors and win count by NOT switching doors
			else{
				stayCount++;
			}
								
			// print out the results of each simulation
			//System.out.println(deal);
			System.out.println("user guess: " + guess + " prizeLoc: " + prize + " reveal:" + reveal+ " new guess:"+ newGuess);
			if (prize==reveal){bad++;}
		}
		
		// print out the probability of winning/not winning by switching
		System.out.println("Probability of winning if you switch = " + switchCount);
		System.out.println("Probability of winning if you do not switch = " + stayCount);
		System.out.println(bad);
	}
}