package android.pack.IMC;

import android.pack.IMC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class IMCActivity extends Activity {

	static String pesoValue;
	static String alturaValue;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); //Indica que o main é o xml com o visual.
   
    }
    
    public void clique(View v)
    {
    	final Intent i = new Intent(); //Intanciando uma Intent para troca de telas.
    	i.setClass(this, Resultado.class); // Informando qual será a troca de telas.
    	final EditText Peso = (EditText) findViewById("R.id.editTextPeso");
        final EditText Altura = (EditText) findViewById("R.id.editTextAltura");
    	pesoValue = Peso.getText().toString();
    	alturaValue = Altura.getText().toString();
    	startActivity(i); // Ativando a Intenet i
    	
    }
}