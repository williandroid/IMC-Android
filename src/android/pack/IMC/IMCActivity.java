package android.pack.IMC;

import android.pack.IMC.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class IMCActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); //Indica que o main é o xml com o visual.
        
        final Button button = (Button) findViewById(R.id.buttonCalcular);
		
		button.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				setContentView(R.layout.resultado);
			}
		});
		
		
		
		

    }
}