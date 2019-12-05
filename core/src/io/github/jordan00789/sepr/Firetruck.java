package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;

public class Firetruck extends Entity implements Moveable {

	private int water;
	private int maxWater;
	float acceleration = 0.1f;
	float deceleration = 2;
	float xvelocity, yvelocity;

	private static int range = 10;
	private static int flowRate = 5;

	public Firetruck(int health, int maxWater, Texture texture) {
		super(health, texture);
		this.maxWater = water = maxWater;
		System.out.println("hello world!");
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
		System.out.println("water is " + water);
		if (amount <= water && amount > 0) {
			water -= amount;
		}
	}
	
	public void changeXSpeed(float amount) {
		//System.out.println("xvelocity is"+xvelocity);
		xvelocity += amount;
	}
	
	public void changeYSpeed(float amount) {
		//System.out.println("yvelocity is"+yvelocity);
		yvelocity += amount;
	}


}