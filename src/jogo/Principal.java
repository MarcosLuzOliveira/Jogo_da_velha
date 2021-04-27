package jogo;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// var Para iniciar jogo
			String jogador1;
			String jogador2;
			int tabuleiro;
			int resposta;
		//Fim var Para iniciar jogo
			
		jogoDaVelha j1;
		Jogador g1;
		System.out.println("Digite o valor do tabuleiro");
		tabuleiro = scanner.nextInt();
		System.out.println("Nome do jogador X");
		jogador1 = scanner.next();
		
		System.out.println("Nome do jogador O");
		jogador2 = scanner.next();
		
		
		g1 = new Jogador(jogador1, jogador2);
		j1 = new jogoDaVelha(tabuleiro);
		do {
			int contjogadas;
			contjogadas = 0;
			j1.constroi();
		
			do {
				contjogadas ++;
				j1.tabuleiro();
				j1.fazJogada(contjogadas);
				j1.verificaGanhador();
				if(j1.verificaGanhador() == true) {
					j1.tabuleiro();
				}
				
			}while(!(j1.verificaGanhador() == true));
				
				if(j1.getVercedor().equalsIgnoreCase("X")) {
					g1.setPontosj1(1);
				}else if(j1.getVercedor().equalsIgnoreCase("O")) {
					g1.setPontosj2(1);
				}else{
					System.out.println("Empate");
				}
				
				do {
					System.out.println("Gostaria de jogar denovo Sim(1) Não(0)");
					resposta = scanner.nextInt();
					if(resposta != 1 && resposta != 0) {
						System.out.println("ERRO NA RESPOSTA");
					}
				}while(!(resposta == 1 || resposta == 0));
		}while(!(resposta == 0));

				System.out.println(g1.toString());
		}
	}
