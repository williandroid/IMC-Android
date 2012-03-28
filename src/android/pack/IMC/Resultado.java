package android.pack.IMC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends Activity {
		
	 public void onCreate(Bundle Resultado) {
	        super.onCreate(Resultado);
	        setContentView(R.layout.resultado); //Indica que o main é o xml com o visual.

	    	final TextView ResultadoAltura = (TextView) findViewById(R.id.textViewResultAltura);
	    	final TextView ResultadoPeso = (TextView) findViewById(R.id.textViewResultPeso);
	    	final TextView ResultadoIMC = (TextView) findViewById(R.id.textViewResultIMC);
	    	final TextView ResultadoStatus = (TextView) findViewById(R.id.textViewResultStatus);
	    	final TextView ResultadoSugestao = (TextView) findViewById(R.id.textViewResultConselho);
	    	Float imcValue;

	        
	        imcValue = Float.parseFloat(IMCActivity.pesoValue)/(Float.parseFloat(IMCActivity.alturaValue) * Float.parseFloat(IMCActivity.alturaValue));			
			ResultadoAltura.setText("Altura: "+ IMCActivity.alturaValue);
			ResultadoPeso.setText("Peso: " + IMCActivity.pesoValue);
			ResultadoIMC.setText("IMC: " + imcValue);
			ResultadoStatus.setText("Status: ");
	       
			
	 }
	 
}
