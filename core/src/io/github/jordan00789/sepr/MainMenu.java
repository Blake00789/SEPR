package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenu implements Screen {

    final Kroy game;

    OrthographicCamera camera;

    public MainMenu(final Kroy game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to Kroy!!! ", 100, 150);
        game.font.draw(game.batch, "Click anywhere to begin!", 100, 100);
        game.batch.end();

        if (/*Gdx.input.isTouched()*/true) {
            game.setScreen(new MainGame(game));
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
