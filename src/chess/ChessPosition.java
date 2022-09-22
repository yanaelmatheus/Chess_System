package chess;

import boardgame.Position;

public class ChessPosition {
	private char column;
	private Integer row;
	
	public ChessPosition(char column, Integer row) {
		this.column = column;
		this.row = row;
	}
	
	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	protected ChessPosition toChessPosition(Position position) {
		return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
