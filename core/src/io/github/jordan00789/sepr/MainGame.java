package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class MainGame implements Screen {
	final Kroy game;
	OrthographicCamera camera;
	float entityScale;

	// Entities
	Firetruck camTruck;
	Firetruck truck1;
	Firetruck truck2;
	public static Firetruck currentTruck;
	Fortress fortress1;
	Fortress fortress2;
	Fortress fortress3;
	Texture map;

	Array<Entity> entities = new Array<Entity>();

	public MainGame(final Kroy game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		entityScale = 0.05f;
		loadTrucks();
		loadFortresses();

		map = new Texture("map.png");
	}

	private void loadFortresses() {
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		fortress1 = new Fortress(100, new Texture("ctower.png"));
		initEntity(fortress1, (0.53f * width), (0.26f * height));

		fortress2 = new Fortress(100, new Texture("station.png"));
		initEntity(fortress2, (0.29f * width), (0.66f * height));

		fortress3 = new Fortress(100, new Texture("minster.png"));
		initEntity(fortress3, (0.47f * width), (0.82f * height));

		entities.add(fortress1, fortress2, fortress3);
	}

	private void loadTrucks() {
		truck1 = new Firetruck(2500, 5, new Texture("truck1.png"));
		initEntity(truck1, 50, 100);

		truck2 = new Firetruck(200, 100, new Texture("truck2.png"));
		initEntity(truck2, 90, 150);

		//camTruck is located at the centre of the screen. It is not rendered, but used
		//to switch to the full map view.
		camTruck = new Firetruck(1, 1, new Texture("badlogic.jpg"));
		camTruck.setX((Gdx.graphics.getWidth() / 2) - 256);
		camTruck.setY((Gdx.graphics.getHeight() / 2) - 256);

		changeToTruck(truck1);
		
		entities.add(truck1, truck2);
	}

	private void initEntity(Entity e, float x, float y) {
		e.setScale(entityScale);
		e.setOriginCenter();
		e.setPosition(x - e.getOriginX(), y - e.getOriginY());
	}

	public void render(float delta) {
		
		takeInputs();

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		// Ensures viewport edges stay within the bounds of the map
		float cameraX = Math.max(0.125f * Gdx.graphics.getWidth(),
				Math.min(currentTruck.getX() + 256, 0.875f * Gdx.graphics.getWidth()));
		float cameraY = Math.max(0.125f * Gdx.graphics.getHeight(),
				Math.min(currentTruck.getY() + 256, 0.875f * Gdx.graphics.getHeight()));

		Batch batch = game.batch;
		camera.position.set(cameraX, cameraY, 0);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(map, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		entities.forEach(e -> {e.update(delta); e.draw(batch);});

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
			currentTruck.attack();
		}
		switchTrucks();
	}

	private void switchTrucks() {
		if (Gdx.input.isKeyPressed(Keys.NUM_1)) {
			changeToTruck(truck1);
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_2)) {
			changeToTruck(truck2);
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_0)) {
			currentTruck.setColor(Color.WHITE);
			currentTruck = camTruck;
			camera.zoom = 1f;
		}
		
	}
	
	private void changeToTruck(Firetruck t) {
		if(currentTruck != null) {currentTruck.setColor(Color.WHITE);}
		currentTruck = t;
		currentTruck.setColor(Color.RED);
		camera.zoom = 0.25f;
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
