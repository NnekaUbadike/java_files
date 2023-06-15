package labs6topresent;
import java.util.HashMap;
import java.util.Scanner;

public class Lab_8 {
	
	
	
	
	    public static void main(String[] args) {
	        Recipe defaultFavoriteRecipe = new Recipe("Toast", "put it in the toaster and wait");
	        HashMap<Person, Recipe> favoriteRecipes = new HashMap<Person, Recipe>();
	        Scanner scan = new Scanner(System.in);
	        String choice = scan.nextLine();
	        while(! choice.equals("exit")) {
	            if(choice.equals("new")) {
	                Person key = read(scan);
	                Recipe favorite = defaultFavoriteRecipe.copy();
	                favoriteRecipes.put(key, favorite);
	            } else if(choice.equals("cook")) {
	                Person key = read(scan);
	                Recipe r = favoriteRecipes.get(key);
	                 if (r!= null) {
	                	 key.make(r);
	                	 
	                 }
	                 else {
	                	 System.out.println("no recepie associated with that name");
	                 }
	                
	                
	            } else if(choice.equals("favorite")) {
	                Person key = read(scan);
	                Recipe r = favoriteRecipes.get(key);
	                if (r!= null) { 
		                System.out.print("Enter dish name:");
		                String newRecipe= scan.nextLine();
		                
		                System.out.print("Enter recipe directions: ");
		                String newDirections= scan.nextLine();
		                Recipe newRec= new Recipe(newRecipe, newDirections);
		                favoriteRecipes.put(key, newRec);
	                }
	                else {
	                	System.out.println("name does not exist");
	                }
	            }
	                
	             else if(choice.equals("update")) {
	                Person key = read(scan);
	                Recipe r = favoriteRecipes.get(key);
	                if(r != null) {
	                    System.out.println("previously: " + r);
	                    System.out.print("Enter new directions: ");
	                    String newDirections = scan.nextLine();
	                    r.setDirections(newDirections);
	                    System.out.println("now: " + r);
	                } else {
	                    System.out.println("Error: Person not found in database");
	                }
	            } else {
	                System.out.println("Unknown command: " + choice);
	                System.out.println("Please enter new, favorite, cook, update");
	            }
	            choice = scan.nextLine();
	        }
	    }

	    public static Person read(Scanner scan) {
	        System.out.print("Enter first name: ");
	        String firstname = scan.nextLine();
	        System.out.print("Enter last name: ");
	        String lastname = scan.nextLine();
	        return new Person(firstname, lastname);
	    }
	}

	//Immutable object: (can't change using methods)
	class Person {
		String first_name;
		String last_name;
		
	    

	    public Person(String firstname, String lastname) { // constructor 
	    	first_name= firstname;
	    	last_name= lastname;
	    	
	        
	    }

	    public String toString() {
	    	return "<<" + last_name + "; " +first_name + ">>";
	       
	    }

	    public int hashCode() {
	    	return last_name.hashCode() + first_name.hashCode();
	        
	    }

	    public boolean equals(Object o) {
	    	if (o instanceof Person) {
	    		Person newName = (Person)o;
	    		return last_name.equals(newName. last_name) && first_name.equals(newName. first_name);
	    	}
	    	return false;
	        
	    }

	    public void make(Recipe r) {
	    	
	    	Person p = new Person(first_name, last_name);
	    	Recipe q = new Recipe (r.myName,r.myDirections);
	    	System.out.println(p + " made" +" " + q );
	       
	    }
	}

	//Mutable object: can change via methods
	class Recipe {
	    String myName;
	    String myDirections;

	    public Recipe(String name, String directions) {
	        myName = name;
	        myDirections = directions;
	    }

	    //add your code: setDirections method here
	    public void setDirections(String newdirections) {
	    	myDirections= newdirections;
	    	
	    	
	    }


		public Recipe copy() {
	        Recipe copyOfOriginal = new Recipe(myName, myDirections);
	        return copyOfOriginal;
	    }

	    public String toString() {
	        return myName + " by doing \"" + myDirections + "\"";
	    }
	}