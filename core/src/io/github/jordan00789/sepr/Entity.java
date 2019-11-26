package io.github.jordan00789.sepr;

import java.util.Vector;

public class Entity {
	
	private int health;
	private Vector position;
	
	public Entity(int health, Vector position) {
		this.health = health;
		this.position = position;
	}
	
	public int getHealth() {
		return health;
	}
	
	private void setHealth(int health) {
		this.health = health;
	}
	
	public void takeDamage(int damage) {
		health -= damage;
	}
	
	public Vector getPos() {
		return position;
	}
	
	public Boolean isDestroyed() {
		return health == 0 ? true : false;
	}
	
}
