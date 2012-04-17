package android.pack.IMC;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Historico extends ListActivity {
	 String AUTOR = "Tássio";
	 SimpleCursorAdapter adapter;
	 Cursor cursor;
	 ListView mostraDados;
	 
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.historico);
	        carregaDados();
	                
	  }
	  	  
	  public void carregaDados()
	  {
		  mostraDados = (ListView) findViewById(R.id.listView);
		  if(VerificaRegistro())
		  {
			  
			  String [] coluna = new String[] {"peso", "altura", "imc"};
			  adapter = new SimpleCursorAdapter(this, R.layout.historico, cursor, coluna, new int[] {R.id.historico1, R.id.historico2, R.id.historico3});
			  mostraDados.setAdapter(adapter);
			  
			  
		  }
		  Menu.db.close();
	  }
	   
	  public boolean VerificaRegistro()
	  {
		  Menu.db = openOrCreateDatabase(Menu.NOME_BANCO, MODE_WORLD_READABLE, null);
		  cursor = Menu.db.rawQuery("Select * from calculo", null);
		  
	      if(cursor.getCount() != 0)
	      {
	    		return true;	
	    			
	      }else
	      {
	    	  return false;
	      }      
	 }
}
