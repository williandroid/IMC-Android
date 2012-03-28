package android.pack.IMC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends Activity {
	 
	 Float imcValue;
	
	 public void onCreate(Bundle Resultado) {
	        super.onCreate(Resultado);
	        setContentView(R.layout.resultado); //Indica que o main é o xml com o visual.

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
	 
}
