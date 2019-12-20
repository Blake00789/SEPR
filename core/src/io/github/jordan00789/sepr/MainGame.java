package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.awt.*;

public class MainGame implements Screen {
    final Kroy game;
    OrthographicCamera camera;
    Firetruck truck;
    World world;
    Box2DDebugRenderer debugRenderer;
    Fortress fortress_1;
    Fortress fortress_2;
    Bullet bullet;


    public MainGame(final Kroy game) {
        this.game = game;


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        Box2D.init();
        world = new World(new Vector2(0, 0), true);
        debugRenderer = new Box2DDebugRenderer();

        truck=new Firetruck(100, new Vector2(600,600) ,10);
        BodyEditorLoader loader = new BodyEditorLoader(Gdx.files.internal("kroyphysics.json"));
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        Body body = world.createBody(bd);

        FixtureDef fd = new FixtureDef();
        fd.density = 1;
        fd.friction = 0.5f;
        fd.restitution = 0.3f;
        loader.attachFixture(body, "Firetruck", fd, 1.0f);

        body.setUserData(truck);
        
        fortress_1 = new Fortress( 100, new Vector2(100,100),  new Texture("castle.png"));
        fortress_2 = new Fortress( 100,  new Vector2(400,400),  new Texture("minster.png"));
    }

    public void render(float delta) {
    	
    	// shooting code
    	if(fortress_1.position.dst(truck.position) < bullet.shooting_distance) {
    		bullet= new Bullet(fortress_1.position.x,fortress_1.position.y);
    		bullet.direction_x=(truck.position.x-fortress_1.position.x)/(fortress_1.position.dst(truck.position));
    	    bullet.direction_y=(truck.position.y-fortress_1.position.y)/(fortress_1.position.dst(truck.position));
    	    
    	}
    	bullet.update(delta);

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
