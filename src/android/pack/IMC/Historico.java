package android.pack.IMC;


import java.util.ArrayList;
import java.util.HashMap;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class Historico extends ListActivity {

	 ArrayList<HashMap<String,String>> lista = new ArrayList<HashMap<String,String>>();
	 ArrayList<Calculo> calculoArray = new ArrayList<Calculo>();
	
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
			  carregaDados();
			  String[] from = new String[]{"data", "imc"};
			  int [] to = new int[]{android.R.id.text1, android.R.id.text2}; 
			  int layoutNativo = android.R.layout.two_line_list_item;
			  setListAdapter(new SimpleAdapter(this, lista, layoutNativo, from, to));
	                
	  }
	  
	  protected void onListItemClick(ListView l, View v, int position, long id) {
			super.onListItemClick(l, v, position, id);
				Calculo calculo = calculoArray.get(position);
				BancoDados.Mensagem("Tássio", "_id: "+calculo.get_id()+"\n"+
												"Peso: " +calculo.getPeso()+"\n"+
												"Altura: " +calculo.getAltura()+"\n", this);			
		}	
		
	  
	  public void carregaDados()
	  {
		  calculoArray = BancoDados.buscar(this);
		  int count = 0;
		  while(count < calculoArray.size())
		  {
			Calculo calculo = calculoArray.get(count);
			HashMap<String,String> item  = new HashMap<String,String>();
			item.put("autor", BancoDados.NOME_AUTOR);
			item.put("data", String.valueOf(calculo.getData_insercao()));
			item.put("peso", String.valueOf(calculo.getPeso()));
			item.put("altura", String.valueOf(calculo.getAltura()));
			item.put("imc", String.valueOf(calculo.getImc()));
			lista.add(item);
			count ++;
		  }
		  
		  
	  }
}
	  
	 