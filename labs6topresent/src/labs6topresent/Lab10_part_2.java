package labs6topresent;

public class Lab10_part_2 {


//subclass inherits all things (non-private) from the
//superclass.
public class PasswordProtectedDoor extends Door{
	//can't access state.
	private String myPassword;
	public PasswordProtectedDoor(String password) {
		myPassword = password;
	}
	
	//overloading.
	public void unlock(String password) {
		if(myPassword.equals(password)) {
			unlock();
		} else {
			throw new IllegalArgumentException("wrong password.");
		}
	}
	
	//overriding.
	public String toString() {
		return "password protected door in state " + getState();
	}
}

