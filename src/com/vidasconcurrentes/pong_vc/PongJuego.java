package com.vidasconcurrentes.pong_vc;

import com.vidasconcurrentes.pong_vc.pintado.PongGameView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class PongJuego extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Take off the title of the application.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Put the screen on full screen, take off the notification bar (clock, battery, etc).
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setContentView say what must to show on the screen, in that case we show the SurfaceView PongGameView.
        setContentView(new PongGameView(this));
	}
}
