package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
	
	public static final double shooting_distance = 30.0;
	
	public static final int SPEED = 200;
	public static Texture texture; 
	
	float x,y,direction_x, direction_y; // should be change to vector 
	Vector2 vec = new Vector2( x,  y);
	public boolean remove= false;
	
	public Bullet(float x , float y) {
		vec.x=x;
		vec.y=y;
		
		if(texture==null)
			texture = new Texture("badlogic.jpg"); // should change the image to bullet image later
	}
	
	public void update(float deltaTime) {
		vec.x += SPEED * deltaTime * direction_x;
		vec.y += SPEED * deltaTime * direction_y;
		
		if( vec.y > Gdx.graphics.getHeight() || vec.y < 0 || vec.x < 0 || vec.x > Gdx.graphics.getWidth()) {
			remove=true;
		}
	}
	
	
	public void render( SpriteBatch batch) {
		batch.draw(texture, vec.x, vec.y);
	}

}
