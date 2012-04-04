/*package android.pack.IMC;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBase {

	private final String NOME_BANCO = "IMC";
	private final String NOME_TABELA = "calculos";
	private ArrayList<Calculo> calculos = new ArrayList<Calculo>();
	private SQLiteDatabase db = null;
	
	public DataBase(Context ctx)
	{
		db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXIST "+ NOME_TABELA + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
				" autor TEXT NOT NULL, data TEXT NOT NULL, peso REAL NOT NULL, altura REAL NOT NULL, imc REAL NOT NULL");
	}
	
	public ArrayList<Calculo> buscar(String autor)
	{
		Cursor resposta = db.query(NOME_TABELA, new String[] {"_id", "autor", "data", "peso", "altura", "imc"},
					"autor=?", new String[]{autor}, null, null, null);
		if(resposta.getCount() > 0)
		{
			int count = 1;
			resposta.moveToFirst();
			while(count < resposta.getCount())
			{
				Calculo calculo = new Calculo();
				calculo.setAutor(resposta.getString(2));
				calculo.setData_insercao(resposta.getString(3));
				calculo.setPeso(resposta.getFloat(4));
				calculo.setAltura(resposta.getFloat(5));
				calculo.setImc(resposta.getFloat(6));
				calculos.add(calculo);
				resposta.moveToNext();
				count ++;
			}
			
		}
		
		return calculos;
	}
	
	public void inserir(Calculo calculo)
	{
		ContentValues objeto = new ContentValues();
		objeto.put("autor", calculo.getAutor());
		objeto.put("data", calculo.getData_insercao());
		objeto.put("peso", calculo.getPeso());
		objeto.put("altura", calculo.getAltura());
		objeto.put("imc", calculo.getImc());
		db.insert(NOME_TABELA, null, objeto);
	}
	
	public ArrayList<Calculo> getCalculos() {
		
		return calculos;
	}

	public void setCalculos(ArrayList<Calculo> calculos) {
		this.calculos = calculos;
	}
}
*/