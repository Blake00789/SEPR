package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.awt.Point;

public class Entity {

    private int health;
    //private Point position;
    private Texture image;
    Vector2 position;

    public Entity(int health, Vector2 position, Texture image) {
        this.health = health;
        this.position = new Vector2(position.x,position.y);
        this.image = image;
    }
    
    public Entity(int health, float x , float y, Texture image) {
        this.health = health;
        this.position= new Vector2(x,y);
        this.image = image;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public Vector2 getPos() {
        return position;
    }

    public boolean isDestroyed() {
        return (getHealth() <= 0);
    }

    public Texture getTexture() {
        return image;
    }
    
    
    
 
	/*private void setPos(Vector position) {
		this.position = position;
	}
	Not in the UML diagram but could be useful
	*/

	
}