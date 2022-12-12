package com.ae2dms.bubblebobble.model;

import com.ae2dms.bubblebobble.Main;
import com.ae2dms.bubblebobble.InteractableWorld;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 * GameObjects are the objects on the InteractableWorld screen.
 * Movable GameObject has a velocity, acceleration, position, direction, and dimensions.
 * While unmovable GameObject don not have.
 * GameObjects can detect if they are overlapping another GameObject and
 * must implement methods of collisions with every type of Unit.
 *
 * @author Ke Liu
 */
public abstract class GameObject {
    public Image image;
    private static final int GRAVITY = 1;
    private static final int TERMINAL_FALL_SPEED = 20;
    public InteractableWorld world;
    private int x, y;
    private int width, height;
    private double xVelocity;
    private double yVelocity;
    private double xAccel;
    private double yAccel;
    private int terminal_xVelocity;
    private int terminal_yVelocity;
    private boolean canRemove;
    private int direction;


    /**
     * Initialize the GameObject in input file.
     *
     * @param world  InteractableWorld type, the instanec of InteractableWorld.
     * @param colNum int type, the horizontal position of GameObject.
     * @param rowNum int type, the vertical position of GameObject.
     * @param width  int type, the width of GameObject.
     * @param height int type, the height of GameObject.
     */
    public GameObject(InteractableWorld world, int colNum, int rowNum, int width, int height) {
        this.world = world;
        x = colNum * Main.getUnitSize();
        y = rowNum * Main.getUnitSize();
        this.width = width;
        this.height = height;
        initial();
        direction = 1;
    }

    /**
     * Initialize the GameObject that are not in input file(including fruits, projectiles of hero and boss).
     *
     * @param x      int type, the horizontal position of GameObject.
     * @param y      int type, the vertical position of GameObject.
     * @param width  int type, the width of GameObject.
     * @param height int type, the height of GameObject.
     * @param world  InteractableWorld type, the instanec of InteractableWorld.
     */
    public GameObject(int x, int y, int width, int height, InteractableWorld world) {
        //initializes the game object
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.world = world;
        initial();
        direction = -1;
    }

    /**
     * Get gravity.
     *
     * @return int type, return gravity.
     */

    public static int getGRAVITY() {
        return GRAVITY;
    }

    /**
     * Set the initial property of GameObject.
     */
    private void initial() {
        xVelocity = 0;
        yVelocity = 0;
        xAccel = 0;
        yAccel = GRAVITY;
        terminal_xVelocity = 0;
        terminal_yVelocity = TERMINAL_FALL_SPEED;
        canRemove = false;
    }

    /**
     * Abstract method: draw the GameObject on the canvas.
     *
     * @param graphicsContext GraphicsContext type, draw calls to a Canvas using a buffer.
     */

    public abstract void drawOn(GraphicsContext graphicsContext);

    /**
     * Set hit box of each GameObject.
     *
     * @return Rectangle2D type.
     */
    public Rectangle2D getHitbox() {
        //sets hitbox of each game object
        return new Rectangle2D(x, y, width, height);
    }

    /**
     * Check if two GameObjects overlap or collide.
     *
     * @param gameObject GameObject type.
     * @return boolean type, true of overlap, false of does not overlap.
     */
    protected boolean overlaps(GameObject gameObject) {
        //checks if two objects overlap or collide
        return getHitbox().intersects(gameObject.getHitbox());
    }

    /**
     * Move the GameObject to the ordered place.
     *
     * @param point Point2D type.
     */
    public void moveTo(Point2D point) {
        //moves object to a point
        x = (int) point.getX();
        y = (int) point.getY();
    }

    /**
     * Set horizontal position of GameObject.
     *
     * @param x int type, the horizontal position.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set vertical position of GameObject.
     *
     * @param y int type, the vertical position.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get vertical position of GameObject.
     *
     * @return int type, the horizontal position.
     */
    public int getX() {
        //returns x coordinate of upper left corner
        return x;
    }

    /**
     * Get vertical position of GameObject.
     *
     * @return int type, the vertical position.
     */
    public int getY() {
        //returns y coordinate of upper left corner
        return y;
    }

    /**
     * Get the width of GameObject.
     *
     * @return int type, the width of GameObject.
     */
    public int getWidth() {
        //returns width
        return width;
    }

    /**
     * Get the height of GameObject.
     *
     * @return int type, the height of GameObject.
     */
    public int getHeight() {
        //returns height
        return height;
    }

    /**
     * Get the horizontal velocity of the GameObject.
     *
     * @return double type, the horizontal velocity of GameObject.
     */

    public double getxVelocity() {
        return xVelocity;
    }

    /**
     * Set the horizontal velocity of the GameObject.
     *
     * @param xVelocity double type, the horizontal velocity of GameObject.
     */
    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    /**
     * Get the vertical velocity of the GameObject.
     *
     * @return double type, the vertical velocity of GameObject.
     */
    public double getyVelocity() {
        return yVelocity;
    }

    /**
     * Set the vertical velocity of the GameObject.
     *
     * @param yVelocity double type, the vertical velocity of GameObject.
     */
    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    /**
     * Get the horizontal acceleration of the GameObject.
     *
     * @return double type, the horizontal acceleration of the GameObject.
     */
    public double getxAccel() {
        return xAccel;
    }

    /**
     * Set the horizontal acceleration of the GameObject.
     *
     * @param xAccel double type, the horizontal acceleration of the GameObject.
     */
    public void setxAccel(double xAccel) {
        this.xAccel = xAccel;
    }

    /**
     * Get the vertical acceleration of the GameObject.
     *
     * @return double type, the vertical acceleration of the GameObject.
     */
    public double getyAccel() {
        return yAccel;
    }

    /**
     * Set the vertical acceleration of the GameObject.
     *
     * @param yAccel double type, the vertical acceleration of the GameObject.
     */

    public void setyAccel(double yAccel) {
        this.yAccel = yAccel;
    }

    /**
     * Get the maximum horizontal velocity.
     *
     * @return int type, the terminal horizontal velocity.
     */
    public int getTerminal_xVelocity() {
        return terminal_xVelocity;
    }

    /**
     * Set the maximum horizontal velocity.
     *
     * @param terminal_xVelocity int type, the terminal vertical velocity.
     */
    public void setTerminal_xVelocity(int terminal_xVelocity) {
        this.terminal_xVelocity = terminal_xVelocity;
    }

    /**
     * Get the maximum vertical velocity.
     *
     * @return int type, the terminal vertical velocity.
     */
    public int getTerminal_yVelocity() {
        return terminal_yVelocity;
    }

    /**
     * Set the maximum vertical velocity.
     *
     * @param terminal_yVelocity int type, the terminal vertical velocity.
     */

    public void setTerminal_yVelocity(int terminal_yVelocity) {
        this.terminal_yVelocity = terminal_yVelocity;
    }

    /**
     * Check if the GameObjects can move or not.
     *
     * @return boolean type, true for canRemove, false for cannot remove.
     */
    public boolean isCanRemove() {
        return canRemove;
    }

    /**
     * Set the GameObject can move or not.
     *
     * @param canRemove boolean type, true for canRemove, false for cannot remove.
     */

    public void setCanRemove(boolean canRemove) {
        this.canRemove = canRemove;
    }

    /**
     * Get the direction of GameObject
     *
     * @return int type, a num for left and another for right.
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Set the direction of GameObject
     *
     * @param direction int type, a num for left and another for right.
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
}
