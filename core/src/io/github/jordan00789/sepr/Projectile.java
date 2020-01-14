package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;
import java.time.Instant;
import java.time.Duration;

public class Projectile extends Entity implements Moveable{
	
	private float direction;
	private float velocity;
	private float lifeTime;
	private Instant startTime;

	
	
	/**
	 * Initialises a projectile using the provided parameters
	 * 
	 * @param x The initial x-coordinate
	 * @param y The initial y-coordinate
	 * @param direction The direction to travel in (in degrees)
	 * @param velocity The velocity to travel at
	 * @param lifeTime The life time of the projectile
	 * @param texture The projectile texture
	 */
	public Projectile(float x, float y, float direction, float velocity, float lifeTime, Texture texture) {
		super(1, texture);
		this.setPosition(x, y);
		this.setScale(0.025f);
		this.direction = direction;
		setRotation(direction);
		this.velocity = velocity;
		this.lifeTime = lifeTime;
		startTime = Instant.now();

		//System.out.printf("Projectile: x=%f, y=%f, direction=%f, v=%f, lifetime=%f%n", x,y,direction,velocity,lifeTime);
	}
	

	@Override
	public void turnLeft() {
		direction--;
	}

	@Override
	public void turnRight() {
		direction++;
	}

	@Override
	public void goForward() {
		velocity++;
	}

	@Override
	public void goBackward() {
		velocity++;
	}

	/** Updates the movement of the projectile.
	 *
	 * @param delta The current delta time.
	 */
	@Override
	public void update(float delta) {
		
		setPosition((float) (getX() + (Math.sin(Math.toRadians(direction)) * delta * velocity)),
				(float) (getY() + (Math.cos(Math.toRadians(direction)) * delta * velocity)));	
		
	}
	
	
	
	public boolean isDisposable() {
		return ((Duration.between(startTime, Instant.now()).getSeconds()) > lifeTime);
		 
	}
	

}
