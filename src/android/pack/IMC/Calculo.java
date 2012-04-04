package android.pack.IMC;

public class Calculo {
	
	private String autor = "Tássio";
	private String data_insercao = "00/00";
	private float peso;
	private float altura;
	private float imc;
	
	public Calculo()
	{
		
	}
	
	public float getAltura() {
		
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getImc() {
		return imc;
	}

	public void setImc(float imc) {
		this.imc = imc;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getData_insercao() {
		return data_insercao;
	}

	public void setData_insercao(String data_insercao) {
		this.data_insercao = data_insercao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String dadosCalculo()
	{
		String dados = "";
		dados += "Autor: " + getAutor();
		if(getData_insercao() != null)
		{
			dados += "Data: " + getData_insercao();
		}
		dados += "Peso: " + getPeso();
		dados += "\nAltura: " + getAltura();
		dados += "\nIMC: " + getImc();
		dados += "\n___________________";
		
		return dados;
	}

}
