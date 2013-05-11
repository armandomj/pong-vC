package com.vidasconcurrentes.pong_vc;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PongvCActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quitamo el título de la aplicación.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Ponemos la pantalla completa, quitamos barra de notificaciones.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pongv_c);
        
    	//Creamos la variable que contiene el area que usaremos como boton de Jugar.
    	TextView play = (TextView)findViewById(R.id.play_button);
    	play.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), R.string.menu_play, Toast.LENGTH_SHORT).show();				
			}
		});
    	
    	//Ahora creamos la que contiene el boton de opciones.
    	TextView options = (TextView)findViewById(R.id.options_button);
    	options.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), R.string.menu_options, Toast.LENGTH_SHORT).show();				
			}
		});
    	
    	//Ahora el del que contiene el boton de salir.
    	TextView exit = (TextView)findViewById(R.id.exit_button);
    	exit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), R.string.menu_exit, Toast.LENGTH_SHORT).show();				
			}
		});
    	
    	//Cuando se pulsa la imagen se abre el navegador y carga la dirección de la web.
    	ImageView logo = (ImageView)findViewById(R.id.imageView1);
    	logo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("htttp://www.vidasconcurrentes.com"));
				startActivity(viewIntent);
			}
		});
    }
}
