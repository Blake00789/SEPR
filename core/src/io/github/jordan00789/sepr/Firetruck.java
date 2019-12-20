package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

import java.awt.Point;

public class Firetruck extends Entity{

    private int water;

    
    public Firetruck(int health, Vector2 position, int water) {
        super(health, position, new Texture("firetruck.png"));
        this.water = water;

    }
   
    public Firetruck(int health, float x , float y , int water) {
		super(health, x,y,new Texture("firetruck.png"));
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

}
