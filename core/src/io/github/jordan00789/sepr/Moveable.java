package io.github.jordan00789.sepr;

public interface Moveable {

    /**
     * Turns the entity left.
     */
    void turnLeft();

    /**
     * Turns the entity right.
     */
    void turnRight();

    /**
     * Moves the entity forward.
     */
    void goForward();

    /**
     * Moves the entity backward.
     */
    void goBackward();

    /**
     * Updates the entity's movement.
     * 
     * @param delta The change in time, in seconds
     */
    void update(float delta);
}
