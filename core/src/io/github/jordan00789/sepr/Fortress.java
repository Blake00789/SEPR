package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;

public class Fortress extends Entity implements Attack{
	
	
	public Fortress(int health, Texture texture) {
		super(health,texture);
		
	}
	
	public Fortress(int health, float x, float y, Texture texture) {
		 super(health, x, y, texture);		
	}

	public void attack() {
		/*if( isAlive() && this.distance(getPos()) < shooting_distance){
			gunshot();
		}*/
	}
	
	public void gunshot() {
		
	}

  	public boolean isAlive() {
 		return (getHealth() > 0);
 	}

}
