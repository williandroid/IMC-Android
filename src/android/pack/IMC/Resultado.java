package android.pack.IMC;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.pack.IMC.IMCActivity;

public class Resultado extends Activity {
	    	
	 Float imcValue;  // Atributo que receberá o resultado do IMC.
	 Float pesoFloat;
	 Float alturaFloat;
	 
	 //Instâncias para formatações
 	 final DecimalFormat formatoPeso = new DecimalFormat("00.0");
 	 final DecimalFormat formatoAltura = new DecimalFormat("0.00");
 	 final DecimalFormat formatoIMC = new DecimalFormat("00.00");
 	
	 //Intent que receberá a troca de telas (Desta para a tela principal) .
	 final Intent a = new Intent();
	 
	 public void onCreate(Bundle Resultado) {
	        super.onCreate(Resultado);
	        setContentView(R.layout.resultado); //Indica que o main é o xml com o visual.	        
	        
	        CriarBanco();
	        
	        a.setClass(this, IMCActivity.class); //Passando referência da troca de telas para o objeto a da classe intent.
	        
	        //Instanciando os componentes do Layout.
	    	final TextView ResultadoAltura = (TextView) findViewById(R.id.textViewResultAltura);
	    	final TextView ResultadoPeso = (TextView) findViewById(R.id.textViewResultPeso);
	    	final TextView ResultadoIMC = (TextView) findViewById(R.id.textViewResultIMC);
	    	final TextView ResultadoStatus = (TextView) findViewById(R.id.textViewResultStatus);	   
	    	
	    	//Pegando os parâmetros passados da primeira activity para esta.
	    	Intent it = getIntent();
	    	String Peso = it.getStringExtra("peso");
	    	String Altura = it.getStringExtra("altura");
	    	
	    	//Formatando os campos Peso e Altura
	    	pesoFloat = Float.parseFloat(Peso);
	    	alturaFloat = Float.parseFloat(Altura);
	    	Peso = formatoPeso.format(pesoFloat);
	    	Altura = formatoAltura.format(alturaFloat);
	    	
	    	//Achando o valor do IMC e formatando o valor
	        imcValue = Float.parseFloat(Peso)/(Float.parseFloat(Altura) * Float.parseFloat(Altura)); 
	        String imc = formatoIMC.format(imcValue);
	               
	        //Inserindo nos componentes de tipo TextView os resultados.
			ResultadoAltura.setText("Altura: "+ Altura + " m");
			ResultadoPeso.setText("Peso: " + Peso + " Kg");
			ResultadoIMC.setText("IMC: " + imc);
			ResultadoStatus.setText("Status: " + StatusIMC(imcValue));
			Sugestao(Float.parseFloat(Peso), Float.parseFloat(Altura), imcValue);
	       
			
	 }
	 

	 public void voltar(View v) //Método que responde ao click do botão "novo cálculo" .
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
	 
	 public void Sugestao(Float Peso, Float Altura, Float imc)
	 {
		 final TextView ResultadoSugestao = (TextView) findViewById(R.id.textViewResultConselho); 
		 Float paramPeso = Peso; 
		 
		 if(imc > 24.9)
		 {
			 while(true)
			 {
				 imc = Peso / (Altura * Altura);
				 if(imc < 24.9)
					 break;
				 Peso = (float) (Peso - 0.1);
			 }
		 }else if(imc < 18.5)
		 {
			 while(true)
			 {
				 imc = Peso / (Altura * Altura);
				 if(imc > 18.5)
					 break;
				 Peso = (float) (Peso + 0.1);
			 }
		 }
		 
		 Float perder = paramPeso - Peso;
		 Float ganhar = Peso - paramPeso;
		 String perderPeso = formatoPeso.format(perder);
		 String ganharPeso = formatoPeso.format(ganhar);
		 String pesoFormatado = formatoPeso.format(Peso);
		 
		 if(Peso != paramPeso)
		 {
			 if(Peso < paramPeso)
			 	ResultadoSugestao.setText("Sugestão: Seu peso deveria ser no máximo "+ pesoFormatado + " Kg.\nVocê deve perder " + perderPeso + " Kg.");
			 else
				ResultadoSugestao.setText("Sugestão: Seu peso deveria ser no mínimo "+ pesoFormatado + " Kg.\nVocê deve ganhar " + ganharPeso + " Kg.");
		 }
	}
	 
	public void Gravar(View v)
	{
		try
		{
			Menu.db = openOrCreateDatabase(Menu.NOME_BANCO, MODE_WORLD_READABLE, null);
			Menu.db.execSQL("INSERT INTO "+ Menu.NOME_TABELA + " (peso, altura, imc) VALUES (" + pesoFloat + ", " +
					alturaFloat + ", "+ imcValue + ")");
			final Intent i = new Intent(this, Menu.class);
			startActivity(i); 
			Mensagem("Sucesso", "Salvo com sucesso!", this);
		}catch(SQLException e)
		{
			Mensagem("Error", "Falha ao tentar salvar", this);
		}
	}
	
	public void CriarBanco()
	{
		try
		{
			Menu.db = openOrCreateDatabase(Menu.NOME_BANCO, MODE_WORLD_READABLE, null);
			Menu.db.execSQL("CREATE TABLE IF NOT EXISTS "+ Menu.NOME_TABELA + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT,"+
					" autor TEXT, data TEXT, peso REAL NOT NULL, altura REAL NOT NULL, imc REAL NOT NULL )");
		
		}catch(SQLException e)
		{
			
		}
	}
	
	public void Mensagem(String tituloAlerta, String mensagemAlerta, Context ctx)
	{
		AlertDialog.Builder Mensagem = new AlertDialog.Builder(ctx);
		Mensagem.setTitle(tituloAlerta);
		Mensagem.setMessage(mensagemAlerta);
		Mensagem.setNeutralButton("Ok", null);
		Mensagem.show();
	}
		
}
