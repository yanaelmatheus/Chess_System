package xadrez;

import exception.BoardException;

public class ChessException extends BoardException{
	public ChessException(String msg) {
		super(msg);
	}
}
