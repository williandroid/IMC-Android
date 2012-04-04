package android.pack.IMC;


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Historico extends Activity {
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
			  adapter = new SimpleCursorAdapter(this, R.layout.historico, cursor, coluna, new int[] {R.id.historico});
			  mostraDados.setAdapter(adapter);
		  }
	  }
	   
	  public boolean VerificaRegistro()
	  {
		  Menu.db = openOrCreateDatabase(Menu.NOME_BANCO, MODE_WORLD_READABLE, null);
		  cursor = Menu.db.rawQuery("Select * from calculo", null);
		  
	      if(cursor.getCount() != 0)
	      {
	    	  	cursor.moveToFirst();
	    		return true;	
	    			
	      }else
	      {
	    	  return false;
	      }      
	 }
}
