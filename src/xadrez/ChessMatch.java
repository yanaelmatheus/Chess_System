package xadrez;

import chessPiece.Rei;
import chessPiece.Torre;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class ChessMatch {
	
	private Tabuleiro board;
	
	//private PecaXadrez[][] chessPiece;
	
	public ChessMatch() {
		this.board = new Tabuleiro(8, 8);
		initialSetup();
	}
	
	public PecaXadrez[][] getPecas(){
		
		PecaXadrez[][] mat = new PecaXadrez[this.board.getLinhas()][this.board.getColunas()];
		
		for(int i = 0; i < board.getLinhas(); i++) {
			for(int j = 0; j < board.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) board.buscarPeca(i, j);
			}
		}
		
		return mat;
	}
	
	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem){
		Posicao posicao = posicaoOrigem.converterParaPosicao();
		validarPosicaoOrigem(posicao);
		
		return board.buscarPeca(posicao).movimentoPossivel();
	}
	
	public PecaXadrez executarMovimento(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.converterParaPosicao();
		Posicao destino = posicaoDestino.converterParaPosicao();
		
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		return (PecaXadrez) realizarMovimento(origem, destino);
		
	}
	
	public void putNewPiece(PecaXadrez piece, PosicaoXadrez chessPosition) {
		this.board.incluirPeca(piece, chessPosition.converterParaPosicao());
	}
	
	private Peca realizarMovimento(Posicao posicaoOrigem, Posicao posicaoDestino) {
		Peca p = board.removerPeca(posicaoOrigem);
		Peca pecaCapturada = board.removerPeca(posicaoDestino);
		
		board.incluirPeca(p, posicaoDestino);
		
		return pecaCapturada;
	}
	public void validarPosicaoOrigem(Posicao posicaoOrigem) {
		if(!board.VerificaPecaPosicao(posicaoOrigem)) {
			throw new ChessException("N�o existe uma pe�a nessa posi��o.");
		}
		
		if(!board.buscarPeca(posicaoOrigem).existeAlgumMovimentoPossivel()) {
			throw new ChessException("N�o existe nenhum movimento Poss�vel!");
		}
	}
	
	private void validarPosicaoDestino(Posicao posicaoOrigem, Posicao posicaoDestino) {
		if(!board.buscarPeca(posicaoOrigem).movimentoPossivel(posicaoDestino)) {
			throw new ChessException("A posicao de destino n�o � um movimento Possivel!");
		}
	}
	public void initialSetup() {
		putNewPiece(new Torre(board, Cor.BRANCO), new PosicaoXadrez('c', 1));
		putNewPiece(new Torre(board, Cor.BRANCO), new PosicaoXadrez('c', 2));
        putNewPiece(new Torre(board, Cor.BRANCO), new PosicaoXadrez('d', 2));
        putNewPiece(new Torre(board, Cor.BRANCO), new PosicaoXadrez('e', 2));
        putNewPiece(new Torre(board, Cor.BRANCO), new PosicaoXadrez('e', 1));
        putNewPiece(new Rei(board, Cor.BRANCO), new PosicaoXadrez('d', 1));

        putNewPiece(new Torre(board, Cor.PRETO), new PosicaoXadrez('c', 7));
        putNewPiece(new Torre(board, Cor.PRETO), new PosicaoXadrez('c', 8));
        putNewPiece(new Torre(board, Cor.PRETO), new PosicaoXadrez('d', 7));
        putNewPiece(new Torre(board, Cor.PRETO), new PosicaoXadrez('e', 7));
        putNewPiece(new Torre(board, Cor.PRETO), new PosicaoXadrez('e', 8));
        putNewPiece(new Rei(board, Cor.PRETO), new PosicaoXadrez('d', 8));
	}
}
