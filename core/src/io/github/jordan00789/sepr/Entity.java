package io.github.jordan00789.sepr;

public class Entity {
	
	private float health;
	private Coordinate position;

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
		this.health = health;
	}
	
	public float takeDamage(int damage) {
		return health-damage;
	}
	
	public boolean isDestroyed() {
		return (getHealth() <= 0.0);
	}

	public Coordinate getPos() {
		return position;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}
	
}
