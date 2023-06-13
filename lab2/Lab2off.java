package lab2;
import java.util.Scanner;

public class Lab2off {
	public static void main(String[] args) {
		Scanner source = new Scanner(System.in);


		double minimum = Double.MAX_VALUE;
		double maximum= 0; 
		while (true) {

			System.out.println("enter a number");
			double number = source.nextDouble();


			if (minimum < number) {
				minimum = minimum;
			}
			else /*(minimum>number)*/{
				minimum=number;
			}

			if (maximum > number) {
				maximum = maximum;
				}
			else {
				maximum= number;
			}
			System.out.println("the biggest number entered so far is " + maximum);

			System.out.println("the smallest number entered so far is " + minimum);










		}
	}

}
