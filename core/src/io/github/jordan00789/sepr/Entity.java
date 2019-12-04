package io.github.jordan00789.sepr;

import java.awt.Point;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Entity extends Sprite {

	private int health;
	private Point position;

	public Entity(int health, Point position, Sprite sprite) {
		super(sprite);
		this.health = health;
		this.position = position;
	}

	public float getHealth() {
		return health;
	}

	protected void setHealth(int health) {
		this.health = health;
	}

	public void takeDamage(int damage) {
		health -= damage;
	}

	public Point getPos() {
		return position;
	}
	
	protected void setPos(Point position) {//Already methods built into Sprite, should switch to those
		this.position = position;
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