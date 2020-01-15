package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.VisibleAction;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FiretruckMenu {

	private static Texture textureBackground;
	private static TextureRegion backgroundRegion;
	private static TextureRegionDrawable backgroundRegionDrawable;
	private static ImageButton UIBackground;
	
	private static Texture texture1;
	private static TextureRegion textureRegion1;
	private static TextureRegionDrawable textureRegionDrawable1;
	public static ImageButton firetruckUI1;
	private static Texture texture2;
	private static TextureRegion textureRegion2;
	private static TextureRegionDrawable textureRegionDrawable2;
	public static ImageButton firetruckUI2;
	private static Texture texture3;
	private static TextureRegion textureRegion3;
	private static TextureRegionDrawable textureRegionDrawable3;
	public static ImageButton firetruckUI3;

	public static Stage stage;
	private static Table table;
	private static Table table2;
	private static Table table3;


	public static void create() {
		
		stage = new Stage();
		stage.getCamera().viewportWidth = Gdx.graphics.getWidth();
		stage.getCamera().viewportHeight = Gdx.graphics.getHeight();
				
		table = new Table();
		table.setWidth(stage.getWidth());
		//things added to the table are added to the left and at the top
		table.align(Align.left|Align.top);
		table.setPosition(0, (float) (Gdx.graphics.getHeight()/2.5));
		
		table2 = new Table();
		table2.setWidth(stage.getWidth());
		//things added to the table are added to the center and at the top
		table2.align(Align.left|Align.top);
		table2.setPosition(0, (float) (Gdx.graphics.getHeight()/3));
		
		table3 = new Table();
		table3.setWidth(stage.getWidth());
		table3.align(Align.left|Align.top);
		table3.setPosition(20, (float) (Gdx.graphics.getHeight()/3));

		textureBackground = new Texture(Gdx.files.internal("stationUI.png"));
		backgroundRegion = new TextureRegion(textureBackground);
		backgroundRegionDrawable = new TextureRegionDrawable(backgroundRegion);
		UIBackground = new ImageButton(backgroundRegionDrawable);
		
		texture1 = new Texture(Gdx.files.internal("truckUI.png"));
		textureRegion1 = new TextureRegion(texture1);
		textureRegionDrawable1 = new TextureRegionDrawable(textureRegion1);
		firetruckUI1 = new ImageButton(textureRegionDrawable1);
		
		texture2 = new Texture(Gdx.files.internal("truckUI.png"));
		textureRegion2 = new TextureRegion(texture2);
		textureRegionDrawable2 = new TextureRegionDrawable(textureRegion2);
		firetruckUI2 = new ImageButton(textureRegionDrawable2);
		
		texture3 = new Texture(Gdx.files.internal("truckUI.png"));
		textureRegion3 = new TextureRegion(texture3);
		textureRegionDrawable3 = new TextureRegionDrawable(textureRegion3);
		firetruckUI3 = new ImageButton(textureRegionDrawable3);
		
		table.add(UIBackground).padLeft(20);

		table2.row().height(40).padLeft(30);
		table2.add(firetruckUI1);
		table2.row().height(100).padLeft(30);
		table2.add(firetruckUI2);
		table2.row().height(50).padLeft(30);
		table2.add(firetruckUI3);
		
//		table3.row().height(48).padLeft(30);
//		table3.add(firetruckUIDeployed);
//		table3.row().height(90).padLeft(30);
//		table3.add(firetruckUIDeployed2);
//		table3.row().height(60).padLeft(30);
//		table3.add(firetruckUIDeployed3);
		
		firetruckUI1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				//Set position outside of the station?
				MainGame.truck1.setPosition(x, y);
				
				event.stop();
			}
		});
		
		stage.addActor(table);
		stage.addActor(table2);
		stage.addActor(table3);
		
		Gdx.input.setInputProcessor(stage);
		
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();


	}
	

	
}
