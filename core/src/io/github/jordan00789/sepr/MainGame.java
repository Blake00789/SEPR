package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.*;

public class MainGame implements Screen {
    final Kroy game;
    OrthographicCamera camera;
    
    
    //Entities
    Firetruck camTruck;
    Firetruck truck1;
	Firetruck truck2;
	Firetruck currentTruck;
    Fortress fortress1;
    Fortress fortress2;
    Fortress fortress3;
    Bullet bullet;
    Texture map;
    
    Array<Entity> entities = new Array<Entity>();


    public MainGame(final Kroy game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        
        loadTrucks();
        loadFortresses();
        
        map = new Texture("map.png");
    }
    
    private void loadFortresses() {
    	int width = Gdx.graphics.getWidth()-128;
    	int height = Gdx.graphics.getHeight()-128;
    	fortress1 = new Fortress(100, new Texture("ctower.png"), (0.53f*width), 0.26f*height);
    	fortress1.setSize(128, 128);
    	
        fortress2 = new Fortress(100, new Texture("station.png"), (0.29f*width), (0.66f*height));
        fortress2.setSize(128, 128);
        
        fortress3 = new Fortress(100, new Texture("minster.png"), (0.47f*width), (0.82f*height));
        fortress3.setSize(128, 128);
        
        entities.add(fortress1, fortress2, fortress3);
    }
    
    private void loadTrucks() {
    	Texture img = new Texture("firetruck.png");
		
		truck1 = new Firetruck(2500, 5, img);
		truck1.setScale(0.05f);
		truck1.setOrigin(256, 256);
		truck1.setPosition(-256,-256);
		
		truck2 = new Firetruck(200, 100, img);
		truck2.setScale(0.05f);
		truck2.setOrigin(256, 256);
		truck2.setPosition(-256,-256);
		
		camTruck = new Firetruck(1,1, img);
		camTruck.setX((Gdx.graphics.getWidth()/2)-256);
		camTruck.setY((Gdx.graphics.getHeight()/2)-256);
		
		currentTruck = truck1;
		currentTruck.setColor(Color.RED);
		camera.zoom = 0.25f;
		entities.add(truck1, truck2);
    }
    
    
    

    public void render(float delta) {
    	/*
    	// shooting code
    	if(fortress1.distanceTo(currentTruck.getX(), currentTruck.getY()) < bullet.shooting_distance) {
    		bullet= new Bullet(1, new Texture("badlogic.jpg"), fortress1.getX(), fortress1.getY());
    		bullet.direction_x=(currentTruck.getX()-fortress1.getX()/(fortress1.distanceTo(currentTruck.getX(),currentTruck.getY())));
    	    bullet.direction_y=(currentTruck.getY()-fortress1.getY()/(fortress1.distanceTo(currentTruck.getX(),currentTruck.getY())));
    	    
    	}
    	bullet.update(delta);
    	*/
    	
    	takeInputs();
    	
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        /*Ensure camera x and y will never show parts of the map that are out of bounds
        This works because we zoom out a factor of a half, but from the midpoint of the screen (our truck), it takes
        half the width to reach the left or right (or half the height for up/down). */
        float cameraX = Math.max(0.25f*Gdx.graphics.getWidth(), Math.min(currentTruck.getX()+256, 0.75f*Gdx.graphics.getWidth()));
        float cameraY = Math.max(0.25f*Gdx.graphics.getHeight(), Math.min(currentTruck.getY()+256, 0.75f*Gdx.graphics.getHeight()));

        System.out.println(currentTruck.getX()+256);
        System.out.println(currentTruck.getY()+256);
        camera.position.set(cameraX, cameraY, 0);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(map,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        for(Entity e : entities) {
        	e.update(delta);
        	e.draw(game.batch);
        }
        
        for(Projectile drop : currentTruck.drops) {
			drop.draw(game.batch);
		}
        
        game.batch.end();
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
			currentTruck.attack();
		}
		switchTrucks();
	}

	private void switchTrucks() {
		if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
			currentTruck.setColor(Color.WHITE);
			currentTruck = truck1;
			currentTruck.setColor(Color.RED);
			camera.zoom = 0.25f;
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_2)) {
			currentTruck.setColor(Color.WHITE);
			currentTruck = truck2;
			currentTruck.setColor(Color.RED);
			camera.zoom = 0.25f;
			
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_0)) {
			currentTruck.setColor(Color.WHITE);
			currentTruck = camTruck;
			camera.zoom = 1f;
		}
	}
    

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
    
}
