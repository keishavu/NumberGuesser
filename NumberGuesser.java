package projects;
import java.util.*;
public class NumberGuesser {

	public static void main(String[] args) {
Scanner input = new Scanner(System.in);
// prompt user 
System.out.println("Hello! Welcome to the Number Guesser Game! ");
System.out.print("Would you like to guess the number I'm thinking of? ");
String yn;
// input
yn = input.nextLine();
// if user says yes 
if (yn.compareToIgnoreCase("yes")==0) {
	System.out.println("Let's begin!");
	// user picks range
	System.out.println("Pick a range I should pick the number from: ");
	int bound1, bound2;
	System.out.print("Bound 1: ");
	bound1 = input.nextInt();
	System.out.print("Bound 2: ");
	bound2 = input.nextInt();
	// ensures appropriate bounds 
	while (bound1 >= bound2){
		System.out.println("Invalid bounds. Be sure Bound 2 is greater than Bound 1 and that they are not equal. ");
		System.out.print("Enter new value for bound 1: ");
		bound1 = input.nextInt();
		System.out.print("Enter new value for bound 2: ");
		bound2 = input.nextInt();
	}
	// generates random number 
	int random;
	random = (int)(Math.random()*(bound2-bound1+1)+bound1);
	System.out.println("I've picked a number from "+bound1 + " to "+bound2+"!");
	System.out.print("What's your guess at what the number is? ");
	String input1;
	// while loop, breaks when user says stop and user guesses, accounts for non integer inputs 
	while (true) {
		input1 = input.nextLine();
		if (input1.equalsIgnoreCase("stop")) {
			System.out.println("The number was "+random);
			break; 
		}
		
		try {
			int guess= Integer.parseInt(input1);
			if (guess < bound1 || guess >bound2) {
			System.out.print("Your guess is out of bounds. Try again! ");
		}
			else if (guess < random || guess > random) {
				System.out.print("Not quite. Try again!");
			}
			else {
				System.out.println("You guessed the number I was thinking of correctly! The number was "+random+".");
				break;
			}
		}catch(NumberFormatException e) {
		System.out.println("Enter a number or type 'stop' to quit.");
		}
	}
}
else System.out.println("Maybe we can play another time! See you soon :)");
System.out.println("Thanks for playing :)");
	}

}
