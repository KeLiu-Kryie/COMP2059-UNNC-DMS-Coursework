package com.ae2dms.bubblebobble.model;

import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * MovableObject is an abstract class inheriting  from GameObject.
 * MovableObject has a velocity, acceleration, position, direction, and dimensions.
 * MovableObject includes hero, monster, boss, projectile of hero, projectile of boss, fruit.
 * Something happens when certain MovableObjects collide.
 *
 * @author Ke Liu
 */

public abstract class MovableObject extends GameObject {
    private static final double STATIC_FRICTION = 0.1;

    /**
     * Initialize the MovableObject in input file.
     *
     * @param world  InteractableWorld type, the instanec of InteractableWorld.
     * @param colNum int type, the horizontal position of MovableObject.
     * @param rowNum int type, the vertical position of MovableObject.
     * @param width  int type, the width of MovableObject.
     * @param height int type, the height of MovableObject.
     */
    public MovableObject(InteractableWorld world, int colNum, int rowNum, int width, int height) {
        super(world, colNum, rowNum, width, height);
    }

    /**
     * Initialize the MovableObject that are not in input file(including fruits, projectiles of hero and boss).
     *
     * @param x      int type, the horizontal position of MovableObject.
     * @param y      int type, the vertical position of MovableObject.
     * @param width  int type, the width of MovableObject.
     * @param height int type, the height of MovableObject.
     * @param world  InteractableWorld type, the instanec of InteractableWorld.
     */
    public MovableObject(int x, int y, int width, int height, InteractableWorld world) {
        super(x, y, width, height, world);
    }

    /**
     * Abstract method: MovableObject collides with floor.
     */

    public abstract void collideWithFloor();

    /**
     * Abstract method: MovableObject collides with ceiling.
     */
    public abstract void collideWithCeiling();

    /**
     * Abstract method: MovableObject collides with wall.
     */
    public abstract void collideWithWall();

    /**
     * Update the position and speed of MovableObject.
     */

    public void update() {
        //general update method of every game object
        if (Math.abs(getxVelocity()) < getTerminal_xVelocity()) {
            setxVelocity(getxVelocity() + getxAccel());
        }
        if (Math.abs(getxVelocity()) > STATIC_FRICTION) {
            if (getxVelocity() < 0) {
                setxVelocity(getxVelocity() + 1);
            } else {
                setxVelocity(getxVelocity() - 1);
            }
            setX((int) (getX() + getxVelocity()));
        }

        if (getyVelocity() < getTerminal_yVelocity()) {
            setyVelocity(getyVelocity() + getyAccel());
        }
        setY((int) (getY() + getyVelocity()));
        if (isOffScreen()) {
            if (getY() > world.getHeight()) {
                setY(0);
            } else {
                setY(world.getHeight());
            }
        }
    }

    /**
     * Reverse the MovableObject 's direction.
     */
    public void reverseDirection() {
        //reverses game object's direction
        setxAccel(getxAccel() * (-1));
        setDirection(getDirection() * -1);
    }

    /**
     * Set a movableObject can move.
     */
    protected void markToRemove() {
        //sets whether or not something can be removed
        setCanRemove(true);
    }

    /**
     * Check if a MovableObject is offscreen.
     *
     * @return boolean type, true for offscreen, false for onscreen.
     */
    protected boolean isOffScreen() {
        //checks if something is offscreen
        boolean xLow = getX() + getWidth() < 0;
        boolean xHigh = getX() > world.getWidth();
        boolean yLow = getY() + getHeight() < 0;
        boolean yHigh = getY() > world.getHeight();
        return xLow || xHigh || yLow || yHigh;
    }
}
