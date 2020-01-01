package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends Entity implements Moveable{
	
	public static final double shooting_distance = 30.0;
	
	public static final int SPEED = 200;
	
	float x,y,direction_x, direction_y; // should be change to vector
	public boolean remove= false;
	
	public Bullet(int health, Texture texture, float x, float y) {
		super(health, texture);
		setX(x);
		setY(y);
		
		if(texture==null)
			texture = new Texture("badlogic.jpg"); // should change the image to bullet image later
	}
	
	public void update(float deltaTime) {
		setX(getX() + SPEED * deltaTime * direction_x);
		setY(getY() + SPEED * deltaTime * direction_y);
		
		if( getY() > Gdx.graphics.getHeight() || getY() < 0 || getX() < 0 || getX() > Gdx.graphics.getWidth()) {
			remove=true;
		}
	}
	
	
	public void render( SpriteBatch batch) {
		batch.draw(getTexture(), getX(), getY());
	}

}
