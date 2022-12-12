package com.ae2dms.bubblebobble.model.unremovable.environment;

import com.ae2dms.bubblebobble.Main;
import com.ae2dms.bubblebobble.InteractableWorld;
import com.ae2dms.bubblebobble.model.MovableObject;
import com.ae2dms.bubblebobble.model.UnmovableObject;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The CeilingUnit class creates ceiling units to be used for the world.
 * A ceiling unit is a unit shaped like a square that is treated as a ceiling, with collision on all four sides.
 * The ceiling collides with any kind of game object.
 * Even if a game object is on top of a ceiling, the game object will be pushed down.
 *
 * @author Ke Liu
 */
public class CeilingUnit extends UnmovableObject {
    /**
     * Set the default ceilingUnit of snowfield.
     */
    private static Image image = new Image(String.valueOf(Main.class.getResource("image/iceFloor.jpg")));

    /**
     * Initialize the CeilingUnit.
     *
     * @param world  InteractableWorld type, the instance of InteractableWorld.
     * @param colNum int type, the horizontal position of ceilingUnit.
     * @param rowNum int type, the vertical position of ceilingUnit.
     */
    public CeilingUnit(InteractableWorld world, int colNum, int rowNum) {
        super(world, colNum, rowNum, Main.getUnitSize(), Main.getUnitSize());
    }

    /**
     * Set the ceilingUnit of prairie.
     */
    public static void setCeilingPrairie() {
        image = new Image(String.valueOf(Main.class.getResource("image/prairieFloor.jpg")));
    }

    /**
     * Set the ceilingUnit of snowfield.
     */
    public static void setCeilingSnowField() {
        image = new Image(String.valueOf(Main.class.getResource("image/iceFloor.jpg")));
    }

    /**
     * Set the ceilingUnit of rock.
     */
    public static void setCeilingRock() {
        image = new Image(String.valueOf(Main.class.getResource("image/rockFloor.jpg")));
    }

    /**
     * Set the ceilingUnit of desert.
     */
    public static void setCeilingDesert() {
        image = new Image(String.valueOf(Main.class.getResource("image/desertFloor.jpg")));
    }

    /**
     * Set the ceilingUnit of ocean.
     */
    public static void setCeilingOcean() {
        image = new Image(String.valueOf(Main.class.getResource("image/oceanFloor.jpg")));
    }

    /**
     * Set the ceilingUnit of woods.
     */
    public static void setCeilingWoods() {
        image = new Image(String.valueOf(Main.class.getResource("image/woodsFloor.jpg")));
    }

    /**
     * Set the ceilingUnit of volcano.
     */
    public static void setCeilingVolcano() {
        image = new Image(String.valueOf(Main.class.getResource("image/volcanoFloor.jpg")));
    }

    /**
     * Set the ceilingUnit of fantasy.
     */
    public static void setCeilingFantasy() {
        image = new Image(String.valueOf(Main.class.getResource("image/fantasyFloor.jpg")));
    }

    /**
     * CeilingUnit collides with the movableObject.
     *
     * @param movableObject MoveObject type, including hero, monster, boss, fruit, projectile of hero and boss.
     */
    public void collideWith(MovableObject movableObject) {
        if (this.overlaps(movableObject)) {
            moveBelowUnit(movableObject);
            movableObject.collideWithCeiling();
        }
    }

    /**
     * Draw the ceilingUnit on the canvas.
     *
     * @param graphicsContext GraphicsContext type, draw calls to a Canvas using a buffer.
     */
    @Override
    public void drawOn(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Keep movable objects from getting stuck in ceilingUnit.
     *
     * @param movableObject MoveObject type, including hero, monster, boss, fruit, projectile of hero and boss.
     */
    void moveBelowUnit(MovableObject movableObject) {
        movableObject.moveTo(new Point2D(movableObject.getX(), getY() + getHeight()));
    }

}
