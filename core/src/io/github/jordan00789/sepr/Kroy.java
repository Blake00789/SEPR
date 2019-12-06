package io.github.jordan00789.sepr;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Point;
import java.lang.Math;

public class Kroy extends Game {//FIXME Switch to extends Game instead?
	SpriteBatch batch;
	Texture img;
	Firetruck truck1;
	Firetruck truck2;
	Firetruck currentTruck;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("firetruck.png");
		
		truck1 = new Firetruck(200, 100, img);
		truck1.setScale(0.25f);
		truck1.setOrigin(256, 320);//Drift mode
		
		truck2 = new Firetruck(200, 100, img);
		truck2.setScale(0.3f);
		truck2.setOrigin(256, 256);
		
		currentTruck = truck1;
		currentTruck.setColor(Color.RED);

	}

	@Override
	public void render() {
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			currentTruck.changeYSpeed(currentTruck.acceleration);
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			currentTruck.changeYSpeed(-currentTruck.acceleration);
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			currentTruck.changeXSpeed(-currentTruck.acceleration);
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			currentTruck.changeXSpeed(currentTruck.acceleration);
		}
		
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			currentTruck.takeWater(1);
		}
		
		if (Gdx.input.isKeyPressed(Keys.NUM_1)) {currentTruck.setColor(Color.WHITE);currentTruck = truck1;currentTruck.setColor(Color.RED);}
		if (Gdx.input.isKeyPressed(Keys.NUM_2)) {currentTruck.setColor(Color.WHITE);currentTruck = truck2;currentTruck.setColor(Color.RED);}
		
		
		truck1.setPosition(truck1.getX()+truck1.xvelocity,truck1.getY()+truck1.yvelocity);
		truck2.setPosition(truck2.getX()+truck2.xvelocity,truck2.getY()+truck2.yvelocity);
		
		if (truck1.yvelocity>0) {truck1.changeYSpeed(-truck1.acceleration/truck1.deceleration);}
		if (truck1.yvelocity<0) {truck1.changeYSpeed(truck1.acceleration/truck1.deceleration);}
		if (truck1.xvelocity>0) {truck1.changeXSpeed(-truck1.acceleration/truck1.deceleration);}
		if (truck1.xvelocity<0) {truck1.changeXSpeed(truck1.acceleration/truck1.deceleration);}
		if (truck2.yvelocity>0) {truck2.changeYSpeed(-truck2.acceleration/truck2.deceleration);}
		if (truck2.yvelocity<0) {truck2.changeYSpeed(truck2.acceleration/truck2.deceleration);}
		if (truck2.xvelocity>0) {truck2.changeXSpeed(-truck2.acceleration/truck2.deceleration);}
		if (truck2.xvelocity<0) {truck2.changeXSpeed(truck2.acceleration/truck2.deceleration);}
		//This block can be simplified if we switch to a speed and direction based system instead of x and y vectors


		Gdx.gl.glClearColor(0.8f, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		currentTruck.setRotation((float) (Math.atan2(-currentTruck.xvelocity, currentTruck.yvelocity)*180/Math.PI));
		truck1.draw(batch);
		truck2.draw(batch);
		batch.end();
	}



	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}