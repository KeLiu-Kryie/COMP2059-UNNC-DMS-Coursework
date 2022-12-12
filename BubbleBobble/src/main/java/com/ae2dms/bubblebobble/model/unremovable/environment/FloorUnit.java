package com.ae2dms.bubblebobble.model.unremovable.environment;

import com.ae2dms.bubblebobble.Main;
import com.ae2dms.bubblebobble.InteractableWorld;
import com.ae2dms.bubblebobble.model.MovableObject;
import com.ae2dms.bubblebobble.model.UnmovableObject;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The FloorUnit class creates floor units to be used for the world.
 * A floor unit is a unit shaped like a square that is treated as a floor,
 * with collision on the top, left, and right sides.
 * The floor collides with any kind of game object.
 * When an enemy is bubbled, the enemy will still be stopped by a floor unit above it.
 *
 * @author Ke Liu
 */
public class FloorUnit extends UnmovableObject {
    /**
     * Set the default FloorUnit of snowfield.
     */
    private static Image image = new Image(String.valueOf(Main.class.getResource("image/iceFloor.jpg")));

    /**
     * Initialize the FloorUnit.
     *
     * @param world  InteractableWorld type, the instance of InteractableWorld.
     * @param colNum int type, the horizontal position of FloorUnit.
     * @param rowNum int type, the vertical position of FloorUnit.
     */
    public FloorUnit(InteractableWorld world, int colNum, int rowNum) {
        super(world, colNum, rowNum, Main.getUnitSize(), Main.getUnitSize());
    }

    /**
     * Set the floor of prairie.
     */

    public static void setFloorPrairie() {
        image = new Image(String.valueOf(Main.class.getResource("image/prairieFloor.jpg")));
    }

    /**
     * Set the floor of snowfield.
     */
    public static void setFloorSnowField() {
        image = new Image(String.valueOf(Main.class.getResource("image/iceFloor.jpg")));
    }

    /**
     * Set the floor of rock.
     */
    public static void setFloorRock() {
        image = new Image(String.valueOf(Main.class.getResource("image/rockFloor.jpg")));
    }

    /**
     * Set the floor of desert.
     */
    public static void setFloorDesert() {
        image = new Image(String.valueOf(Main.class.getResource("image/desertFloor.jpg")));
    }

    /**
     * Set the floor of ocean.
     */
    public static void setFloorOcean() {
        image = new Image(String.valueOf(Main.class.getResource("image/oceanFloor.jpg")));
    }

    /**
     * Set the floor of woods.
     */
    public static void setFloorWoods() {
        image = new Image(String.valueOf(Main.class.getResource("image/woodsFloor.jpg")));
    }

    /**
     * Set the floor of volcano.
     */
    public static void setFloorVolcano() {
        image = new Image(String.valueOf(Main.class.getResource("image/volcanoFloor.jpg")));
    }

    /**
     * Set the floor of fantasy.
     */
    public static void setFloorFantasy() {
        image = new Image(String.valueOf(Main.class.getResource("image/fantasyFloor.jpg")));
    }

    /**
     * If the bottom of the movable object over the floor, then it jumps on the floor.
     * If the top of the movable object below the floor, then it cannot jump on the floor
     *
     * @param movableObject MoveObject type, including hero, monster, boss, fruit, projectile of hero and boss.
     */

    public void collideWith(MovableObject movableObject) {
        double top = movableObject.getY();
        double bottom = top + movableObject.getHeight();
        if (this.overlaps(movableObject) && movableObject.getyVelocity() > 0) {
            if (bottom <= getY() + getHeight()) {
                moveAboveUnit(movableObject);
                movableObject.collideWithFloor();
            }
            if (top > getY()) {
                moveBelowUnit(movableObject);
                movableObject.collideWithCeiling();
            }
        }
    }

    /**
     * Draw the FloorUnit on the canvas.
     *
     * @param graphicsContext GraphicsContext type, draw calls to a Canvas using a buffer.
     */
    @Override
    public void drawOn(GraphicsContext graphicsContext) {

        graphicsContext.drawImage(image, getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Move the movableObject over the floor.
     *
     * @param movableObject MoveObject type, including hero, monster, boss, fruit, projectile of hero and boss.
     */

    void moveAboveUnit(MovableObject movableObject) {
        movableObject.moveTo(new Point2D(movableObject.getX(), getY() - movableObject.getHeight()));
    }

    /**
     * Move the movableObject below the floor.
     *
     * @param movableObject MoveObject type, including hero, monster, boss, fruit, projectile of hero and boss.
     */

    void moveBelowUnit(MovableObject movableObject) {
        movableObject.moveTo(new Point2D(movableObject.getX(), getY() + getHeight()));
    }

}
