package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.VisibleAction;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class FiretruckMenu {

	public static Stage stage;
	private static Skin skin;
	private static Table backgroundTable;
	private static Table iconTable;
	private static Table sliderTable;

	private static ImageButton createImageButton(Texture tex) {
		return new ImageButton(new TextureRegionDrawable(tex));
	}
	
	public static void create() {

		stage = new Stage();
		
		backgroundTable = new Table();
		backgroundTable.setWidth(stage.getWidth());
		// things added to the table are added to the left and at the top
		backgroundTable.align(Align.left | Align.top);
		backgroundTable.setPosition(0, (float) (Gdx.graphics.getHeight() / 2.5));

		iconTable = new Table();
		iconTable.setWidth(stage.getWidth());
		// things added to the table are added to the center and at the top
		iconTable.align(Align.left | Align.top);
		iconTable.setPosition(0, (float) (Gdx.graphics.getHeight() / 3));
		
//		skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
//		sliderTable = new Table();
//		Slider slider = new Slider(0, 100, 1, false, skin);
//		Container<Slider> container = new Container<Slider>(slider);
//		container.setTransform(true); //enabling scaling and rotation
//		container.size(100, 60);
//		container.setOrigin(container.getWidth()/2, container.getHeight()/2);
//		container.setPosition(100, 200);
//		container.setScale(3); //scaling 
//		sliderTable.addActor(container);
		
		ImageButton UIBackground = createImageButton(new Texture("stationUI.png"));
		ImageButton firetruckUI1 = createImageButton(new Texture("truckUI.png"));
		ImageButton firetruckUI2 = createImageButton(new Texture("truckUI.png"));
		ImageButton firetruckUI3 = createImageButton(new Texture("truckUI.png"));

		backgroundTable.add(UIBackground).padLeft(20);
		
		iconTable.row().height(40).padLeft(30);
		iconTable.add(firetruckUI1);
		iconTable.row().height(100).padLeft(30);
		iconTable.add(firetruckUI2);
		iconTable.row().height(50).padLeft(30);
		iconTable.add(firetruckUI3);

		stage.addActor(backgroundTable);
		stage.addActor(iconTable);
//		stage.addActor(sliderTable);
		Gdx.input.setInputProcessor(stage);

		firetruckUI1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (firetruckUI1.isVisible()) {
					Gdx.app.log("isVisible", "visible");
					firetruckUI1.setVisible(false);
				}
				event.stop();
			}
		});
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	

	
	}
