package tabuleiro;

import exception.BoardException;
import xadrez.PosicaoXadrez;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}
	
	public Peca buscarPeca(int linha, int coluna) {
		if(!existePosicao(linha, coluna)) {
			throw new BoardException("Posição não existe no Tabuleiro!");
		}
		return pecas[linha][coluna];
	}
	
	public Peca buscarPeca(Posicao posicao) {
		if(!existePosicao(posicao)) {
			throw new BoardException("Posição não existe no Tabuleiro!");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void incluirPeca(Peca peca, Posicao posicao) {
		if(VerificaPecaPosicao(posicao)) {
			throw new BoardException("Já existe uma peça nessa posição do tabuleiro!");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removerPeca(Posicao posicao) {
		if(!VerificaPecaPosicao(posicao)) {
			return null;
		}
		Peca aux = buscarPeca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		
		return aux;
	}
	
	private boolean existePosicao(int linha, int coluna) {
		return linha >= 0 && linha < this.linhas && coluna >=0 && coluna < this.colunas;
	}
	
	public boolean existePosicao(Posicao posicao) {
		return existePosicao(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean VerificaPecaPosicao(Posicao posicao) {
		if(!existePosicao(posicao)) {
			throw new BoardException("Essa posição nao existe no tabuleiro!");
		}
		return buscarPeca(posicao) != null;
	}
}
