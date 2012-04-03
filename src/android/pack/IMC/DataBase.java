package android.pack.IMC;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBase {

	private static final String NOME_BANCO = "IMC";
	private static final String NOME_TABELA = "calculos";
	private final SQLiteDatabase db;
	
	public DataBase(Context ctx)
	{
		db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
	}
	
	public String buscar(String autor)
	{
		Cursor resposta = db.query(NOME_TABELA, new String[] {"_id", "autor", "data", "peso", "altura", "imc"}, "autor=?", new String[]{autor}, null, null, null);
		if(resposta.getCount() > 0)
		{
			
		}
		return "";
	}	
}
