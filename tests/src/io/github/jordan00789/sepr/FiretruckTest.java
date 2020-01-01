package io.github.jordan00789.sepr;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.graphics.Texture;

@RunWith(GdxTestRunner.class)
public class FiretruckTest {

	private Firetruck truck;

	@Before
	public void init() {
		truck = new Firetruck(100, 500, new Texture("../core/assets/firetruck.png"));
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
		assertTrue(truck.getWater() == 500);
	}

	@Test
	public void testTurning() {
		assertTrue(truck.getDirection() == 0);
		truck.turnRight();
		assertTrue(truck.getDirection() > 0);
		truck.turnLeft();
		assertTrue(truck.getDirection() == 0);
	}


	@Test
	public void testUpdate() {
		assertTrue(truck.getVelocity() == 0);
		truck.goForward();
		float v = truck.getVelocity();
		assertTrue(v > 0);
		truck.update(1,50);
		assertTrue(truck.getVelocity() < v);
	}

	@Test
	public void testAttack() {
		// TODO not yet implemented
	}

	@After
	public void clean() {
		truck.getTexture().dispose();
	}

}
