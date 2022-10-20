package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.ChessException;
import xadrez.ChessMatch;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch cm = new ChessMatch();
		
		while(true) {
			try{
				UI.limparTela();
				UI.imprimirTabuleiro(cm.getPecas());
				System.out.println();
				System.out.println("Origem: ");
				PosicaoXadrez posicaoOrigem = UI.lerPosicao(sc);
				boolean[][] movimentosPossiveis = cm.movimentosPossiveis(posicaoOrigem);
				UI.limparTela();
				UI.imprimirTabuleiro(cm.getPecas(), movimentosPossiveis);
				
				System.out.println();
				System.out.println("Destino: ");
				PosicaoXadrez posicaoDestino = UI.lerPosicao(sc);
				PecaXadrez pecaCapturada = cm.executarMovimento(posicaoOrigem, posicaoDestino);
			}catch(ChessException e ) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
