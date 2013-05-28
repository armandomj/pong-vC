package com.vidasconcurrentes.pong_vc.juego;

public class Coordenada {
	//Private variables.
	private int x;
	private int y;
	
	//Constructor.
	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//getter and setter.
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
