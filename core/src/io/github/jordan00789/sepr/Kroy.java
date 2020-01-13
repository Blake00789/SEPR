package io.github.jordan00789.sepr;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class Kroy extends Game {
	public SpriteBatch batch; //SpriteBatch is used to draw sprites
	public BitmapFont font; //Allows us to add fonts later on for text


	public void create() {
		batch = new SpriteBatch(); //New SpriteBatch is created
		font = new BitmapFont(); //Font initialisation
		this.setScreen(new MainMenu(this));
	}

	public void render() {
		super.render();
	}

	public void dispose() { //Dispose Method to allow the programme to dispose of items after they have been used
		batch.dispose();
		font.dispose();
	}
}