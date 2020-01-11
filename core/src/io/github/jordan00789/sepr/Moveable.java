package io.github.jordan00789.sepr;

public interface Moveable {

	/** Turns the entity left. */
	public void turnLeft();

	/** Turns the entity right. */
	public void turnRight();

	/** Moves the entity forward. */
	public void goForward();

	/** Moves the entity backward. */
	public void goBackward();

	/** Updates the entity's movement. */
	public void update(float delta);
}
