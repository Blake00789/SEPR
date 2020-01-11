package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;
import java.time.*;

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
	 * @param texture The projectile texture
	 * @param lifeTime The life time of the projectile
	 */
	public Projectile(float x, float y, float direction, float velocity, float lifeTime, Texture texture) {
		super(1, texture);
		this.setPosition(x, y);
		this.setScale(0.1f);
		this.direction = direction;
		this.velocity = velocity;
		this.lifeTime = lifeTime;
		System.out.println("oof");
		startTime = Instant.now();
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

	@Override
	public void update(float delta) {
		setPosition((float) (getX() + (Math.sin(Math.toRadians(direction)) * delta * velocity)),
				(float) (getY() + (Math.cos(Math.toRadians(direction)) * delta * velocity)));
	}
	
	public boolean isDispose() {
		return ((Duration.between(startTime, Instant.now()).getSeconds()) > lifeTime);
	}
	

}
