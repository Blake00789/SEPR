package io.github.jordan00789.sepr;

import java.awt.Point;

public class Entity {

    private int health;
    private Point position;

    public Entity(int health, Point position) {
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

    public Point getPos() {
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