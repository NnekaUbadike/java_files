package labs6topresent;
import java.util.Scanner;
import java.util.Random;


public class Lab7 {

	public static void main(String[] args) {
		Scanner source = new Scanner (System.in);
		HighStriker object= new HighStriker ();
		System.out.println("Welcome to HighStriker! Enter an option!");
		System.out.println(" Select strike, max, reset, or exit");
		String user_choice= source.nextLine();
		
		while (!user_choice.equals("exit")) {
			if (user_choice.equals("strike")) {
				object.strike();
			}
			else if (user_choice.equals("max")) {

				object.maxStrength();
			}
			else if(user_choice.equals("reset")) {
				object.reset();

			}
			else {
				System.out.println("Invalid Entry");
			}
			System.out.println("enter an option");
			user_choice= source.nextLine();
		}


	}
}
class HighStriker{
	Random rand = new Random();
	int max;

	public void strike() {
		int rand_num= rand.nextInt(10);
		if (rand_num ==9) { 
			System.out.println("Bell Rung!");

		} 
		if (rand_num> max) {
			max= Math.max(max,rand_num);
		}

	}
	public void  maxStrength() {
		System.out.println(max);
	}
	public void reset() {
		max= 0;
	}
}


 