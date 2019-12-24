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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import java.awt.Point;
import java.lang.Math;

public class Kroy extends Game {
	SpriteBatch batch;
	Texture img;
	Firetruck truck1;
	Firetruck truck2;
	Firetruck currentTruck;
	World world;
	Body truck;

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
		
		world = new World(new Vector2(0, -98f), true);
		BodyDef bodyDef = new BodyDef();
	    bodyDef.type = BodyDef.BodyType.DynamicBody;
	    bodyDef.position.set(truck1.getX(), truck1.getY());
	    truck = world.createBody(bodyDef);
	    PolygonShape shape = new PolygonShape();
	    shape.setAsBox(truck1.getWidth()/2, truck1.getHeight()/2);
	    FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        Fixture fixture = truck.createFixture(fixtureDef);
        shape.dispose();
	}

	@Override
	public void render() {
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
		
		if (Gdx.input.isKeyPressed(Keys.NUM_1)) {currentTruck.setColor(Color.WHITE);currentTruck = truck1;currentTruck.setColor(Color.RED);}
		if (Gdx.input.isKeyPressed(Keys.NUM_2)) {currentTruck.setColor(Color.WHITE);currentTruck = truck2;currentTruck.setColor(Color.RED);}
		
		
		world.step(Gdx.graphics.getDeltaTime(), 6, 2);

		Gdx.gl.glClearColor(0.8f, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		truck1.update(Gdx.graphics.getDeltaTime());
		truck2.update(Gdx.graphics.getDeltaTime());
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