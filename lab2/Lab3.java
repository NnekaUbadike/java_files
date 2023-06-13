package lab2;
import java.util.Scanner;

public class Lab3 {
	public static void main (String[]args) {
		System.out.println("\t options:");
		System.out.println("\t sum:");
		System.out.println("\t exit:");
		Scanner source= new Scanner(System.in);
		System.out.println("enter in one of the choices");
		String userIn= source.nextLine();
		while (!userIn.equals ("exit")){
			if (userIn.equals("options")) {
				OptionsMethod();
			}
			else if(userIn.equals("sum")){
				float total=0;
				while (true) {
				System.out.println("enter a number");
				double number= source.nextDouble();
				total += number;
				System.out.println("the sum of numbers entered is " + total);
				}
			}
			else {
				System.out.println(userIn + " is an invalid option");
			}
			
			userIn=source.nextLine();
		}
	}  
	public static void OptionsMethod() {
		System.out.println("\t options:");
		System.out.println("\t sum:");
		System.out.println("\t exit:");
	}

}

	


