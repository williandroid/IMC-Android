package android.pack.IMC;

import android.pack.IMC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class IMCActivity extends Activity {

	//Instanciando a classe Intent
	public String pesoValue; // Atributo que receberá o valor que está dentro do componente EditText de id "R.id.editTextPeso".
	public String alturaValue; // Atributo que receberá o valor que está dentro do componente EditText de id "R.id.editTextaltura".
	
	//Intent que receberá a troca de telas (Desta para a tela de resultado) .
	final Intent i = new Intent();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Inserindo a mudança de Activitys na Intent I
        i.setClass(this, Resultado.class);
        
    }
    
    public void clique(View v)
    {
    
    	//Instanciando os componentes do Layout.
    	final EditText Peso = (EditText) findViewById(R.id.editTextPeso);
        final EditText Altura = (EditText) findViewById(R.id.editTextAltura);
        
        //Passagem de parâmetros para a tela de resultados através da Intent.
    	pesoValue = Peso.getText().toString();
    	alturaValue = Altura.getText().toString();
    	i.putExtra("peso", pesoValue);
    	i.putExtra("altura", alturaValue);
    	
    	//Starting a Intent para mudança de tela
    	onPause();
    	startActivity(i); 
    	
    }
}