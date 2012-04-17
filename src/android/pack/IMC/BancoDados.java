package android.pack.IMC;

	import java.util.ArrayList;

	import android.app.AlertDialog;
	import android.content.Context;
	import android.database.Cursor;
	import android.database.SQLException;
	import android.database.sqlite.SQLiteDatabase;

	public class BancoDados {

		static final String NOME_BANCO = "IMC";
		static final String NOME_TABELA = "calculos";
		static final String NOME_AUTOR = "Tassio";
		static final String DATA_INSERCAO = "12/01";
		static SQLiteDatabase db;

		public static void criarOuAbrirBanco(Context ctx)
		{
			try{
				db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
			}catch(SQLException e)
			{
				
			}

		}

		public static void criarOuAbrirTabela(Context ctx)
		{
			try{
				db.execSQL("CREATE TABLE IF NOT EXISTS "+ NOME_TABELA + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
						" autor TEXT, data TEXT, peso REAL NOT NULL, altura REAL NOT NULL, imc REAL NOT NULL)");
			}catch(SQLException e)
			{
			}
		}

		public static ArrayList<Calculo> buscar(Context ctx)
		{
			criarOuAbrirBanco(ctx);
			criarOuAbrirTabela(ctx);
			ArrayList<Calculo> calculos = new ArrayList<Calculo>();
			Cursor resposta = db.query(NOME_TABELA, new String[] {"_id", "autor", "data", "peso", "altura", "imc"},
						"data=?", new String[]{"12/01"}, null, null, null);
			if(resposta.getCount() > 0)
			{
				int count = 0;
				resposta.moveToFirst();
				while(count < resposta.getCount())
				{
					Calculo calculo = new Calculo();
					calculo.setData_insercao(resposta.getString(3));
					calculo.setPeso(resposta.getFloat(4));
					calculo.setAltura(resposta.getFloat(5));
					calculo.setImc(resposta.getFloat(6));
					calculos.add(calculo);
					resposta.moveToNext();
					count ++;
				}
				resposta.close();
				db.close();

			}

			return calculos;
		}

		public static void inserir(Context ctx, Float peso, Float altura, Float imc){
			criarOuAbrirBanco(ctx);
			criarOuAbrirTabela(ctx);
			try{
				db.execSQL("INSERT INTO "+ NOME_TABELA + " (data, peso, altura, imc) VALUES ("+DATA_INSERCAO+ ", " + peso + ", " +
						altura + ", "+ imc + ")");
		
			}catch(SQLException e)
			{
			}finally
			{
				db.close();
			}
		}

		public static void Mensagem(String tituloAlerta, String mensagemAlerta, Context ctx)
		{
			AlertDialog.Builder Mensagem = new AlertDialog.Builder(ctx);
			Mensagem.setTitle(tituloAlerta);
			Mensagem.setMessage(mensagemAlerta);
			Mensagem.setNeutralButton("Ok", null);
			Mensagem.show();
		}
}
