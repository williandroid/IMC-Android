package android.pack.IMC;

import android.pack.IMC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class IMCActivity extends Activity {

	public String pesoValue;
	public String alturaValue;
	
	final Intent i = new Intent();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        i.setClass(this, Resultado.class);
        
    }
    
    public void clique(View v)
    {
    	final EditText Peso = (EditText) findViewById(R.id.editTextPeso);
        final EditText Altura = (EditText) findViewById(R.id.editTextAltura);
    	pesoValue = Peso.getText().toString();
    	alturaValue = Altura.getText().toString();
    	i.putExtra("peso", pesoValue);
    	i.putExtra("altura", alturaValue);
    	startActivity(i); 
    	
    }
}