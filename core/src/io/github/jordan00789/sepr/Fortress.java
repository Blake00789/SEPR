package io.github.jordan00789.sepr;

import java.awt.Point;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Fortress extends Entity {
	
	
	public Fortress(int health, Vector2 position , Texture image) {
		 super(health, position, image);		
	}
	
	public Fortress(int health, float x , float y  , Texture image) {
		 super(health, x,y, image);		
	}


  	public boolean isAlive() {
 		return (getHealth() > 0);
 	}


}
