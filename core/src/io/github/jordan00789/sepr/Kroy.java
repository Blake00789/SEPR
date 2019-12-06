package io.github.jordan00789.sepr;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.lang.Math;

public class Kroy extends Game {

	public static final int V_WIDTH = 1920;
	public static final int V_HEIGHT = 1080;


	public OrthographicCamera camera;
	public SpriteBatch batch;
	public BitmapFont font;
	public AssetManager assets;

	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1080,1920);
		batch = new SpriteBatch();
		font = new BitmapFont();

		initFonts();

		this.setScreen(new MainMenu(this));
	}

	public void render() {
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
		assets.dispose();
	}

	private void initFonts() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Bubblegum.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

		params.size = 24;
		params.color = Color.PINK;
		font = generator.generateFont(params);
	}
}