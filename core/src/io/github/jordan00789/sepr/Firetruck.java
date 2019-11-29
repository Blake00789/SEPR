package io.github.jordan00789.sepr;

import java.util.Vector;

public class Firetruck extends Entity{

	private int water;

	public Firetruck(int health, Vector<Float> position, int water) {
		super(health, position);
		this.water = water;
	}

	public int getWater() {
		return water;
	}

	private void setWater(int volume) {
		this.water = volume;
	}

	public void refill() {

	}

}