package android.pack.IMC;

import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu  extends ListActivity{
	
	//Banco de Dados
	public static SQLiteDatabase db= null;
	public static final String NOME_BANCO = "IMC";
	public static final String NOME_TABELA = "calculo";
	public static final String AUTOR = "Tassio";
	public static final String DATA = "00/00";	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final String[] itens = new String[] {"Novo Cálculo", "Histórico", "Sair"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Object o = this.getListAdapter().getItem(position);
		String item = o.toString();
		if(item == "Novo Cálculo")
		{
			final Intent i = new Intent(this, IMCActivity.class);
			startActivity(i); 
		}
	}
	
	
}
