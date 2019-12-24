package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Firetruck extends Entity implements Moveable,Attack {

	private int water;
	private int maxWater;
	float acceleration = 0.1f;
	float deceleration = 2;
	private int direction = 0;
	private float velocity = 0;

	private static int range = 10;
	private static int flowRate = 5;

	public Firetruck(int health, int maxWater, Texture texture) {
		super(health, texture);
		this.maxWater = water = maxWater;
	}

	public int getWater() {
		return water;
	}

	private void setWater(int amount) {
		if (amount <= maxWater && amount > 0) {
			water = amount;
		}
	}

	public void refill() {
		setWater(maxWater);
	}

	public void takeWater(int amount) {
		if (amount <= water && amount > 0) {
			water -= amount;
		}
	}
	
	private void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	
	private void setVelocity(float velocity) {
		this.velocity = velocity;
	}
	
	public float getVelocity() {
		return velocity;
	}
	
	public void turnLeft() {
		if (getDirection() == 0) {
			setDirection(360);
		} else {
			setDirection(getDirection()-1);
		}
	}

	public void turnRight() {
		if (getDirection() == 360) {
			setDirection(0);
		} else {
			setDirection(getDirection()+1);
		}
	}
	
	public void goForward() {
		setVelocity(getVelocity()+acceleration);
	}
	
	public void goBackward() {
		setVelocity(getVelocity()-acceleration);
	}
	
	public void update(float delta) {
		setX((float)((getX() + Math.sin(direction))*delta*velocity));
		setY((float)((getY() + Math.cos(direction))*delta*velocity));
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}


}