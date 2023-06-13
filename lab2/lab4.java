package lab2;
import java.util.Arrays;
import java.util.Random;

public class lab4 {
	public static void main (String[]args) {
		int smallest = 1;
		int largest = 100;
		Random generator = new Random();


		int [] newArray= new int [10];
		float sum=0;
		float avg =0;


		for (int index= 0 ; index< newArray.length; index++) {
			int number = generator.nextInt((largest + 1- smallest)) + smallest;
			//System.out.println(number);
			newArray[index]= number;
			sum+= number;
			avg= sum/newArray.length;	
		}
		System.out.println("The original array:");
		System.out.println(Arrays.toString( newArray));
		System.out.println("Sum: " + sum);
		System.out.printf("Average: %.1f", avg);
		System.out.println(" ");

		int min= newArray[0];
		int max = newArray[0];

		for (int num:newArray) {
			min= Math.min(min, num);
			max=Math.max(max, num);	
		}
		
		System.out.println("Smallest: " + min);
		System.out.println("Largest: " + max);
	}
}