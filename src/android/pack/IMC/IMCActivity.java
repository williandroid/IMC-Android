package android.pack.IMC;

import android.pack.IMC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class IMCActivity extends Activity {

	public String pesoValue; //Atributo que irá conter o valor do EditText de id "R.id.editTextPeso"
	public String alturaValue; //Atributo que irá conter o valor do EditText de id "R.id.editTextAltura" 
	
	//Instanciando a classe Intent
	final Intent i = new Intent();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Inserindo a mudança de Activitys na Intent I
        i.setClass(this, Resultado.class);
        
        
        //Pegando parametros da segunda tela
        Intent a = getIntent();
        final EditText Peso = (EditText) findViewById(R.id.editTextPeso);
        final EditText Altura = (EditText) findViewById(R.id.editTextAltura);
        Peso.setText(a.getStringExtra("peso"));
    	Altura.setText(a.getStringExtra("altura"));

    }
    
    public void clique(View v)
    {
    	//Passando parametros para a outra tela
    	final EditText Peso = (EditText) findViewById(R.id.editTextPeso);
        final EditText Altura = (EditText) findViewById(R.id.editTextAltura);
    	pesoValue = Peso.getText().toString();
    	alturaValue = Altura.getText().toString();
    	i.putExtra("peso", pesoValue);
    	i.putExtra("altura", alturaValue);
    	
    	//Starting a Intent para mudança de tela
    	startActivity(i); 
    	
    }
}