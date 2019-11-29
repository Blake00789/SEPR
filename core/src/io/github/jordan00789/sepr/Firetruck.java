package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.Vector;

public class Firetruck extends Entity implements Movable{
	
	private int water;
	private float truckx = 0;
	private float trucky = 0;
	private float trucka = 0.1f;
	private float truckdecel = 2;
	private float truckxv, truckyv;

	public Texture texture = new Texture("firetruck.png");

	public Firetruck(int health, Vector<Float> position, int water) {
		super(health, position);
		this.water = water;
	}
	
	public int getWater() {
		return water;
	}
	
	private void setWater(int volume) {
		this.water = volume;
	}
	
	public void refill() {
		
	}

	@Override
	public void movePos(int direction, int speed) {
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			truckyv += Gdx.graphics.getDeltaTime() + trucka;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			truckyv -= Gdx.graphics.getDeltaTime() + trucka;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			truckxv -= Gdx.graphics.getDeltaTime() + trucka;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			truckxv += Gdx.graphics.getDeltaTime() + trucka;
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
	}
}
