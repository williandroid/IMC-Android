package android.pack.IMC;


import android.app.ListActivity;
import android.content.Intent;
<<<<<<< HEAD
=======
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
>>>>>>> new_branch_name
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu  extends ListActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final String[] itens = new String[] {"Novo Cálculo", "Histórico", "Sair"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
		setListAdapter(adapter);
		CriarBanco();
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Object o = this.getListAdapter().getItem(position);
		String item = o.toString();
		if(item == "Novo Cálculo")
		{
			Intent i = new Intent(this, IMCActivity.class);
			startActivity(i); 
		}else if(item == "Histórico")
		{
			Intent j = new Intent(this, Historico.class);
			startActivity(j); 
		}
	}
	
	public void CriarBanco()
	{
		try
		{
			Menu.db = openOrCreateDatabase(Menu.NOME_BANCO, MODE_WORLD_READABLE, null);
			Menu.db.execSQL("CREATE TABLE IF NOT EXISTS "+ Menu.NOME_TABELA + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT,"+
					" autor TEXT, data TEXT, peso REAL NOT NULL, altura REAL NOT NULL, imc REAL NOT NULL )");
		
		}catch(SQLException e)
		{
			
		}finally
		{
			Menu.db.close();
		}
	}
	
	
}
