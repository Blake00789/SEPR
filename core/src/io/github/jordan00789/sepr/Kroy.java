package io.github.jordan00789.sepr;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Point;
import java.lang.Math;

public class Kroy extends ApplicationAdapter {//FIXME Switch to extends Game instead?
	SpriteBatch batch;
	//Texture img = new Texture("firetruck.png");
	Sprite truck;
	//Firetruck truck1 = new Firetruck(200, new Point(0,0), 100, new Sprite(new Texture("firetruck.png")));
	float truckx = 0;
	float trucky = 0;
	float trucka = 0.1f;
	float truckdecel = 2;
	float truckxv, truckyv;

	@Override
	public void create() {
		batch = new SpriteBatch();
		//img = new Texture("firetruck.png");
		truck = new Sprite(new Texture("firetruck.png"));
		//Firetruck truck1 = new Firetruck(200, new Point(0,0), 100, new Sprite(img));
		//truck1.setScale(0.25f);
		//truck1.setOrigin(256, 320);//Drift mode
	}

	@Override
	public void render() {
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			truckyv += Gdx.graphics.getDeltaTime() + trucka;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			truckyv -= Gdx.graphics.getDeltaTime() + trucka;
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			truckxv -= Gdx.graphics.getDeltaTime() + trucka;
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			truckxv += Gdx.graphics.getDeltaTime() + trucka;
		}
		
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			//truck1.getWater();
		}
		
		trucky += truckyv;
		truckx += truckxv;

		if (truckyv>0) {
			truckyv -= trucka/truckdecel;
		}

		if (truckyv<0) {
			truckyv += trucka/truckdecel;
		}

		if (truckxv>0) {
			truckxv -= trucka/truckdecel;
		}
		if (truckxv<0) {
			truckxv += trucka/truckdecel;
		}


		Gdx.gl.glClearColor(0.8f, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		truck.setPosition(truckx, trucky);
		truck.setRotation((float) (Math.atan2(-truckxv, truckyv)*180/Math.PI));
		truck.draw(batch);
		batch.end();
	}



	@Override
	public void dispose() {
		batch.dispose();
		//img.dispose();
	}
}