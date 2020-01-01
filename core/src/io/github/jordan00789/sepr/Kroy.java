package io.github.jordan00789.sepr;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;


public class Kroy extends Game {
	SpriteBatch batch;
	Texture img;
	Firetruck truck1;
	Firetruck truck2;
	Firetruck currentTruck;
	SpeedModifier[] modifiers;
	SpeedModifier speedy;
	SpeedModifier notsospeedy;
	World world;
	Body truck;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("firetruck.png");
		
		truck1 = new Firetruck(200, 100, img);
		truck1.setScale(0.25f);
		truck1.setOrigin(256, 256);
		
		truck2 = new Firetruck(200, 100, img);
		truck2.setScale(0.3f);
		truck2.setOrigin(256, 256);

		speedy = new SpeedModifier(200);
		speedy.setScale(400, 200);
		speedy.setPosition(500 ,500);

		notsospeedy = new SpeedModifier(50);
		notsospeedy.setScale(200, 100);
		notsospeedy.setScale(800, 800);

		modifiers = new SpeedModifier[2];
		modifiers[0] = speedy;
		modifiers[1] = notsospeedy;

		currentTruck = truck1;
		currentTruck.setColor(Color.RED);
		
	}

	@Override
	public void render() {
		takeInputs();

		Gdx.gl.glClearColor(0.8f, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		float truck1max = 1000f;
		float truck2max = 1000f;

		for (SpeedModifier modifier: modifiers) {
			if (truck1.getBoundingRectangle().overlaps(modifier.getBoundingRectangle())){
				truck1max = modifier.maxspeed;
			}
			if (truck2.getBoundingRectangle().overlaps(modifier.getBoundingRectangle())) {
				truck2max = modifier.maxspeed;
			}

			modifier.draw(batch);
		}
		truck1.update(Gdx.graphics.getDeltaTime(), truck1max);
		truck2.update(Gdx.graphics.getDeltaTime(), truck2max);

		truck1.draw(batch);
		truck2.draw(batch);
		batch.end();
	}
	
	private void takeInputs() {
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			currentTruck.goForward();
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			currentTruck.goBackward();
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			currentTruck.turnLeft();
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			currentTruck.turnRight();
		}
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			currentTruck.takeWater(1);
		}
		switchTrucks();
	}

	private void switchTrucks() {
		if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
			currentTruck.setColor(Color.WHITE);
			currentTruck = truck1;
			currentTruck.setColor(Color.RED);
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_2)) {
			currentTruck.setColor(Color.WHITE);
			currentTruck = truck2;
			currentTruck.setColor(Color.RED);
		}
	}


	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}