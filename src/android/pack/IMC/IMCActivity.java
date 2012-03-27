package android.pack.IMC;

import android.pack.IMC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class IMCActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); //Indica que o main é o xml com o visual.
        
        
    }
    
    public void clique(View v)
    {
    	final Intent i = new Intent(); //Intanciando uma Intent para troca de telas.
    	i.setClass(this, Resultado.class); // Informando qual será a troca de telas.
    	startActivity(i); // Ativando a Intenet i
    	
    }
}