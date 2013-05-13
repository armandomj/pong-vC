package com.vidasconcurrentes.pong_vc.pintado;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PongGameView extends SurfaceView implements SurfaceHolder.Callback {
	
	private PongGameThread paintThread;

	//Constructor.
	public PongGameView(Context context) {
		super(context);
		//Define this class as handler.
		getHolder().addCallback(this);
	}
	
	@Override
	//Where we are going to paint.
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}
	
	//Create the thread at the same time as create the SurfaceView (automatically).
	public void surfaceCreated(SurfaceHolder holder) {
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
}
