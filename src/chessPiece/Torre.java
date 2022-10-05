package chessPiece;

import tabuleiro.Tabuleiro;
import xadrez.PecaXadrez;
import xadrez.Cor;

public class Torre extends PecaXadrez{
	
	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentoPossivel() {
		return new boolean[this.getTabuleiro().getLinhas()][this.getTabuleiro().getColunas()];
	}
}
