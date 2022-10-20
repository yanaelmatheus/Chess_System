package chessPiece;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

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
		boolean[][] mat = new boolean[this.getTabuleiro().getLinhas()][this.getTabuleiro().getColunas()];
		
		//Verifica movimentos para CIMA
		Posicao p = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().VerificaPecaPosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if(getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verifica movimentos para BAIXO
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().VerificaPecaPosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if(getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verifica movimentos para ESQUERDA
		p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().VerificaPecaPosicao(p)) {
			
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if(getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verifica movimentos para DIREITA
		p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().VerificaPecaPosicao(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if(getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		return mat;
	}
}
