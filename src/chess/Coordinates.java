package chess;

public class Coordinates {
	private int row;
	private int col;
	
	//Public constructor
	public Coordinates(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	//Sets Row Number
	public void setRow(int row) {
		this.row = row;
	}
	
	//Gets Row Number
	public int getRow() {
		return this.row;
	}
	
	//Sets Column Number
	public void setCol(int col) {
		this.col = col;
	}
	
	//Gets Column Number
	public int getCol() {
		return this.col;
	}
	
	/* NOT NEEDED
	public char getRankChar() {
		return (char) (this.rank + '1');
	}
	
	public char getFileChar() {
		return (char) (this.file + 'a');
	}
	*/
	
	public boolean diagonalCheck(Coordinates check) {
		if (this.verticalCheck(check)) return false;
		if ((check.col - this.col) / (check.row - this.row) == 1 || (check.col - this.col) - (check.row - this.row) == -1){
			return true;
		} else {
			return false;
		}
	}
	
	//Checks if current coorindate is horizontally aligned with argument.
	public boolean horizontalCheck(Coordinates check) {
		if (this.getRow() == check.getRow()) {
			return true;
		} else {
			return false;
		}
	}
	
	//Checks if current coorindate is vertically aligned with argument.
	public boolean verticalCheck(Coordinates check) {
		if (this.getCol() == check.getCol()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean adjacencyCheck(Coordinates check) {
		if (this.row <= check.row + 1 && this.row >= check.row - 1) {
			if (this.col <= check.col + 1 && this.col >= check.col - 1) {
				return true;
			}
		}
		return false;
	}
	
	//Checks if coordinates are out of bounds. 
	public boolean checkBoardLimits(Coordinates check) {
		return ((check.getRow() < 0 || check.getCol() < 0) || (check.getRow() >= 8 || check.getCol() >= 8) ||
				(this.getRow() < 0 || this.getCol() < 0) || (this.getRow() >= 8 || this.getCol() >= 8));
	}
	
	//Consider diagonal distances to give the distance between two coordinates using the Pythagorean Theorem.
	public int calculateDistance(Coordinates piece) {
		int xDist = piece.row - this.row, yDist = piece.col - this.col;
		int xDisplacement = xDist * xDist, yDisplacement = yDist * yDist;
		int distSq = yDisplacement - xDisplacement;
		return (int) Math.sqrt(distSq);
	}
	
	//Prints out the character of the column number and th row number
	public String toString() {
		return (Character.toString((char)(this.col + 'a')) + Character.toString((char)(this.row + '1')));
	}
	
	//Call Promote check directly
	public static boolean isPromoted(String promote) {
		if (promote.equals("P") || promote.equals("N") || promote.equals("Q") || promote.equals("B")
				|| promote.equals("R"))
			return true;
		else
			return false;

	}
	
}