package com.vidasconcurrentes.pong_vc.pintado;

import com.vidasconcurrentes.pong_vc.juego.Bola;
import com.vidasconcurrentes.pong_vc.juego.Coordenada;
import com.vidasconcurrentes.pong_vc.juego.ElementoPong;
import com.vidasconcurrentes.pong_vc.juego.Raqueta;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PongGameView extends SurfaceView implements SurfaceHolder.Callback {
	
	private PongGameThread paintThread;
	private ElementoPong raquetaIzda;
	private ElementoPong raquetaDcha;
	private ElementoPong bola;

	//Constructor.
	public PongGameView(Context context) {
		super(context);
		//Define this class as handler.
		getHolder().addCallback(this);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}
	
	//Create the thread at the same time as create the SurfaceView (automatically).
	public void surfaceCreated(SurfaceHolder holder) {
		//Create the three elements of the pong.
		raquetaIzda = new Raqueta(new Coordenada(50, getHeight()/2-50), 20, 100);
		raquetaDcha = new Raqueta(new Coordenada(getWidth()-70, getHeight()/2-50), 20, 100);
		bola = new Bola(new Coordenada(getWidth()/2-5, getHeight()/2-5), 10, 10);
		
		//Create the thread that are going to paint on the screen.
		paintThread = new PongGameThread(getHolder(), this);
		paintThread.setRunnning(true);
		paintThread.start();		
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		paintThread.setRunnning(false);
		while (retry) {
			try {
				//The thread finish and wait to finish the principal thread.
				paintThread.join();
				retry = false;
			} catch (InterruptedException e) { }
		}
	}
	
	@Override
	//Where we are going to paint.
	public void onDraw(Canvas canvas) {
			Paint paint = new Paint();
			paint.setColor(Color.WHITE);
			
			canvas.drawColor(Color.BLACK);
			
			//Paint the elements with the color defined on paint.
			canvas.drawRect(raquetaIzda.getRectElemento(), paint);
			canvas.drawRect(raquetaDcha.getRectElemento(), paint);
			canvas.drawRect(bola.getRectElemento(), paint);		
	}
}
