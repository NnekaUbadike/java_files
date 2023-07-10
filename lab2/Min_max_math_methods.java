package lab2;
import java.util.Scanner;

public class Min_max_math_methods {
	public static void main (String[]args) {

	Scanner source = new Scanner(System.in);
	double smaller = Double.MAX_VALUE;
	double bigger = 0;

	while (true) {
		System.out.println("enter a number");
		double number = source.nextDouble();

		 smaller = Math.min(smaller, number);
		 bigger = Math.max(bigger,number);

		
		System.out.printf("smaller is %.1f\n", smaller);
		System.out.printf("bigger is %.1f\n", bigger);
	}

  }
}



