package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		ChessMatch cm = new ChessMatch(8,8);
		
		UI.printBoard(cm.getPieces());

	}

}
