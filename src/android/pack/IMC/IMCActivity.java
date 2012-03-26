package android.pack.IMC;

import android.pack.IMC.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IMCActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); //Indica que o main é o xml com o visual.
        
        final EditText Peso = (EditText) findViewById(R.id.editTextPeso);
		final TextView Altura = (TextView) findViewById(R.id.editTextAltura);
		final TextView resultadoExibir = (TextView) findViewById(R.id.textViewResultado);
		final Button button = (Button) findViewById(R.id.buttonCalcular);
		
		button.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String pesoValue = Peso.getText().toString();
				String alturaValue = Altura.getText().toString();
				
				float resultado = Float.parseFloat(pesoValue) / (Float.parseFloat(alturaValue) * Float.parseFloat(alturaValue));
				String imc = String.valueOf(resultado);
				
				
				resultadoExibir.setText("Seu IMC é: " + imc);//Set o resultado no textView de ID textViewResultado
			}
		});
		
		
		
		

    }
}