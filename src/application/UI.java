package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.Cor;

public class UI {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static void imprimirTabuleiro(PecaXadrez[][] pecas) {

		for (int i=0; i<pecas.length; i++) {
			System.out.print((8-i) + " ");
			for(int j=0; j<pecas.length; j++) {
				imprimirPeca(pecas[i][j]);
			}
			System.out.println();
		}
		System.out.print("  a b c d e f g h");
	}
	
	public static PosicaoXadrez lerPosicao(Scanner sc) {
		try {
			
				String posicao = sc.nextLine();
				
				char col = posicao.charAt(0);
				Integer lin = Integer.parseInt(posicao.substring(1));
				
				return new PosicaoXadrez(col, lin);
		}catch(Exception e ){
			throw new InputMismatchException("Erro lendo posição de Xadrez.");
		}
	}
	
	public static void imprimirPeca(PecaXadrez pecaXadrez) {
		if (pecaXadrez == null) {
            System.out.print("-");
        }
        else {
            if (pecaXadrez.getCor() == Cor.BRANCO) {
                System.out.print(ANSI_WHITE + pecaXadrez + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + pecaXadrez + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}
	
	public static void limparTela() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
}
