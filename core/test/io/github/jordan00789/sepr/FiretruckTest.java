package io.github.jordan00789.sepr;

import static org.junit.Assert.*;
import org.junit.Test;

import com.badlogic.gdx.graphics.Texture;

public class FiretruckTest {

	@Test
	public void testGetWater() {
		Firetruck truck = new Firetruck(100, 100, new Texture("firetrucktest.png"));
		assertEquals(truck.getWater(), 100);
	}

	@Test
	public void testRefill() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public void testTakeWater() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public void testChangeXSpeed() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public void testChangeYSpeed() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAttack() {
		//fail("Not yet implemented"); // TODO
	}

}
