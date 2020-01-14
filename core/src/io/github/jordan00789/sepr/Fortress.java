package io.github.jordan00789.sepr;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Fortress extends Entity implements Attack {

	public ArrayList<Projectile> goos = new ArrayList<Projectile>();

	/**
	 * Creates a Fortress sprite using the texture provided, with the specified
	 * amount of health.
	 * 
	 * @param health The amount of health the Fortress has
	 * @param texture The texture given to the Fortress sprite
	 */
	public Fortress(int health, Texture texture) {
		super(health, texture);
	}

	/**
	 * Attempts to attack the specified entity, should be currentFiretruck.
	 * 
	 * @param e The entity to aim at.
	 */
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

	/**
	 * A method to catch any attack method calls that aren't aimed at an entity.
	 */
	@Override
	public void attack() {
		attack(null);
	}

	/**
	 * Attacks currentTruck if it's in range, and updates the goo projectiles.
	 * 
	 * @param delta The current delta time.
	 */
	@Override
	public void update(float delta) {
		if (distanceTo(MainGame.currentTruck) < 100f) {
			attack(MainGame.currentTruck);
		}
		goos.removeIf(goo -> goo.isDisposable());
		goos.forEach(goo -> goo.update(delta));
	}

	/**
	 * Overrides the Sprite draw method so goo projectiles can be drawn too.
	 * 
	 * @param batch The sprite batch to draw in
	 */
	@Override
	public void draw(Batch batch) {
		goos.forEach(goo -> goo.draw(batch));
		super.draw(batch);
	}

	/**
	 * Calculate the direction from the fortress to an entity.
	 * 
	 * @param e The entity to calculate the direction of
	 * @return The direction of the entity
	 */
	private float directionTo(Entity e) {
		return directionTo(e.getX() + (e.getOriginX() / 2), e.getY() + (e.getOriginY() / 2));
	}

	/**
	 * Calculate the direction from the fortress to a point.
	 * 
	 * @param x The x-coordinate of the point
	 * @param y The y-coordinate of the point
	 * @return The direction of the entity
	 */
	public float directionTo(float x, float y) {
		return (float) ((180 / Math.PI) * Math.atan2(x - (getX() + 384), y - (getY() + 384)));
	}

	/**
	 * Calculate the distance from the fortress to an entity.
	 * 
	 * @param e The entity to calculate the distance to
	 * @return The distance to the entity
	 */
	public float distanceTo(Entity e) {
		return distanceTo(e.getX() + (e.getOriginX()), e.getY() + (e.getOriginY()));
	}

	/**
	 * Calculate the distance from the fortress to a point.
	 * 
	 * @param x The x-coordinate of the point
	 * @param y The y-coordinate of the point
	 * @return The distance to the point
	 */
	public float distanceTo(float farx, float fary) {
		return (float) Math
				.sqrt(Math.pow((fary - (getY() + getOriginY())), 2) + Math.pow((farx - (getX() + getOriginX())), 2));
	}

}
