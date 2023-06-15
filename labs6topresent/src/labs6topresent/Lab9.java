package labs6topresent;
import java.util.Scanner;

public class Lab9 {
	public static void main(String [] args) {
		
		
		
		Scanner scan = new Scanner (System.in);
		System.out.print("enter column ");
		String column = scan.nextLine();
		System.out.print("enter row ");
		int row = scan.nextInt();
		scan.nextLine();
		Robot r = new Robot(column.charAt(0), row);
		r.move();
		
		System.out.print("enter column ");
		String newcolumn = scan.nextLine();
		System.out.print("enter row ");
	    int newrow = scan.nextInt();
	    scan.nextLine();
		r.move(newcolumn.charAt(0),newrow);
		
		//scan.nextLine();
		
		//r.move(r.myColumn, r.myRow);
		//while (true){
			//System.out.print("enter column ");
			//String newcolumn = scan.nextLine();
			//System.out.println("enter row ");
		    //int newrow = scan.nextInt();
		
		    //the problem was u were putting these variables in a new object 
		     // which did not make sense
		    //r.move(newcolumn.charAt(0), newrow);
			
			//r.move(r.myColumn,r.myRow);
			
		//}
		//r.move(column.charAt(0), row);	
	}

}

class Robot{
	char  myColumn;  
	int myRow;
	
	public Robot(char column, int row) {
		myColumn= column;
		myRow = row; 
	}
	public void moveRight() {
		if(myColumn >= 'h') throw new IllegalStateException();
		myColumn++;
		System.out.println(toString());
	}
	public void moveLeft() {
		if(myColumn <= 'a') throw new IllegalStateException();
		myColumn--;
		System.out.println(toString());
	}
	public void moveUp () {
		  if (myRow >= 9 ) throw new IllegalStateException();
		  myRow ++;
		  System.out.println(toString());
	}
	public void moveDown () {
		if (myRow <= 0 )throw new IllegalStateException();
		myRow --;
		System.out.println(toString());
	}
	public String toString() {
		return "R" + myColumn + myRow;
	}
	
	
	public void move() { 
		while(myRow > 1) {
			if(myColumn < 'h') moveDown();
			
		} 
		
		while(myColumn > 'a') {
			moveLeft();
			
		}	
	}
	
	
	
	// overloaded method
	public void move (char column, int row) {
		if(column > 'h' || column < 'a' || row > 8 || row < 1) 
			throw new IllegalArgumentException();
		while(myRow != row) {
			if(myRow < row) {
				if(myColumn < 'h') moveUp();
				else moveDown();
			} else {//myRow > row
				if(myColumn < 'h') moveRight();
				else moveLeft();
			}
		}
		
		while(myColumn != column) {
			if(myColumn > column) {//move left
				if(myRow < 8) {
					moveLeft();
				}
			} else {  //move right
				if(myRow < 8) {
					moveRight();


				} 
			}
		}
		
	}	
	
}
