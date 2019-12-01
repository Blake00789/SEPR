package io.github.jordan00789.sepr;

import java.util.Vector;

public class Entity {
	
	private int health;
	private Vector<Float> position;
	
	public Entity(int health, Vector<Float> position) {
		this.health = health;
		this.position = position;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void takeDamage(int damage) {
		health -= damage;
	}
	
	public Vector<Float> getPos() {
		return position;
	}
	
	public boolean isDestroyed() {
		return (getHealth() <= 0);
	}
	
	public double distance(Vector<Float> v) {
		double x=getPos().get(0)-v.get(0);
		double y=getPos().get(1)-v.get(1);
		return Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
	}

	/*private void setPos(Vector position) {
		this.position = position;
	}
	Not in the UML diagram but could be useful
	*/
}
