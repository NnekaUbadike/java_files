package lab2;
import java.util.Scanner;


		
		public class Lab2withmethods{
			public static void main(String[] args) {
				Scanner source = new Scanner(System.in);
				String choice = "options";
				while(! choice.equals("exit")) {
					if(choice.equals("options")) {
						printOptions();
					} else if(choice.equals("factor")) {
						System.out.println("Enter an integer:");
						int denominator = source.nextInt();
						source.nextLine();
						factor(denominator);
					} else if(choice.equals("average")) {
						System.out.println("Enter an integer:");
						int n = source.nextInt();
						source.nextLine();
						System.out.println(average(n));
					} else {
						System.out.println(choice + " is an invalid option.");
					}
					choice = source.nextLine();
				}
			}
			
			public static void printOptions() {
				System.out.println("Options: ");
				System.out.println("\t: average");
				System.out.println("\t: factor");
				System.out.println("\t: options");
				System.out.println("\t: exit");
			}
			
			public static void factor(int denominator) {
				int potentialFactor = 2;
				while(potentialFactor <= denominator) {
					while((denominator % potentialFactor) == 0) {
						System.out.print(potentialFactor + " ");
						denominator = denominator / potentialFactor;
					}
					potentialFactor++;
				}
				System.out.println();
			}
			
			public static double average(int n) {
				int sum = 1 + n;
				double average = sum / 2.0;
				return average;
			}
		

	}







