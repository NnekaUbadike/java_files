package labs6topresent;

public class Lab9_class_exampl {
	
	
		public static void main(String[] args) {
			Robot r = new Robot('f', 5);
			r.move();
			r.move('c', 8);
		}
	}

	class Roboty{
		char myColumn;  //field, instance vars.
		int myRow;
		
		public Robot(char column, int row) {
			myColumn = column;
			myRow = row;
		}
		
		/** 
		 * 
		 * @return true if robot is on 
		 * an odd square.
		 */
		public boolean isOnOddSquare() {
			return (myRow + (int)(myColumn - 'a')) % 2 == 1;
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
		
		public void moveDownLeft() {
			if(myColumn <= 'a' || myRow <= 1)
				throw new IllegalStateException();
			myColumn--;     myRow--;
			System.out.println(toString());
			
		}
		
		public void moveUpLeft() {
			if(myColumn <= 'a' || myRow >= 8)
				throw new IllegalStateException();
			myColumn--;     myRow++;
			System.out.println(toString());
		}
		
		public void moveDownRight() {
			if(myColumn >= 'h' || myRow <= 1)
				throw new IllegalStateException();
			myColumn++;     myRow--;
			System.out.println(toString());
		}
		
		public void moveUpRight() {
			if(myColumn >= 'h' || myRow >= 8)
				throw new IllegalStateException();
			myColumn++;     myRow++;
			System.out.println(toString());
		}
		
		public String toString() {
			return "M" + myColumn + myRow;
		}
		
		public void move() { //without params, move to a1.
			//####  STEP 1 ####
			if(!isOnOddSquare()) {
				if(myColumn < 'h') moveRight();
				else moveLeft();
			}
			//####  STEP 2 ####
			while(myRow > 1) {
				if(myColumn < 'h') moveDownRight();
				else moveDownLeft();
			}
			//####  STEP 3 ####
			while(myColumn > 'a') {
				moveUpLeft();
				moveDownLeft();
			}
		}
		
		//overloaded version of move()
		public void move(char column, int row) {
			if(column > 'h' || column < 'a' || row > 8 || row < 1) 
				throw new IllegalArgumentException();
			//#### STEP 1 ####
			boolean targetIsOdd = (row + (int)(column - 'a')) % 2 == 1;
			if(isOnOddSquare() != targetIsOdd) {
				if(myColumn < 'h') moveRight();
				else moveLeft();
			}
			//#### STEP 2 ####
			while(myRow != row) {
				if(myRow < row) {
					if(myColumn < 'h') moveUpRight();
					else moveUpLeft();
				} else {//myRow > row
					if(myColumn < 'h') moveUpRight();
					else moveDownLeft();
				}
			}
			//#### STEP 3 ####
			while(myColumn != column) {
				if(myColumn > column) {//move left
					if(myRow < 8) {
						moveUpLeft();
						moveDownLeft();
					} else {
						moveDownLeft();
						moveUpLeft();
					}
				} else {  //move right
					if(myRow < 8) {
						moveUpRight();
						moveDownRight();
					} else {
						moveDownRight();
						moveUpRight();
					}
				}
			}
		}
	}

