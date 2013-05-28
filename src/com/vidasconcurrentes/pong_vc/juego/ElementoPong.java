package com.vidasconcurrentes.pong_vc.juego;

import android.graphics.Rect;

//This class it is abstract so we can't instantiate objects from this class,
//we must create class that inherit from this.
public abstract class ElementoPong {
	//Variables of the class.
	protected Coordenada origen;
	protected int ancho;
	protected int alto;
	
	//Constructor.
	public ElementoPong(Coordenada origen, int ancho, int alto) {
		this.origen = origen;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public int getOrigenX() {
		return origen.getX();
	}
	
	public int getOrigenY() {
		return origen.getY();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	//Function that create a rectangle.
	public Rect getRectElemento() {
		return new Rect(getOrigenX(), getOrigenY(), getOrigenX() + ancho, getOrigenY() + alto);
	}
}
