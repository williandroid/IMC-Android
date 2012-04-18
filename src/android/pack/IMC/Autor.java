package android.pack.IMC;

import java.util.ArrayList;

public class Autor {
	private String nome;
	private ArrayList<Calculo> historico = new ArrayList<Calculo>();
	
	public ArrayList<Calculo> getHistorico() {
		return historico;
	}

	public void setHistorico(Calculo calculo) {
		this.historico.add(calculo);	
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
