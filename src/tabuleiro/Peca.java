package tabuleiro;

public abstract class Peca {
	
	protected Posicao posicao;
	
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public abstract boolean[][] movimentoPossivel();
	
	public boolean movimentoPossivel(Posicao posicao) {
		return movimentoPossivel()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean existeAlgumMovimentoPossivel() {
		boolean[][] mat = movimentoPossivel();
		for(int i=0; i < mat.length; i++) {
			for(int j=0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
}
