package android.pack.IMC;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends Activity {
	
	 public void onCreate(Bundle Resultado) {
	        super.onCreate(Resultado);
	        setContentView(R.layout.resultado); //Indica que o main é o xml com o visual.
	        
	        final EditText Peso = (EditText) findViewById(R.id.editTextPeso);
			final EditText Altura = (EditText) findViewById(R.id.editTextAltura);
			final TextView ResultadoAltura = (TextView) findViewById(R.id.textViewResultAltura);
			final TextView ResultadoPeso = (TextView) findViewById(R.id.textViewResultPeso);
			final TextView ResultadoIMC = (TextView) findViewById(R.id.textViewResultIMC);
			final TextView ResultadoStatus = (TextView) findViewById(R.id.textViewResultStatus);
			final TextView ResultadoSugestao = (TextView) findViewById(R.id.textViewResultConselho);
			
			
	        String pesoValue = Peso.getText().toString();
			String alturaValue = Altura.getText().toString();
			float resultado = Float.parseFloat(pesoValue) / (Float.parseFloat(alturaValue) * Float.parseFloat(alturaValue));
			String imc = String.valueOf(resultado);
			ResultadoAltura.setText("Altura: "+alturaValue);
			ResultadoPeso.setText("Peso: "+pesoValue);
			ResultadoIMC.setText("IMC: "+imc);
			
			
	 }
}