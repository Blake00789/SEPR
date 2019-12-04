package io.github.jordan00789.sepr;

import java.awt.Point;;

public class Firetruck extends Entity{

	private int water;

	public Firetruck(int health, Point position, int water) {
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