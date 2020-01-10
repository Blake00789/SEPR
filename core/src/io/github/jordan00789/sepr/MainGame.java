package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.*;
import java.util.ArrayList;

public class MainGame implements Screen {
    final Kroy game;
    OrthographicCamera camera;
    ArrayList<Bullet> bullets= new ArrayList<Bullet>();
    float stateTime;
	
    
    
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


    public MainGame(final Kroy game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        /*
        BodyEditorLoader loader = new BodyEditorLoader(Gdx.files.internal("kroyphysics.json"));
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        Body body = world.createBody(bd);

        FixtureDef fd = new FixtureDef();
        fd.density = 1;
        fd.friction = 0.5f;
        fd.restitution = 0.3f;
        loader.attachFixture(body, "firetruck", fd, 1.0f);
        body.setUserData(truck);
        */
        
        loadTrucks();
        loadFortresses();
        //System.out.println(camera.viewportWidth + "  " + camera.viewportHeight);
        //System.out.println(Gdx.graphics.getWidth() + "  " + Gdx.graphics.getHeight());
        
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
    }
    
    private void loadTrucks() {
    	Texture img = new Texture("firetruck.png");
		
		truck1 = new Firetruck(2500, 5, img);
		truck1.setScale(0.05f);
		truck1.setOrigin(256, 256);
		
		truck2 = new Firetruck(200, 100, img);
		truck2.setScale(0.05f);
		truck2.setOrigin(256, 256);
		
		camTruck = new Firetruck(1,1, img);
		camTruck.setX((Gdx.graphics.getWidth()/2)-256);
		camTruck.setY((Gdx.graphics.getHeight()/2)-256);
		
		currentTruck = truck1;
		currentTruck.setColor(Color.RED);
		camera.zoom = 0.5f;
    }
    
    
    

    public void render(float delta) {
    	
    	// shooting code
    	System.out.println(fortress1.distanceTo(currentTruck.getX(), currentTruck.getY()));
    	if(fortress1.distanceTo(currentTruck.getX(), currentTruck.getY()) <  Bullet.shooting_distance && bullets.size()< 30) {
    		//System.out.println(fortress1.distanceTo(currentTruck.getX(), currentTruck.getY()));
    		bullet= new Bullet(1, new Texture("badlogic.jpg"), fortress1.getX(), fortress1.getY());
    		bullets.add(bullet);
    		bullet.direction_x=(currentTruck.getX()-fortress1.getX()/(fortress1.distanceTo(currentTruck.getX(),currentTruck.getY())));
    	    bullet.direction_y=(currentTruck.getY()-fortress1.getY()/(fortress1.distanceTo(currentTruck.getX(),currentTruck.getY())));
    	    
    	}
    	
	    
	    ArrayList<Bullet> bulletToRemove= new ArrayList<Bullet>();
	
	    if(!(bullets.isEmpty() )) {
			bullet.update(delta);
			if(bullet.remove) {
				bulletToRemove.add(bullet);
			}
	    }
	    
	    bullets.removeAll(bulletToRemove);
    	
    	stateTime = delta;
    	takeInputs();
    	
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        
        camera.position.set(currentTruck.getX()+256,currentTruck.getY()+256,0);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(map,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        //game.font.draw(game.batch, "My test text", 480, 480);
        truck1.update(Gdx.graphics.getDeltaTime());
		truck2.update(Gdx.graphics.getDeltaTime());
        truck1.draw(game.batch);
        truck2.draw(game.batch);
        fortress1.draw(game.batch);
        fortress2.draw(game.batch);
        fortress3.draw(game.batch);
        
        for( Bullet bullet : bullets) {
        	bullet.draw(game.batch);
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
			currentTruck.takeWater(1);
		}
		switchTrucks();
	}

	private void switchTrucks() {
		if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
			currentTruck.setColor(Color.WHITE);
			currentTruck = truck1;
			currentTruck.setColor(Color.RED);
			camera.zoom = 0.5f;
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_2)) {
			currentTruck.setColor(Color.WHITE);
			currentTruck = truck2;
			currentTruck.setColor(Color.RED);
			camera.zoom = 0.5f;
			
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
