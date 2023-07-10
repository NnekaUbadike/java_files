package labs6topresent;
import java.util.Arrays;
import java.util.Random;
public class Random_array_w_constructor {
	

	
	
	
	        //main method updated.
	        public static void main(String[] args) {
	    	System.out.println(-12 % 3);
	        RandomArray rand = new RandomArray(3, new double[] {20, 5, 1});
	        rand.set(0, 1); rand.set(1, 2); rand.set(2, 3);
	        for(int i = 0; i < 25; i++) {
	            System.out.println("accessing: " + rand.get(0));
	        }
	        System.out.println(rand);
	        UniformRandomArray uni = new UniformRandomArray(3);
	        uni.set(0, 1); uni.set(1, 2); uni.set(2, 3);
	        for(int i = 0; i < 25; i++) {
	            System.out.println("accessing: " + uni.get(0));
	        }
	        System.out.println(uni);
	        InBoundsArray iba = new InBoundsArray(3);
	        iba.set(0, 1); iba.set(1, 2); iba.set(2, 3);
	        for(int i = 0; i < 25; i++) {
	            System.out.print("accessing: " + (i-12));
	            System.out.println(" --> " + iba.get(i-12));
	            int value = (i + 70) % 23;
	            System.out.println("setting: " + i + " to " + value + " ");
	            iba.set(i, value);
	        }
	        System.out.println(iba);
	        System.out.println("DONE!");
	    }
	}

	class BasicArray {
	    private int[] myArray;

	    public BasicArray(int length) {
	        myArray = new int[length]; //
	    }

	    public void set(int index, int value) {
	        myArray[index] = value;
	    }

	    public int get(int index) {
	        return myArray[index];
	    }

	    public int length() {
	        return myArray.length;
	    }

	    public String toString() {
	        return Arrays.toString(myArray);
	    }
	}

	class RandomArray extends BasicArray {

	    private double[] myOdds;

	    public RandomArray(int length, double[] odds) {
	        super(length);  //need this it calls the superclass' constructor to set the variable in the superclass.
	                        //it ***MUST*** be the first line of code in the constructor.
	        double sum = 0;
	        for(double d : odds) sum += d;
	        for(int i = 0; i < odds.length; i++) {
	            odds[i] /= sum;
	        }
	        if(odds.length != length) throw new IllegalArgumentException("lengths differ.");
	        myOdds = odds;
	    }

	    //updated.
	    @Override
	    public int get(int index) {
	        double randIndex = Math.random();
	        index = 0;
	        double sum = 0;
	        while(randIndex > sum) {
	            sum += myOdds[index];
	            index++;
	        }
	        if(index == length()) index -= 1;
	        return super.get(index);  //don't need to randomize again, call the superclass' get!
	                //this can appear anywhere in the method.
	        
	    }
	}

	//1. start here, Extend the BasicArray class by adding the extends clause just 
	//before the curly brace on the following line.
	
	class UniformRandomArray extends BasicArray {
	    public UniformRandomArray(int length) {
	    	super(length);
	    	
	    }

	    public int get(int index) {
	        //generate a random index that is equally likely to be any valid index.
	        //return the value at that index using the superclass' get method.
	    	Random rand= new Random();
	    	index= rand.nextInt(super.length());//newArray[index]= rand.nextInt();
	    	return super.get(index);
	    	
	    }


	    public void set(int index, int value) {
	        //generate a random index that is equally likely to be any valid index.
	        //set the thing at the random index to value.
	    	Random rand = new Random();
	    	index = rand.nextInt(super.length());//newArray[index] 
	    	super.set(index, value);
	    	
	    }

	    public String toString() {
	    	//return what the parent's (AKA superclass') toString does, b
	    	return "*"+ super.toString();
	    }
	}

	class InBoundsArray extends BasicArray {
	    public InBoundsArray(int length) {
	        super(length);
	    }

	    public int get(int index) {
	    	index = Math.abs(index % super.length());
	        return super.get(index);
	    }

	    public void set (int index, int value) {
	    	index= Math.abs(index % super.length());
	    	
	    	super.set(index,value);
	    }

	    public int length() {
	        //return the biggest integer possible. 
	    	
	    	return Integer.MAX_VALUE;
	    }

	    public String toString() {
	        //return the length and the contents of the array with a "+" at the beginning.
	    	
	    	return "+" +length() + ";" + super.toString();
	    }
	    
	}


