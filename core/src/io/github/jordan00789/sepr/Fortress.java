package io.github.jordan00789.sepr;

import java.util.Vector;



public class Fortress extends Entity implements Attack{
	
	public static final double shooting_distance = 10.0;    
	
	public Fortress(int health, Vector<Float> position) {
		super(health, position);
		
	}
	
	public boolean isAlive() {
		return (getHealth() > 0);
	}

	public void attack() {
		if( isAlive() && this.distance(getPos()) < shooting_distance){
			gunshot();
		}
	}
	
	public void gunshot() {
		
	}

}
