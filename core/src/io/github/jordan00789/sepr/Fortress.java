package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;

public class Fortress extends Entity implements Attack{
	
	public static final double shooting_distance = 10.0;    
	
	public Fortress(int health, Texture texture) {
		super(health,texture);
		
	}
	
	public boolean isAlive() {
		return (getHealth() > 0);
	}

	public void attack() {
		/*if( isAlive() && this.distance(getPos()) < shooting_distance){
			gunshot();
		}*/
	}
	
	public void gunshot() {
		
	}

}
