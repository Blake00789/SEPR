package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Entity extends Sprite {

	private int health;

	public Entity(int health, Texture texture) {
		super(texture);
		this.health = health;
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

	public boolean isDestroyed() {
		return (getHealth() <= 0);
	}

	
	/*public double distance(Vector<Float> v) {
		double x=getPos().get(0)-v.get(0);
		double y=getPos().get(1)-v.get(1);
		return Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
	}*/

}