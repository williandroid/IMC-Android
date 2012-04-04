package android.pack.IMC;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Historico extends Activity {
	  private TextView view = new TextView(this);
	  private String historico = "";
	  private ArrayList<Calculo> calculos = new ArrayList<Calculo>();
	
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        buscar();
	        relatorio();
	        view.setText(historico);
	        setContentView(view);
	        
	  }
	   
	  public void buscar()
	  {
		  calculos = null;
		  Cursor resposta = Menu.db.query(Menu.NOME_TABELA, new String[] {"_id", "peso", "altura", "imc"},
	    			null, null, null, null, null);
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
	      
	 }
	 
	 public void relatorio()
	 {
		 historico = "";
		 int i;
		 for(i=0; i<calculos.size(); i++)
		 {
			 Calculo aux = calculos.get(i);
			 historico += aux.dadosCalculo();
		 }
	 }
}
