package android.pack.IMC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.pack.IMC.IMCActivity;

public class Resultado extends Activity {
	 
	 Float imcValue;
	 final Intent a = new Intent();
	 
	 public void onCreate(Bundle Resultado) {
	        super.onCreate(Resultado);
	        setContentView(R.layout.resultado); //Indica que o main é o xml com o visual.
	        a.setClass(this, IMCActivity.class);
	        
	    	final TextView ResultadoAltura = (TextView) findViewById(R.id.textViewResultAltura);
	    	final TextView ResultadoPeso = (TextView) findViewById(R.id.textViewResultPeso);
	    	final TextView ResultadoIMC = (TextView) findViewById(R.id.textViewResultIMC);
	    	final TextView ResultadoStatus = (TextView) findViewById(R.id.textViewResultStatus);
	    	final TextView ResultadoSugestao = (TextView) findViewById(R.id.textViewResultConselho);
	    	Intent it = getIntent();
	    	String Peso = it.getStringExtra("peso");
	    	String Altura = it.getStringExtra("altura");
	        
	    	
	        imcValue = Float.parseFloat(Peso)/(Float.parseFloat(Altura) * Float.parseFloat(Altura));			
			ResultadoAltura.setText("Altura: "+ Altura);
			ResultadoPeso.setText("Peso: " + Peso);
			ResultadoIMC.setText("IMC: " + imcValue);
			ResultadoStatus.setText("Status: ");
	       
			
	 }
	 
	 public void voltar(View v)
	 {
		 startActivity(a);
	 }
	 
}
