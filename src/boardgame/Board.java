package boardgame;

import chess.ChessPosition;
import exception.BoardException;

public class Board {
	private int rows;
	private int columns;
	
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("O tabuleiro deve ter no minimo uma linha e uma coluna.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece (Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public void putPiece(Piece piece, Position position) {
		if(thereIsAPeace(position)) {
			throw new BoardException("Já existe uma peça nessa posição do tabuleiro!");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row <= this.rows && column >=0 && column <= this.columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPeace(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Essa posição nao existe no tabuleiro!");
		}
		return piece(position) != null;
	}
}
