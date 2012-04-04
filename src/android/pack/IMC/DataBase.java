package android.pack.IMC;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataBase {
	
	ArrayList<Calculo> calculos = new ArrayList<Calculo>();
	private SQLiteDatabase db= null;
	private final String NOME_BANCO = "IMC";
	private final String NOME_TABELA = "calculo";	
	private Cursor cursor;
	
	public DataBase(Context ctx)
	{
		CriarBanco(ctx);
	}
	 
	public void SalvarBanco(Float peso, Float altura, Float imc, Context ctx)
	{
		try
		{
			db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
			db.execSQL("INSERT INTO "+ NOME_TABELA + " (peso, altura, imc) VALUES (" + peso + ", " +
					altura + ", "+ imc + ")");
			Mensagem("OK", "Salvo com sucesso!", ctx);
		}catch(SQLException e)
		{
			Mensagem("Error", "Falha ao tentar salvar", ctx);
		}
	}
	
	public void CriarBanco(Context ctx)
	{
		try
		{
			db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
			db.execSQL("CREATE TABLE IF NOT EXISTS "+ NOME_TABELA + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT,"+
					" autor TEXT, data TEXT, peso REAL NOT NULL, altura REAL NOT NULL, imc REAL NOT NULL )");
		
		}catch(SQLException e)
		{
			
		}
	}
	
	public ArrayList<Calculo> buscar(String autor)
	{

		cursor = db.query(NOME_TABELA, new String[] {"_id", "autor", "data", "peso", "altura", "imc"},
					"autor=?", new String[]{autor}, null, null, null);
		if(cursor.getCount() > 0)
		{
			int count = 1;
			cursor.moveToFirst();
			while(count < cursor.getCount())
			{
				Calculo calculo = new Calculo();
				calculo.setAutor(cursor.getString(2));
				calculo.setData_insercao(cursor.getString(3));
				calculo.setPeso(cursor.getFloat(4));
				calculo.setAltura(cursor.getFloat(5));
				calculo.setImc(cursor.getFloat(6));
				calculos.add(calculo);
				cursor.moveToNext();
				count ++;
			}
			
		}
		
		return calculos;
	}
	
	public void Mensagem(String tituloAlerta, String mensagemAlerta, Context ctx)
	{
		AlertDialog.Builder Mensagem = new AlertDialog.Builder(ctx);
		Mensagem.setTitle(tituloAlerta);
		Mensagem.setMessage(mensagemAlerta);
		Mensagem.setNeutralButton("Ok", null);
		Mensagem.show();
	}
	
}