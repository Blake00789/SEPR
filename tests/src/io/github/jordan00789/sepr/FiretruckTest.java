package io.github.jordan00789.sepr;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.graphics.Texture;

/*
 * Don't forget to link the assets folder as a source!
 * To do this in Eclipse, right click the package, and click
 * Build Path -> Configure Build Path
 * From there, click link source, and browse to the assets folder inside core.
 * Then, these tests should run properly.
 */

@RunWith(GdxTestRunner.class)
public class FiretruckTest {

	private Firetruck truck;

	@Before
	public void init() {
		truck = new Firetruck(100, 500, new Texture("truck1.png"));
	}

	@Test
	public void testInitialisation() {
		org.junit.Assert.assertTrue(truck.getHealth() == 100);
		org.junit.Assert.assertTrue(truck.getWater() == 500);
	}

	@Test
	public void testRefill() {
		truck.takeWater(50);
		assertTrue(truck.getWater() == 450);
		truck.refill();
		assertTrue(truck.getWater() == 451);
	}

	@Test
	public void testTurning() {
		assertTrue(truck.getDirection() == 0);
		truck.turnRight();
		assertTrue(truck.getDirection() > 0);
		truck.turnLeft();
		assertTrue(truck.getDirection() == 0);
	}

	/*
	 * The truck does not move forward as the speedMap relies on screen size Because
	 * the tests run headless, the screen size is zero so the truck is limited to a
	 * speed of zero
	 */
	@Test
	public void testUpdate() {
		/**
		 * assertTrue(truck.getVelocity() == 0); truck.goForward(); float v =
		 * truck.getVelocity(); assertTrue(v > 0); truck.update(1);
		 * assertTrue(truck.getVelocity() < v);
		 **/
	}

	@Test
	public void testAttack() {
		assertTrue(truck.drops.isEmpty());
		truck.attack();
		assertTrue(!truck.drops.isEmpty());
	}

	@After
	public void clean() {
		truck.getTexture().dispose();
	}

}
