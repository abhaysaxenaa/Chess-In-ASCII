package pieces;

import java.util.ArrayList;

import chess.Coordinates;

public class Pawn extends ChessPiece{
	
	private String color;
	
	public Pawn(String color) {
		super(color);
	}
	
	public String getPlayerColor() {
		return super.getPlayerColor();
	}
	
	public boolean checkValidity(Coordinates curr, Coordinates end, Case specialCase) {
		if (curr.calculateDistance(end) > 8 || (curr.getRow() < 0 || curr.getCol() < 0)) {
			return false;
		} else {
			return true;
		}
	}
	
	public ArrayList<Coordinates> pieceMoveList() {
		return null;
	}
	
	public String printPiece() {
		if (this.color.equals("White")) {
			return "wp";
		} else {
			return "bp";
		}
	}
}