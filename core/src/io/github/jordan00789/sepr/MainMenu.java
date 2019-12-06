package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MainMenu implements Screen {

    private final Kroy game;
    private Stage stage;
    private Texture img;
    private SpriteBatch batch;

    private ShapeRenderer shapeRenderer; //

    public OrthographicCamera camera;

    public MainMenu(final Kroy game) {
        this.game = game;
        this.stage = new Stage(new FitViewport(Kroy.V_WIDTH, Kroy.V_HEIGHT, game.camera));
        this.shapeRenderer = new ShapeRenderer();
        Gdx.input.setInputProcessor(stage);

        img = new Texture("SpaceKey.jpg");
        batch = new SpriteBatch();

        //Menu branch
    }

    @Override
    public void show() {
        System.out.println("Home Screen");
        Gdx.input.setInputProcessor(stage);
        stage.clear();
    }


    public void update(float delta){
        stage.act(delta);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img,0,0);
        batch.end();

        update(delta);

        stage.draw();

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to Kroy!!! ", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new MainGame(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, false);
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
        batch.dispose();
        img.dispose();
    }
}
