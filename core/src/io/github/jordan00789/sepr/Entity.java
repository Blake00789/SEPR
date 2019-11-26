package io.github.jordan00789.sepr;

import java.util.Vector;

public class Entity {
	
	private int health;
	private Vector position;

	public float getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void takeDamage(int damage) {
		health -= damage;
	}
	
	public Vector getPos() {
		return position;
	}
	
	public boolean isDestroyed() {
		return (getHealth() <= 0);
	}

	/*private void setPos(Vector position) {
		this.position = position;
	}
	Not in the UML diagram but could be useful
	*/
}
