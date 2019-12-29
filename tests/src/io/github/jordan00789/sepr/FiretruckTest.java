package io.github.jordan00789.sepr;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

@RunWith(GdxTestRunner.class)
public class FiretruckTest {

	private Firetruck truck;

	@Before
	public void init() {
		Vector2 point = new Vector2(2,4);
		truck = new Firetruck(100, point , 500, new Texture("../core/assets/firetruck.png"));
	}

	@Test
	public void testInitialisation() {
		org.junit.Assert.assertTrue(truck.getHealth() == 100);
		org.junit.Assert.assertTrue(truck.getWater() == 500);
	}


	@After
	public void clean() {
		truck.getTexture().dispose();
	}

}
