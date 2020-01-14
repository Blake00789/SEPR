package io.github.jordan00789.sepr;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Fortress extends Entity implements Attack {

	public ArrayList<Projectile> goos = new ArrayList<Projectile>();
	private float c = (float) Math.PI / 180;

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
				Projectile goo = new Projectile((getX() + 384) + ((float) Math.sin(directionTo(e) * c) * 10),
						(getY() + 384 + ((float) Math.cos(directionTo(e) * c) * 10)), directionTo(e), 50f, 5f,
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

}
