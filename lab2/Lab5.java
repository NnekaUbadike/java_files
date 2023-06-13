package lab2;
import java.util.Arrays;

import java.util.Random;
import java.util.Scanner;

public class Lab5 {
	public static void main (String[] args) {
		Scanner source = new Scanner(System.in);
		System.out.println ("Enter in one of the 5 options");
		System.out.println("help");
		System.out.println("create");
		System.out.println("expand");
		System.out.println("shuffle");
		System.out.println("exit");
		
		String user_choice= source.nextLine();
		int[] array= new int[0];
		
		while (!user_choice.equals("exit")) {
			if (user_choice.equals("help")) {
				System.out.println("Create, Expand, Shuffle, Exit");

			}
			else if (user_choice.equals("create")) {
				System.out.println("Enter the size of array");
				int size= source.nextInt();
				source.nextLine();
				 array= new int[size];

				for (int num=0 ; num <size; num++) {
					array[num]= num;
				}
				System.out.println(Arrays.toString(array));
				
			}
			
			else if (user_choice.equals("shuffle")){
				shuffle(array);
				
				}
				
			else if(user_choice.equals("expand")) {
			
				array=expand(array);
				
			}
			
			else {
				System.out.println(user_choice+ "is invalid");
			}
			user_choice= source.nextLine();

		}


	}
	
	public static void shuffle ( int [] New_array) {
		Random generator= new Random ();
		for (int num=New_array.length-1; num>= 0; num--) {
			int random_num= generator.nextInt(New_array.length);
			int t= New_array[random_num];
			New_array[random_num]= New_array[num];
			New_array[num]= t;
			
			
		}
		System.out.println(Arrays.toString(New_array));
		
		
		
	}
	public static int[] expand(int[] New_array){
		int [] diff_array= new int [2*New_array.length];

		for (int num =0; num< New_array.length;num++) {
			diff_array [num]= New_array[num];
			
		}
		 New_array=diff_array;
		for (int numb=New_array.length/2; numb<New_array.length; numb++) {
			New_array[numb]=numb;
			
		}
		System.out.println(Arrays.toString(New_array));
		return New_array;
		
		
	}
	

}
