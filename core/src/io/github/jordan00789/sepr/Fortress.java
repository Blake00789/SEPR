package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;

public class Fortress extends Entity implements Attack{
	
	
	public Fortress(int health, Texture texture) {
		super(health,texture);

	}

	public Fortress(int health, Texture texture, float x, float y) {
		super(health, texture, x, y);
	}

	public void attack() {
		/*
		 * if( isAlive() && this.distance(getPos()) < shooting_distance){ gunshot(); }
		 */
	}

	public void gunshot() {

	}

	public boolean isAlive() {
 		return (getHealth() > 0);
 	}
	
	public float distanceTo(float farx, float fary) {
		return (float) Math.sqrt((fary - this.getY()) * (fary - this.getY()) + (farx - this.getX()) * (farx - this.getX()));
	}

}
