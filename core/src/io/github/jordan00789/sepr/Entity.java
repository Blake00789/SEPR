package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;

import java.awt.Point;

public class Entity {

    private int health;
    private Point position;
    private Texture image;

    public Entity(int health, Point position, Texture image) {
        this.health = health;
        this.position = position;
        this.image = image;
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

    public Texture getTexture() {
        return image;
    }
	/*private void setPos(Vector position) {
		this.position = position;
	}
	Not in the UML diagram but could be useful
	*/
}