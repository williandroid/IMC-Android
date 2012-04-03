package android.pack.IMC;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBase {

	private static final String NOME_BANCO = "IMC";
	private static final String NOME_TABELA = "calculos";
	private String data_insercao;
	private float peso;
	private float altura;
	private float imc;
	private final SQLiteDatabase db;
	
	public DataBase(Context ctx)
	{
		db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
	}
	
	public String dadosCalculo()
	{
		String dados ="";
		if(getData_insercao() != null)
		{
			dados += "Data: " + getData_insercao();
		}
		dados += "Peso: " + getPeso();
		dados += "\nAltura: " + getAltura();
		dados += "\nIMC: " + getImc();
		
		return dados;
	}
	
	public String buscar()
	{
		return "";
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
	
}
