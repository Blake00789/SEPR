package io.github.jordan00789.sepr;

import java.awt.Point;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Firetruck extends Entity/*implements Moveable*/{

	private int water;
	private int volume;//could change to maxWater
	
	private static int range = 10;
	private static int flowRate = 5;
	

	public Firetruck(int health, Point position, int volume, Texture texture) {
		super(health, position, texture);
		this.volume = water = volume;
		System.out.println("hello world!");
	}

	public int getWater() {
		return water;
	}

	private void setWater(int amount) {
		if (amount <= volume && amount > 0) {
			water = amount;
		}
	}

	public void refill() {
		setWater(volume);
	}
	
	public void takeWater(int amount) {
		System.out.println("water is " + water);
		if (amount <= volume && amount > 0) {
			water -= amount;
		}
	}

	/*@Override
	public void movePos(int direction, int speed) {
		// TODO Auto-generated method stub
	}*/

}