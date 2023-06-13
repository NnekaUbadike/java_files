package lab2;
import java.util.Arrays;

public class arraysClassExample {
	public static void main(String[] args) {
		arrayCode();
		forLoopCode();
	}
	
	/*
	 * Important facts about arrays:
	 * 1. array variables remember/store references to arrays
	 * 2. arrays cannot change length
	 * 3. <name of array>.length = the number of slots in the array
	 * 4. <name of array>[<index>] this refers to the (<index>+1)th slot
	 * 				in the array.
	 * 5. You can assign/recall <name of array>[<index>].
	 * 6. At first, arrays always are filled with 0's.
	 * Prof. Olsen does not say "zeroth":
	 * The first position in the array is "1st" 
	 * The first index to the array is 0.
	 * 
	 */
	public static void arrayCode() {
		System.out.println("start arrayCode()");
		int[] arrayOfIntegers;  //declaration
		arrayOfIntegers = new int[4]; //initialization/assignment
		arrayOfIntegers = new int[5];
		arrayOfIntegers[0] = 225;
		arrayOfIntegers[1] = 801;
		arrayOfIntegers[2] = 196;
		arrayOfIntegers[3] = 512;
		arrayOfIntegers[4] = -777;
		System.out.println(Arrays.toString(arrayOfIntegers));
		int temp = arrayOfIntegers[1];
		arrayOfIntegers[1] = arrayOfIntegers[3];
		arrayOfIntegers[3] = temp;
		System.out.println(Arrays.toString(arrayOfIntegers));
		int x = 5;
		System.out.println("end   arrayCode()");
	}
	
	public static void forLoopCode() {
		System.out.println("start forLoopCode()");
		int[] arrayOfIntegers;  //declaration
		arrayOfIntegers = new int[5];
		arrayOfIntegers[0] = 225;
		arrayOfIntegers[1] = 801;
		arrayOfIntegers[2] = 196;
		arrayOfIntegers[3] = 512;
		arrayOfIntegers[4] = -777;
		//"looping through an array"
		/*
		 * for(do this before the loop starts; 
		 * 		check before each iteration of the loop; if false, stop repeating;
		 *      do this at the end of each iteration of the loop
		 */
		for(int index = 0; index < arrayOfIntegers.length; index++) {
			System.out.println(arrayOfIntegers[index]);
		}
		System.out.println("...end of first loop...");
		for(int index = 8; index >= 0; index -= 2) {
			System.out.println(arrayOfIntegers[index % 5]);
		}
		System.out.println("...end of second loop..");
		//the code inside the loop is repeated, each time
		//a different number stored in the array gets to be 
		//remembered by the loop variable (in this example 
		//called "value") until every number stored in 
		//the array gets remembered once.
		for(int value : arrayOfIntegers) {
			System.out.println(value);
		}
		System.out.println("end   forLoopCode()");
	}
}

