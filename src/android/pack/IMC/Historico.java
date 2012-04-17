package android.pack.IMC;


import java.util.ArrayList;
import java.util.HashMap;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;


public class Historico extends ListActivity {
	 /*String AUTOR = "Tássio";
	 SimpleCursorAdapter adapter;
	 Cursor cursor;
	 ListView mostraDados;
	 */
	 ArrayList<HashMap<String,String>> lista = new ArrayList<HashMap<String,String>>();
	 ArrayList<Calculo> calculos = new ArrayList<Calculo>();
	
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        //setContentView(R.layout.historico);
	        exibirDados();
	                
	  }
	  
	  public void carregaDados()
	  {
		  BancoDados.criarOuAbrirBanco(this);
		  BancoDados.criarOuAbrirTabela(this);
		  calculos = BancoDados.buscar(this);
		  
		  int count = 1;
		  while(count <= calculos.size())
		  {
			Calculo calculo = calculos.get(count);
			HashMap<String,String> item  = new HashMap<String,String>();
			item.put("autor", "Tássio");
			item.put("data", "00/00");
			item.put("peso", String.valueOf(calculo.getPeso()));
			item.put("altura", String.valueOf(calculo.getAltura()));
			item.put("imc", String.valueOf(calculo.getImc()));
			lista.add(item);
			count ++;
		  }
		  
	  }
	  
	  public void exibirDados()
	  {
		  carregaDados();
		  String[] from = new String[]{"autor", "data", "peso", "altura", "imc"};
		  int [] to = new int[]{android.R.id.text1, android.R.id.text2, android.R.id.text2, android.R.id.text2, android.R.id.text2}; 
		  int layoutNativo = android.R.layout.two_line_list_item;
		  setListAdapter(new SimpleAdapter(this, lista, layoutNativo, from, to));

	  }
	  
	  
	/*  public void carregaDados()
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
	 }*/
}
