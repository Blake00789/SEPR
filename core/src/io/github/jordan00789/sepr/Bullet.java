package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends Entity implements Moveable, Attack{
	
	public static final double shooting_distance = 120.0;
	
	public static final int SPEED = 300;
	
	private float direction = 0;
	
	private float direction_x, direction_y; 
	public boolean remove= false;
	
	public float getDirection_x() {
		return direction_x;
	}
	
	public void setDirection_x(float direction_x) {
		this.direction_x=direction_x;
		
	}
	
	public float getDirection_y() {
		return direction_y;
	}
	
	public void setDirection_y(float direction_y) {
		this.direction_y=direction_y;
		
	}
	
	public Bullet(Texture texture, float direction_x,float  direction_y) {
		super(texture);
		this.direction_x=direction_x;
		this.direction_y=direction_y;
	
	}
	
	public Bullet( Texture texture) {
		super(texture);	
			}

	
	public void update(float deltaTime) {
		
		setX((float) (getX() + (getDirection_x()* deltaTime * SPEED)));
		setY((float) (getY() + (getDirection_y() * deltaTime * SPEED)));
		
		if( getY() > Gdx.graphics.getHeight() || getY() < 0 || getX() < 0 || getX() > Gdx.graphics.getWidth()) {
			remove=true;
		}
	}
	
	
	public void render( SpriteBatch batch) {
		batch.draw(getTexture(), getX(), getY());
	}
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goForward() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goBackward() {
		// TODO Auto-generated method stub
		
	}

}
