package jogo;
import java.util.Scanner;

public class jogoDaVelha {
	Scanner scanner = new Scanner(System.in);
	
	//Var geral
	int tabuleiro = 0 ;
	String game [] [];
	String jogador;
	String ganhador;
	boolean resultado = false;
	
	int contJogadas;
	
	int contEmpate;
	
	int pontosX;
	int pontosO;
	
	public jogoDaVelha(int tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.game = new String [tabuleiro] [tabuleiro];
	}
	
	public void constroi() {
		  String i;
		  String ii;
		  //valore do array (tabuleiro)
		for(int t = 0; t < tabuleiro; t++) {
			  i = Integer.toString(t);
				for(int tt = 0; tt < tabuleiro; tt++) {
					ii = Integer.toString(tt); 
					this.game [t] [tt] = "[" + i + "]" + "[" + ii + "]" ;
				}
			}
	}
	
	public void tabuleiro(){
		  //Array na tela
			for(int i = 0; i < tabuleiro; i++) {
				System.out.println("");
				for(int ii = 0; ii < tabuleiro; ii++) {
						System.out.print("| "+game[i] [ii]+" |");
				}
			}
			System.out.println("");
			//System.out.println("8 8 " +game[8] [8]);
		}

	public boolean fazJogada(int numjogada) {
		int contJogada = numjogada;
		
		//var verifica ocupado/feito
		int ocupado = 0;
		int feita = 0;
		//fim var verifica ocupado/feito
		
		int linha;
		int coluna;
		boolean resultadoJog = false;
		
		int certo = 0;
				
		do {
		/*	do {
				certo = 0;
				System.out.println("Qual é o jogador [X ou O]");
				jogador = scanner.next();
				this.jogador = jogador.toUpperCase();
				if(this.jogador.equalsIgnoreCase("X") || this.jogador.equalsIgnoreCase("O")) {
					certo = 0;
				}else {
					System.out.println("É aceito apenas os valores X OU O");
					certo = 1;
				}
			}while(certo == 1);*/
			if(contJogada % 2 == 1) {
				this.jogador = "X";
			}else {
				this.jogador = "O";
			}
			
			System.out.println("Jogador "+jogador+" digite uma linha");
			linha = scanner.nextInt();
		
			System.out.println("Jogador "+jogador+" digite uma coluna");
			coluna = scanner.nextInt();
		
			ocupado = 0;
			
			//Converte o que foi dígitado para String
			String linhaS;
			String colunaS;
			linhaS = Integer.toString(linha);
			colunaS = Integer.toString(coluna);
			String linhaColuna = ("[" + linhaS + "]" + "[" + colunaS + "]") ; 
		
			//Verifica a posição e coloca a letra do jogador						
			for(int i = 0; i < tabuleiro; i++) {
				for (int ii = 0; ii < tabuleiro; ii++){
					if((game [linha] [coluna].equalsIgnoreCase("   X  "))
							||(game [linha] [coluna].equalsIgnoreCase("   O  "))){
						ocupado  = 1;
						//System.out.println("ocupado");
						break;	
					}
					else {
						if(game [i] [ii].equalsIgnoreCase(linhaColuna)){
							this.game [i] [ii] = "   "+jogador+"  ";
							feita = 1;
							resultadoJog = true;
							this.contEmpate ++;
							break;
						}
					}
					if(feita == 1) {
						break;
					}else if(ocupado == 1){
						break;
					}
				}		
				
				if(feita == 1) {
					break;
				}else if(ocupado == 1){
					break;
				}
				//if(game [i] [ii].equalsIgnoreCase(linhaColuna)) {
					//this.game [i] [ii] = "   "+jogador+"  ";
					//System.out.println("o que tem "+game [i] [i]);
					//System.out.println(i);
					//System.out.print(ii);
					//cont++;
				//}
			}
			if(feita == 1) {
				break;
			}else if(ocupado == 1) {
				System.out.println("ERRO quadrado já oculpado");
			}
		}while(!(feita == 1));
		
		return resultadoJog;
	}
	
	public boolean verificaGanhador() {
		resultado = false;
		
		// Var linhas
		int countLX;
		int countLO;
		int countJogadasL;
		
		countLX = 0;
		countLO = 0;
		countJogadasL = 0;
		// Fim Var Linhas
		
		//Var colunas
		int countCX;
		int countCO;
		int countJogadasC;
		
		countCX = 0;
		countCO = 0;
		countJogadasC = 0;
		//Fim var colunas
		
		//Var Dig P
		int countDPX;
		int countDPO;
		int countJogadasDP;
		
		countDPX = 0;
		countDPO = 0;
		countJogadasDP = 0;
		//Fim var Dig P
		
		//Var Dig sec
		int countDSX;
		int countDSO;
		int countJogadasDS;
		
		int tabLocal;
		
		countDSX = 0;
		countDSO = 0;
		countJogadasDS = 0;

		tabLocal = (tabuleiro - 1);
		//Fim Var Dig sec
		
		//geral
		contJogadas = 0;
		//fim geral
		
		//Verifica linhas(C) [L] [C]
		for(int i = 0; i < tabuleiro; i++) {
			countLX = 0;
			countLO = 0;
			for(int ii = 0; ii < tabuleiro; ii++) {
				if(game [i] [ii].equalsIgnoreCase("   X  ")) {
					countLX ++;
					countJogadasL ++;
					contJogadas ++;
					//System.out.println(countLX);
					
				}else if(game [i] [ii].equalsIgnoreCase("   O  ")) {
					countLO ++;
					countJogadasL ++;
					//System.out.println(countLO);
				}
				if(countLX == tabuleiro || countLO == tabuleiro || countJogadasL == (tabuleiro * tabuleiro)) {
					break;
				}
			}
			if(countLX == tabuleiro || countLO == tabuleiro || countJogadasL == (tabuleiro * tabuleiro)) {
				break;
			}
		}
		
		//Fim Verifica colunas(C) [L] [C]
			
			
		// Verifica linhas (L) [L] [C]
			
		for(int i = 0; i < tabuleiro; i++) {
			countCX = 0;
			countCO = 0;
			for(int ii = 0; ii < tabuleiro; ii++) {
				if(game [ii] [i].equalsIgnoreCase("   X  ")) {
					countCX ++;
					countJogadasC ++;

					//System.out.println("cx"+countCX);
				}else if(game [ii] [i].equalsIgnoreCase("   O  ")) {
					countCO ++;
					countJogadasC ++;

					//System.out.println("co"+countCO);
				}
				if(countCX == tabuleiro || countCO == tabuleiro || countJogadasC == (tabuleiro * tabuleiro)) {
					break;
				}
			}
			if(countCX == tabuleiro || countCO == tabuleiro || countJogadasC == (tabuleiro * tabuleiro)) {
				break;
			}
		}
			
		// Fim Verifica linhas (L) [L] [C]
			
		//Verifica Dig P(ACHO)(dig tem os números iguais)
			
		for(int i = 0; i < tabuleiro; i++) {
			for(int ii = 0; ii < tabuleiro; ii++) {
				if(i == ii) {
					if(game [i] [ii].equalsIgnoreCase("   X  ")) {
						countDPX ++;
						countJogadasDP ++;
				
						//System.out.println(countLX);	
					}else if(game [i] [ii].equalsIgnoreCase("   O  ")) {
						countDPO ++;
						countJogadasDP ++;

						//System.out.println(countLO);
					}
				}
				if(countDPO == tabuleiro || countDPO == tabuleiro || countJogadasDP == (tabuleiro * tabuleiro)) {
					break;
				}
			}
			if(countDPO == tabuleiro || countDPO == tabuleiro || countJogadasDP == (tabuleiro * tabuleiro)) {
			break;
			}
		}
		// Fim Verifica Dig P
			
		//Verifica Dig SEC
			
		
		// i = linha
		// ii = coluna
		for(int i = 0; i < tabuleiro; i++) {
			for(int ii = 0; ii < tabuleiro; ii++) {
				if((tabLocal - ii) == i) {
						if(game [i] [ii].equalsIgnoreCase("   X  ")) {
							countDSX ++;
							countJogadasDS ++;
							//System.out.println("DS"+ countDSX);	
						}else if(game [i] [ii].equalsIgnoreCase("   O  ")) {
							countDSO ++;
							countJogadasDS ++;
							//System.out.println("DS"+ countDSO);
						}
					}
					if(countDSO == tabuleiro || countDSO == tabuleiro || countJogadasDS == (tabuleiro * tabuleiro)) {
						break;
					}
				}
				if(countDSO == tabuleiro || countDSO == tabuleiro || countJogadasDS == (tabuleiro * tabuleiro)) {
				break;
				}
			}
			//Fim Dig sec
			
		if(countLO == tabuleiro || countCO == tabuleiro || countDPO == tabuleiro || countDSO == tabuleiro) {
			this.resultado = true;
			//System.out.println("ganhador O");
			pontosO ++;
			this.ganhador = "O";
			return true;
		}else if(countLX == tabuleiro || countCX == tabuleiro || countDPX == tabuleiro || countDSX == tabuleiro) {
			this.resultado = true;
			//System.out.println("ganhador X");
			pontosX ++;
			this.ganhador = "X";
			return true;
		}else if(contEmpate == (tabuleiro * tabuleiro)) {
			this.resultado = true;
			System.out.println("Empate");
			System.out.print(contJogadas);
			this.ganhador = "empate";
			return true;
		}
		return resultado;
	}
	
	public String toString() {
		String resposta;
		if(this.resultado == true) {
			resposta = "O jogo acabou o ganhador foi " +ganhador+ ". O jogo chegou ao fim com um total de "+contJogadas+" Jogadas validas";
			
		}else {
			resposta = "O jogo chegou ao fim em empate com um total de "+contJogadas+" jogadas validas";
		}
		
		
		return resposta;
	}
	
	public String getVercedor() {
		return this.ganhador;
	}

	
}
	

