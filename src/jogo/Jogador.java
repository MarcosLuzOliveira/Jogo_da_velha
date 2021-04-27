package jogo;

public class Jogador {
	String jogadorX;
	String jogadorO;
	int pontosjog1;
	int pontosjog2;
	public Jogador(String jogadorX, String jogadorO) {
		this.jogadorX = jogadorX;
		this.jogadorO = jogadorO;
	}
	
	public void setPontosj1(int pontos) {
		pontosjog1 += pontos;
	}
	
	public void setPontosj2(int pontos) {
		pontosjog2 += pontos;
	}
	
	public int getPontosj1() {
		return pontosjog1;
	}
	
	public int getPontosj2() {
		return pontosjog2;
	}

	public String getJogadorX() {
		return this.jogadorX;
	}	
	
	public String getJogadorO() {
		return this.jogadorO;
	}
	
	public String toString() {
		String resultado;
		resultado = "O placar final foi "+getJogadorX()+" com "+getPontosj1()+" pontos e "+getJogadorO()+" com "+getPontosj2()+ " pontos";
		return resultado;
	}
}
