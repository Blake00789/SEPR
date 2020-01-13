package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends Entity implements Moveable, Attack{
	
	public static final double shooting_distance = 120.0;
	
	private int SPEED = 600;
	
	private float direction_x, direction_y; 
	
	private boolean remove= false;
	float x1;
	float y1;
	
	public int getSpeed() {
		return SPEED;
	}
	
	
	public void setSpeed(int speed) {
		this.SPEED=speed;
	}
	
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
	
	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}
	
	public Bullet(float x, float y ,Texture texture, float direction_x,float  direction_y, int speed) {
		super(texture);
		setDirection_x(direction_x);
		setDirection_y(direction_y);
		setSpeed(speed);
		setX(x);
		setY(y);
	
	}
	
	public Bullet( Texture texture) {
		super(texture);	
		}
	
	
	public void update(float deltaTime) {
		
		setX((float) (getX() + (getDirection_x()* deltaTime * SPEED)));
		setY((float) (getY() + (getDirection_y() * deltaTime * SPEED)));
		
		if( getY() > Gdx.graphics.getHeight() || getY() < 0 || getX() < 0 || getX() > Gdx.graphics.getWidth()) {
			setRemove(true);
		}
	}
	
	
	public void render( SpriteBatch batch) {
		batch.draw(getTexture(), getX(), getY());
	}
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	

}
