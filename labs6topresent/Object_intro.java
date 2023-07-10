 package labs6topresent;
import java.util.Scanner;
public class Object_intro {

	public static void main(String[] args) {
		Scanner source= new Scanner(System.in);
		worker object1= createobject(source);
		worker object2= createobject(source);
		worker older;
		worker younger;
		if (object1.age >object2.age) {
			older= object1;
			younger= object2;
			alterobject(object2);
		}
		else {
			older =object2;
			younger = object1;
			alterobject(object1);
			
		}
		System.out.println(older.name+ " "+ older.age + " is the eldest");
		System.out.println(younger.name + " "+ younger.age+ " is the youngest");
		
	}
	public static worker createobject (Scanner source){
		worker object= new worker();
		System.out.println("Enter a name");
		object.name= source.next();
		//source.nextLine();
		System.out.println("Enter an age");
		object.age= source.nextInt();
		return object;
		
	}
	
	public static void alterobject(worker var) {
		var.age+=3;
		
	}

}
 class worker{
	 String name;
	 int age;
 }