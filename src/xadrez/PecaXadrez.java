package xadrez;

import tabuleiro.Tabuleiro;
import tabuleiro.Peca;
import tabuleiro.Posicao;

public abstract class PecaXadrez extends Peca{
	private Cor cor;

	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	protected boolean existePecaInimiga(Posicao posicao) {
		PecaXadrez p = (PecaXadrez) getTabuleiro().buscarPeca(posicao);
		return p != null && p.getCor() != getCor();
	}
}
