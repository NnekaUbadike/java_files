package labs6topresent;
import java.util.*;

public class Lab8_class_examp {
	
	
	
		public static void main(String[] args) {
			//warmUpStuff();
			HashMap<String, Dog> database = new HashMap<String, Dog>();
			Scanner scan = new Scanner(System.in);
			System.out.println("Options: new, bark, all");
			String choice = scan.nextLine();
			while(! choice.equals("exit")) {
				if(choice.equals("new")) {
					System.out.print("Enter name of dog: ");
					String name = scan.nextLine();
					System.out.print("Enter breed of dog: ");
					String breed = scan.nextLine();
					System.out.print("Enter name of owner: ");
					String owner = scan.nextLine();
					Dog d = new Dog(name, breed);
					database.put(owner, d);
				} else if(choice.equals("bark")) {
					System.out.print("Enter name of owner: ");
					String owner = scan.nextLine();
					Dog d = database.get(owner);
					if(d != null) {
						System.out.print("Enter new bark sound: ");
						d.addBarkSound(scan.nextLine());
					} else {
						System.out.println("No dog associated with that owner name.");
					}
				} else if(choice.equals("all")) {
					for(String owner : database.keySet()) {
						System.out.println(owner + " owns " + database.get(owner));
					}
				} else if(choice.equals("speak!")) {

					System.out.print("Enter name of owner: ");
					String owner = scan.nextLine();
					Dog d = database.get(owner);
					if(d != null) {
						System.out.print("Enter new bark sound: ");
						d.bark();
					} else {
						System.out.println("No dog associated with that owner name.");
					}
				} else {
					System.out.println("Unknown command");
				}
				choice = scan.nextLine();
			}
			
			
		}
		
		public static void warmUpStuff() {
			Dog d = new Dog("Akamaru", "Ninken");
			Object o1 = new Object();
			System.out.println(o1);
			System.out.println(o1.hashCode());
			Object o2 = new Object();
			System.out.println(o1.equals(o2));
			System.out.println(d.equals(o1));
			System.out.println(o1.equals(o1));
			Dog d2 = new Dog("Akamaru", "Ninken");
			if(d.equals(d2)) {
				System.out.println(d + " is equal to " + d2);
			} else {
				System.out.println(d + " is not equal to " + d2);
			}
			System.out.println(d.hashCode());
			System.out.println(d2.hashCode());
			System.out.println(d);
			d.bark();
			d.addBarkSound("yip");
			d.bark();
			d.bark();
			d.bark();
			d.bark();
			HashMap<String, Dog> database = new HashMap<String, Dog>();
			database.put("Kiba Inuzuka", d);
			database.put("Konstantin Levin", new Dog("Laska", "Pointer"));
			Dog d3 = database.get("Kiba Inuzuka");
			System.out.println("from database: " + d3);
			for(String owner : database.keySet()) {
				System.out.println(owner + " owns " + database.get(owner));
			}
		}
	}

	/**
	 * A simulation of a dog.
	 * the dog will be able to bark.
	 * we will be able to change the barking sound.
	 * the dog will have a name.
	 * the dog will have a breed.
	 * @author paul
	 *
	 */
	class Dog {
		String myName;
		String myBreed;
		
		String[] barkSounds = new String[] {"woof"};
		
		/**
		 * Constructor.
		 * 
		 */
		public Dog(String name, String breed) {
			myName = name;
			myBreed = breed;
		}
		
		public String toString() {
			return "<<Name: " + myName + "; myBreed: " + myBreed + ">>";
		}
		
		/** this method to produce a string 'bark' sound.*/
		public void bark() {
			int index = (int)(Math.random() * barkSounds.length);
			System.out.println(barkSounds[index]);
		}
		
		public void addBarkSound(String sound) {
			String[] newSounds = new String[barkSounds.length + 1];
			for(int i = 0; i < barkSounds.length; i++) {
				newSounds[i] = barkSounds[i];
			}
			newSounds[barkSounds.length] = sound;
			barkSounds = newSounds;
		}
		
		//getter
		public String getName() {
			return myName;
		}
		
		//setter
		public void setName(String name) {
			myName = name;
		}
		
		public boolean equals(Object o) {
			if(o instanceof Dog) {
				Dog other = (Dog)o;
				return myName.equals( other.myName) && myBreed.equals( other.myBreed);
			}
			return false;
		}
		
		public int hashCode() {
			return myName.hashCode() + myBreed.hashCode();
		}
		
	}


