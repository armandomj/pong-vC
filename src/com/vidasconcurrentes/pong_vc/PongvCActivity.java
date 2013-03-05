package com.vidasconcurrentes.pong_vc;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class PongvCActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quitamo el título de la aplicación.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Ponemos la pantalla completa.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pongv_c);
        
    	//Creamo la variable que contiene el area que usaremos como boton de Jugar.
    	TextView play = (TextView)findViewById(R.id.play_button);
    	play.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), R.string.menu_play, Toast.LENGTH_SHORT).show();				
			}
		});
    	
    }
}
