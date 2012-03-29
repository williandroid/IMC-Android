package android.pack.IMC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.pack.IMC.IMCActivity;

public class Resultado extends Activity {
	 
	 Float imcValue;
	 final Intent a = new Intent();
	 
	 public void onCreate(Bundle Resultado) {
	        super.onCreate(Resultado);
	        setContentView(R.layout.resultado); //Indica que o main é o xml com o visual.
	        a.setClass(this, IMCActivity.class);
	        
	    	final TextView ResultadoAltura = (TextView) findViewById(R.id.textViewResultAltura);
	    	final TextView ResultadoPeso = (TextView) findViewById(R.id.textViewResultPeso);
	    	final TextView ResultadoIMC = (TextView) findViewById(R.id.textViewResultIMC);
	    	final TextView ResultadoStatus = (TextView) findViewById(R.id.textViewResultStatus);
	    	Intent it = getIntent();
	    	String Peso = it.getStringExtra("peso");
	    	String Altura = it.getStringExtra("altura");
	        
	    	
	        imcValue = Float.parseFloat(Peso)/(Float.parseFloat(Altura) * Float.parseFloat(Altura));			
			ResultadoAltura.setText("Altura: "+ Altura + " metros");
			ResultadoPeso.setText("Peso: " + Peso + " quilos");
			ResultadoIMC.setText("IMC: " + imcValue);
			ResultadoStatus.setText("Status: " + StatusIMC(imcValue));
			Sugestao(Float.parseFloat(Peso), Float.parseFloat(Altura));
	       
			
	 }
	 
	 public void voltar(View v)
	 {
		 startActivity(a);
	 }
	 
	 public String StatusIMC(Float imc)
	 {
		 String msg = "";
		 if(imc < 40.0)
		 {
			 if(imc < 18.5)
				 msg = "Abaixo do Peso.";
			 else if (imc < 24.9)
				 msg = "Saudável";
			 else if (imc < 29.9)
				 msg = "Peso em Excesso";
			 else if (imc < 34.9)
				 msg = "Obesidade Grau I";
			 else if (imc < 39.9)
				 msg = "Obesidade Grau II";
		 }else
			 msg = "Obesidade Grau III";
		 
		 return msg;
	 }
	 
	 public void Sugestao(Float Peso, Float Altura)
	 {
		 final TextView ResultadoSugestao = (TextView) findViewById(R.id.textViewResultConselho); 
		 Float imc;
		 Float paramPeso = Peso;
		 
		 while(true)
		 {
			 imc = Peso / (Altura * Altura);
			 if(imc > 18.5 && imc < 24.9)
				 break;
			 Peso = (float) (Peso - 0.1);
		 }
		 if(Peso != paramPeso)
		 {
			 if(Peso < paramPeso)
			 	ResultadoSugestao.setText("Sugestão: \nSeu peso deveria ser "+ Peso + "\nVocê deve perder " + (paramPeso-Peso)+ " quilos");
			 else
				ResultadoSugestao.setText("Sugestão: \nSeu peso deveria ser "+ Peso + "\nVocê deve ganhar " + (Peso-paramPeso) + " quilos");
		 }
	}
}
