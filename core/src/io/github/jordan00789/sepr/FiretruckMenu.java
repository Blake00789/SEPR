package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FiretruckMenu {

	private static Texture texture1;
	private static TextureRegion textureRegion1;
	private static TextureRegionDrawable textureRegionDrawable1;
	public static ImageButton firetruckUI1;

	public static Stage stage;
	private static Table table;
	private static Stack stack;

	public static void create() {
		
		stage = new Stage();
		stage.getCamera().viewportWidth = Gdx.graphics.getWidth();
		stage.getCamera().viewportHeight = Gdx.graphics.getHeight();

		stack = new Stack();
		
		table = new Table();
		table.setWidth(stage.getWidth());
		//things added to the table are added to the right and at the top
		table.align(Align.right|Align.top);
		table.setPosition(0, (Gdx.graphics.getHeight()/2));

		texture1 = new Texture("badlogic.jpg");
		textureRegion1 = new TextureRegion(texture1);
		textureRegionDrawable1 = new TextureRegionDrawable(textureRegion1);
		firetruckUI1 = new ImageButton(textureRegionDrawable1);

		Gdx.input.setInputProcessor(stage);
		
		firetruckUI1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.log("Button clicked", "clicked");
				event.stop();
			}
		});
		
		table.padRight(10);
		table.add(firetruckUI1).padBottom(10);
		table.row();
		
//		table.add(stack);
		stage.addActor(table);
	
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();


	}
}
