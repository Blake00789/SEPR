package io.github.jordan00789.sepr;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public class SpeedModifier extends Entity {

    public final float multiplier;
    private Color color;

    /**
     * Creates an entity which changes the max speed of firetrucks when they drive over it.
     * @param maxspeed    The maximum value at which a firetruck can have while standing over this entity
     */
    public SpeedModifier(float maxspeed) {
        //some arbitrarily high value for health, since these should never break;
        super(1000000, new Texture("speed.png"));
        this.multiplier = maxspeed;

        if (multiplier < 200.0f) {
            color = Color.RED;
        }

        else {
            color = Color.GREEN;
        }

        setColor(color);
    }

}
