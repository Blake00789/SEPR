package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Entity extends Sprite {

	private int health;

	/**
	 * Creates a new entity with the specified texture and a default health of 1.
	 * 
	 * @param texture The texture given to the entity sprite
	 */
	public Entity(Texture texture) {
		super(texture);
		this.health = 1;
	}

	/**
	 * Creates a new entity with the specified texture and health.
	 * 
	 * @param health  The amount of health the Fortress has
	 * @param texture The texture given to the entity sprite
	 */
	public Entity(int health, Texture texture) {
		super(texture);
		this.health = health;
	}

	/**
	 * Returns the current health of the entity.
	 * 
	 * @return The current health of the entity
	 */
	public float getHealth() {
		return health;
	}

	/**
	 * Sets the health of the entity.
	 * 
	 * @param health The value to set health to
	 */
	protected void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Removes the specified amount of health from the entity.
	 * 
	 * @param damage The amount of health to remove
	 */
	public void takeDamage(int damage) {
		health -= damage;
	}

	/**
	 * Returns true if the entity has a health value less than or equal to 0.
	 * 
	 * @return A boolean of whether the entity is destroyed or not
	 */
	public boolean isDestroyed() {
		return (getHealth() <= 0);
	}

	/**
	 * Returns true if the entity has a health value more than 0.
	 * 
	 * @return A boolean of whether the entity is alive or not
	 */
	public boolean isAlive() {
		return (getHealth() > 0);
	}

	/**
	 * Updates the entity. If not overridden, does nothing.
	 * @param delta The current delta time
	 */
	public void update(float delta) {
	}

}