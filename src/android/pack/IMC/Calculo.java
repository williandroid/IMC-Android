package android.pack.IMC;

public class Calculo {
	
	private int _id;
	private String data_insercao;
	private float peso;
	private float altura;
	private float imc;
	
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

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

}
