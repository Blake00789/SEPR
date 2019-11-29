package io.github.jordan00789.sepr;

import java.util.Vector;

public interface Movable {
    public void setPos(Vector<Float> coordinate);
    public void movePos(int direction, int speed);
}
