package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class Firetruck extends Entity implements Moveable, Attack {

	private int water;
	private int maxWater;
	private float acceleration = 2;
	private float deceleration = 0.5f;
	private float direction = 0;
	private float velocity = 0;
	private Pixmap map = new Pixmap(Gdx.files.internal("map.png"));
	private Pixmap speedMap;
	
	// These will be used in the attack method
	private static int range = 10;
	private static int flowRate = 5;

	/**
	 * Creates a Firetruck sprite using the texture provided, with the specified
	 * amounts of health and water.
	 * 
	 * @param health   The amount of health the truck has.
	 * @param maxWater The maximum amount of water in the truck.
	 * @param texture  The texture given to the Firetruck sprite.
	 */
	public Firetruck(int health, int maxWater, Texture texture) {
		super(health, texture);
		this.maxWater = water = maxWater;
		speedMap = new Pixmap(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), map.getFormat());
		speedMap.drawPixmap(map, 0, 0, map.getWidth(), map.getHeight(), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	/** @return The truck's current amount of water. */
	public int getWater() {
		return water;
	}

	/**
	 * Sets the amount of water in the truck if the amount is valid.
	 * 
	 * @param amount The amount that the water variable is set to.
	 */
	private void setWater(int amount) {
		if (amount <= maxWater && amount > 0) { 
			water = amount;
		}
	}

	/**
	 * Removes the specified amount of water from the truck.
	 * 
	 * @param amount The amount of water removed from the truck.
	 */
	public void takeWater(int amount) {
		if (amount <= water && amount > 0) {
			water -= amount;
		}
	}

	/**
	 * Refills the truck to the maximum amount of water.
	 */
	public void refill() {
		setWater(maxWater);
	}

	/**
	 * Sets the trucks direction.
	 * 
	 * @param direction The value in degrees the truck's direction is set to.
	 * @throws RuntimeException If the value is invalid, a runtime exception is
	 *                          thrown.
	 */
	private void setDirection(float direction) {
		this.direction = direction;
	}

	/** @return The truck's current direction. */
	public float getDirection() {
		return direction;
	}

	/**
	 * Sets the truck's velocity.
	 * 
	 * @param velocity The value the velocity is set to.
	 */
	private void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	/** @return The truck's current velocity. */
	public float getVelocity() {
		return velocity;
	}

	/** Turns the truck left. */
	public void turnLeft() {
		if (getDirection() <= 0) {
			setDirection(360);
		} else {
			setDirection(getDirection() - getTurnSpeed());
		}
	}

	/** Turns the truck right. */
	public void turnRight() {
		if (getDirection() >= 360) {
			setDirection(0);
		} else {
			setDirection(getDirection() + getTurnSpeed());
		}
	}

	/**
	 * Calculates the current turning radius of the truck.
	 * 
	 * @return Turning speed.
	 */
	private float getTurnSpeed() {
		if (velocity > 50f) {
			return (400f / velocity);
		} else {
			return 8f;
		}
	}

	/** Moves the truck forward. */
	public void goForward() {
		float maxSpeed = speedLimit();
		if (velocity < maxSpeed) {
			setVelocity(getVelocity() + acceleration);
		}
	}

	/** Moves the truck backward. */
	public void goBackward() {
		float maxSpeed = speedLimit();
		if (velocity > -maxSpeed) {
			setVelocity(getVelocity() - acceleration);
		}
	}

	/**
	 * Updates the truck's position and rotation.
	 * 
	 * @param delta The current delta time.
	 * @param maxspeed The maximum speed the truck can reach.
	 */
	@Override
	public void update(float delta) {
		if (velocity > 0.01f) {
			velocity -= deceleration;
		} else if (velocity < -0.01f) {
			velocity += deceleration;
		} else {
			velocity = 0;
		}
		
		setRotation(-direction);
		setX((float) (getX() + (Math.sin(Math.toRadians(direction)) * delta * velocity)));
		setY((float) (getY() + (Math.cos(Math.toRadians(direction)) * delta * velocity)));
	}
	
	private float speedLimit() {
		/*
		 * TODO
		 * Fix the colours underneath the truck
		 * 
		 */
		int pixcolour = speedMap.getPixel(Math.round(getX()+265), Gdx.graphics.getHeight()-Math.round(getY()+256));
		/*Convert our interger to a hex value represented as a string (the mask value removes the last 4 digits of each
		color */
		String col = "#"+Integer.toHexString(pixcolour & 15790320);
		if(col.length()>5) {
			col = col.substring(0, 7);
		}
		/*for(int i = 1; i < col.length(); i++) {
			if(i%2 == 0) {
				
			}
		}*/
		//System.out.println(col);
		switch(col) {
		case("#f0cd7d")://buildings
			return 100f;
		case("#f1cf7b")://buildings
			return 100f;
		case("edfee8")://grass
			return 40f;
		case("#cfffc1")://grass 2
			return 40f;
		case("#d0ffc1")://grass 3
			return 40f;
		case("#926650")://wall
			setVelocity(-5f);
		case("#916650")://wall 2
			setVelocity(-5f);
			return 0f;
		case("#b0e9ff")://water
			setVelocity(-5f);
			return 0f;
		default:
			return 200f;
		}
		//return 200f;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

}
