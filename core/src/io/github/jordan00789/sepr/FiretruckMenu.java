package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.VisibleAction;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FiretruckMenu {

	private static Texture textureBackground;
	private static TextureRegion backgroundRegion;
	private static TextureRegionDrawable backgroundRegionDrawable;
	public static ImageButton UIBackground;
	
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
	private static Texture texture4;
	private static TextureRegion textureRegion4;
	private static TextureRegionDrawable textureRegionDrawable4;
	public static ImageButton firetruckUIDeployed;
	private static Texture texture5;
	private static TextureRegion textureRegion5;
	private static TextureRegionDrawable textureRegionDrawable5;
	public static ImageButton firetruckUIDeployed2;
	private static Texture texture6;
	private static TextureRegion textureRegion6;
	private static TextureRegionDrawable textureRegionDrawable6;
	public static ImageButton firetruckUIDeployed3;

	public static Stage stage;
	private static Table table;
	private static Table table2;
	
	private static Table table3;
	
	private static Stack stack;
	private static Stack stack2;
	private static Stack stack3;

	public static void create() {
		
		stage = new Stage();
		stage.getCamera().viewportWidth = Gdx.graphics.getWidth();
		stage.getCamera().viewportHeight = Gdx.graphics.getHeight();

		stack = new Stack();
		stack2 = new Stack();
		stack3 = new Stack();
		
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
		
		texture4 = new Texture(Gdx.files.internal("truckUIdeployed.png"));
		textureRegion4 = new TextureRegion(texture4);
		textureRegionDrawable4 = new TextureRegionDrawable(textureRegion4);
		firetruckUIDeployed = new ImageButton(textureRegionDrawable4);

		texture5 = new Texture(Gdx.files.internal("truckUIdeployed.png"));
		textureRegion5 = new TextureRegion(texture5);
		textureRegionDrawable5 = new TextureRegionDrawable(textureRegion5);
		firetruckUIDeployed2 = new ImageButton(textureRegionDrawable5);
		
		texture6 = new Texture(Gdx.files.internal("truckUIdeployed.png"));
		textureRegion6 = new TextureRegion(texture6);
		textureRegionDrawable6 = new TextureRegionDrawable(textureRegion6);
		firetruckUIDeployed3 = new ImageButton(textureRegionDrawable6);
		
		table.add(UIBackground).padLeft(20);

		stack.add(firetruckUI1);
		stack.add(firetruckUIDeployed);
		stack2.add(firetruckUI2);
		stack2.add(firetruckUIDeployed2);
		stack3.add(firetruckUI3);
		stack3.add(firetruckUIDeployed3);
		
		table2.row().height(40).padLeft(30);
		table2.add(stack);
		firetruckUIDeployed.setVisible(false);
		table2.row().height(100).padLeft(30);
		table2.add(stack2);
		firetruckUIDeployed2.setVisible(false);
		table2.row().height(50).padLeft(30);
		table2.add(stack3);
		firetruckUIDeployed3.setVisible(false);
		
		stage.addActor(table);
		stage.addActor(table2);
		Gdx.input.setInputProcessor(stage);
		
		firetruckUI1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				if (firetruckUI1.isVisible()) {
					Gdx.app.log("isVisible", "visible");
					firetruckUI1.setVisible(false);
					firetruckUIDeployed.setVisible(true);
				}
						
				event.stop();
			}
		});
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();


	}
	
//	public boolean setVisibility(boolean visible) {
//		
//	}
}
