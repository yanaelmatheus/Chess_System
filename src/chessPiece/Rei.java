package chessPiece;

import tabuleiro.Tabuleiro;
import xadrez.PecaXadrez;
import xadrez.Cor;

public class Rei extends PecaXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] movimentoPossivel() {
		return new boolean[this.getTabuleiro().getLinhas()][this.getTabuleiro().getColunas()];
	}
}