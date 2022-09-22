package chess;

import boardgame.Board;
import chessPiece.King;
import chessPiece.Rook;

public class ChessMatch {
	
	private Board board;
	
	private ChessPiece[][] chessPiece;
	
	public ChessMatch(int rows, int columns) {
		this.board = new Board(rows, columns);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		
		ChessPiece[][] mat = new ChessPiece[this.board.getRows()][this.board.getColumns()];
		
		for(int i = 0; i < board.getRows(); i++) {
			for(int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		
		return mat;
	}
	
	
	public void putNewPiece(ChessPiece piece, ChessPosition chessPosition) {
		this.board.putPiece(piece, chessPosition.toPosition());
	}
	
	public void initialSetup() {
		putNewPiece(new Rook(board, Color.WHITE), new ChessPosition('c', 1));
		putNewPiece(new Rook(board, Color.WHITE), new ChessPosition('c', 2));
        putNewPiece(new Rook(board, Color.WHITE), new ChessPosition('d', 2));
        putNewPiece(new Rook(board, Color.WHITE), new ChessPosition('e', 2));
        putNewPiece(new Rook(board, Color.WHITE), new ChessPosition('e', 1));
        putNewPiece(new King(board, Color.WHITE), new ChessPosition('d', 1));

        putNewPiece(new Rook(board, Color.BLACK), new ChessPosition('c', 7));
        putNewPiece(new Rook(board, Color.BLACK), new ChessPosition('c', 8));
        putNewPiece(new Rook(board, Color.BLACK), new ChessPosition('d', 7));
        putNewPiece(new Rook(board, Color.BLACK), new ChessPosition('e', 7));
        putNewPiece(new Rook(board, Color.BLACK), new ChessPosition('e', 8));
        putNewPiece(new King(board, Color.BLACK), new ChessPosition('d', 8));
	}
}
