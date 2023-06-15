package labs6topresent;
import java.util.Arrays;
public class Lab10_class_examp {
	
	

	/**
	 * An door is a representation of
	 * a real-world door: 
	 * @author olsenp
	 *
	 */

	//this is the superclass
	public class Door {
		//state[0] will be locked or unlocked.
		//state[1] will be closed or open.
		private String[] state;
		
		public Door() { //default constructor.
			//called default because it takes no parameters
			state = new String[] {"locked", "closed"};
		}
		
		public void unlock() {
			if(state[0].equals("locked")) {
				state[0] = "unlocked";
			} else {
				throw new IllegalStateException("unlocking " + getState());
			}
		}
		
		public void lock() {
			if(state[0].equals("unlocked") && state[1].equals("closed")) {
				state[0] = "locked";
			} else {
				throw new IllegalStateException("locking " + getState());
			}
		}
		
		public void open() {
			if(state[0].equals("unlocked") && state[1].equals("closed")) {
				state[1] = "opened";
			} else {
				throw new IllegalStateException("opening " + getState());
			}
		}
		
		public void close() {
			if(state[1].equals("opened")) {
				state[1] = "closed";
			} else {
				throw new IllegalStateException("closing " + getState());
			}
		}
		
		//something went wrong.  the valid state the door
		//is in is unknown.  we want to put it in a known
		//state: [locked, closed].
		public void reset() {
			try { 
				close();
			} catch(IllegalStateException e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				lock();
			} catch(IllegalStateException e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}

		public String getState() {
			return Arrays.toString(state);
		}
		
		public String toString() {
			return "door in state " + getState();
		}
	}
}
