package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MainMenu implements Screen {

	final Kroy game;
	OrthographicCamera camera; //Allows the user to move and rotate camera, change viewport and move in and out

	private Texture menuImage;

	public MainMenu(final Kroy game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		menuImage = new Texture("SEPR_menuV2.720p.png"); //Image of menu
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1); //Background behind drawn image colour
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(menuImage, 0, 0); //Image is drawn
		game.batch.end();

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			game.setScreen(new MainGame(game)); //If space is pressed, the game goes to a new screen
			dispose();
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
