package io.github.jordan00789.sepr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class FiretruckMenu {

	public static Stage stage;
	private static Table backgroundTable;
	private static Table iconTable;
	private static Stack stack;

	private static ImageButton createImageButton(Texture tex) {
		return new ImageButton(new TextureRegionDrawable(tex));
	}

	public static void create() {

		stage = new Stage();
		stack = new Stack();
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

		ImageButton UIBackground = createImageButton(new Texture("stationUI.png"));
		ImageButton firetruckUI = createImageButton(new Texture("truckUI.png"));
		ImageButton firetruckUIDeployed = createImageButton(new Texture("truckUIdeployed.png"));

		backgroundTable.add(UIBackground).padLeft(20);

		stack.add(firetruckUI);
		stack.add(firetruckUIDeployed);

		iconTable.row().height(40).padLeft(30);
		iconTable.add(stack);
		firetruckUIDeployed.setVisible(false);

		stage.addActor(backgroundTable);
		stage.addActor(iconTable);
		Gdx.input.setInputProcessor(stage);

		firetruckUI.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (firetruckUI.isVisible() && !firetruckUIDeployed.isVisible()) {
					Gdx.app.log("isVisible", "visible");
					firetruckUI.setVisible(false);
					firetruckUIDeployed.setVisible(true);
				}
				event.stop();
			}
		});
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
}
