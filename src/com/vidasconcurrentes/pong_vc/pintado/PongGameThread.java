package com.vidasconcurrentes.pong_vc.pintado;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class PongGameThread extends Thread {
	//Private variables of the class.
	private SurfaceHolder sh;
	private PongGameView view;
	private boolean run;
	
	//Thread constructor.
	public PongGameThread(SurfaceHolder sh, PongGameView view) {
		this.sh = sh;
		this.view = view;
		run = false;
	}
	
	//This method its like a setRun (setter).
	public void setRunnning(boolean run) {
		this.run = run;
	}
	
	@SuppressLint("WrongCall")//This one is because i can't call method onDraw.
	@Override
	public void run() {
		Canvas canvas;
		while (run) {
			canvas = null;
			try {
				canvas = sh.lockCanvas(null);
				synchronized(sh) {
					view.onDraw(canvas);
				}				
			} catch (NullPointerException e) {				
			} finally {
				if(canvas != null) {
					sh.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
}
