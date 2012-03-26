package android.pack.IMC;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends Activity {
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.resultado); //Indica que o main é o xml com o visual.
	        
	        final EditText Peso = (EditText) findViewById(R.id.editTextPeso);
			final TextView Altura = (TextView) findViewById(R.id.editTextAltura);
			
	        String pesoValue = Peso.getText().toString();
			String alturaValue = Altura.getText().toString();
			
			float resultado = Float.parseFloat(pesoValue) / (Float.parseFloat(alturaValue) * Float.parseFloat(alturaValue));
			String imc = String.valueOf(resultado);
			
				 }
}
