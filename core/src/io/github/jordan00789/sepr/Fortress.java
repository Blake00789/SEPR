package io.github.jordan00789.sepr;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Fortress extends Entity implements Attack {

	public ArrayList<Projectile> goos = new ArrayList<Projectile>();

	public Fortress(int health, Texture texture) {
		super(health, texture);

	}

	public Fortress(int health, Texture texture, float x, float y) {
		super(health, texture, x, y);
	}

	public void attack(Entity e) {
		if (e != null) {
			if (goos.size() < 1) {
				Projectile goo = new Projectile(getX() + 384, getY() + 384, directionTo(e), 20f, 5f,
						new Texture("goo.png"));
				goos.add(goo);
			}
		} else {
			System.err.println("Fortresses must target an entity");
		}
	}

	@Override
	public void attack() {
		attack(null);
	}

	@Override
	public void update(float delta) {
		if (distanceTo(MainGame.currentTruck) < 100f) {
			attack(MainGame.currentTruck);
		}
		goos.removeIf(goo -> goo.isDisposable());
		goos.forEach(goo -> goo.update(delta));
	}

	@Override
	public void draw(Batch batch) {
		goos.forEach(goo -> goo.draw(batch));
		super.draw(batch);
	}

	/**
	 * Calculate the direction of an entity from the fortress that calls this method
	 * 
	 * @param e The entity to calculate the direction of
	 * @return The direction of the entity
	 */
	private float directionTo(Entity e) {
		return directionTo(e.getX() + (e.getOriginX() / 2), e.getY() + (e.getOriginY() / 2));
	}

	public float directionTo(float x, float y) {
		return (float) ((180 / Math.PI) * Math.atan2(x - (getX() + 384), y - (getY() + 384)));
	}

	public float distanceTo(Entity e) {
		return distanceTo(e.getX() + (e.getOriginX()), e.getY() + (e.getOriginY()));
	}

	public float distanceTo(float farx, float fary) {
		return (float) Math
				.sqrt(Math.pow((fary - (getY() + getOriginY())), 2) + Math.pow((farx - (getX() + getOriginX())), 2));
	}

}
