package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import java.awt.*;

public class MainGame implements Screen {
    final Kroy game;
    OrthographicCamera camera;
    Firetruck truck;
    World world;
    Box2DDebugRenderer debugRenderer;

    public MainGame(final Kroy game) {
        this.game = game;


        camera = new OrthographicCamera();

        Box2D.init();
        World world = new World(new Vector2(0, 0), true);
        Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();

        truck = new Firetruck(100, new Point(600,600), 0);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "My test text", 480, 480);
        game.batch.draw(truck.getTexture(), truck.getPos().x, truck.getPos().y);
        game.batch.end();

        debugRenderer.render(world, camera.combined);
        world.step(1/60f, 6, 2);
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
