package com.ae2dms.bubblebobble.model.unremovable.environment;

import com.ae2dms.bubblebobble.Main;
import com.ae2dms.bubblebobble.InteractableWorld;
import com.ae2dms.bubblebobble.model.MovableObject;
import com.ae2dms.bubblebobble.model.UnmovableObject;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The WallUnit class creates wall units to be used for the world.
 * A wall unit is an unit shaped like a square that is treated as a wall,
 * with collision on all four sides.
 * The wall collides with any kind of game object.
 *
 * @author Ke Liu
 */
public class WallUnit extends UnmovableObject {
    /**
     * Set the default WallUnit of snowfield.
     */
    private static Image image = new Image(String.valueOf(Main.class.getResource("image/iceWall.jpg")));

    /**
     * Initialize the WallUnit.
     *
     * @param world  InteractableWorld type, the instance of InteractableWorld.
     * @param colNum int type, the horizontal position of WallUnit.
     * @param rowNum int type, the vertical position of WallUnit.
     */

    public WallUnit(InteractableWorld world, int colNum, int rowNum) {
        super(world, colNum, rowNum, Main.getUnitSize(), Main.getUnitSize());
    }

    /**
     * Set the WallUnit of prairie.
     */

    public static void setWallPrairie() {
        image = new Image(String.valueOf(Main.class.getResource("image/prairieWall.jpg")));
    }

    /**
     * Set the WallUnit of snowfield.
     */
    public static void setWallSnowField() {
        image = new Image(String.valueOf(Main.class.getResource("image/iceWall.jpg")));
    }

    /**
     * Set the WallUnit of snowfield.
     */
    public static void setWallRock() {
        image = new Image(String.valueOf(Main.class.getResource("image/rockWall.jpg")));
    }

    /**
     * Set the WallUnit of desert.
     */
    public static void setWallDesert() {
        image = new Image(String.valueOf(Main.class.getResource("image/desertWall.jpg")));
    }

    /**
     * Set the WallUnit of ocean.
     */
    public static void setWallOcean() {
        image = new Image(String.valueOf(Main.class.getResource("image/oceanWall.jpg")));
    }

    /**
     * Set the WallUnit of woods.
     */
    public static void setWallWoods() {
        image = new Image(String.valueOf(Main.class.getResource("image/woodsWall.jpg")));
    }

    /**
     * Set the WallUnit of volcano.
     */
    public static void setWallVolcano() {
        image = new Image(String.valueOf(Main.class.getResource("image/volcanoWall.jpg")));
    }

    /**
     * Set the WallUnit of fantasy.
     */
    public static void setWallFantasy() {
        image = new Image(String.valueOf(Main.class.getResource("image/fantasyWall.jpg")));
    }

    /**
     * Keep movable objects from getting stuck in WallUnit.
     *
     * @param movableObject MoveObject type, including hero, monster, boss, fruit, projectile of hero and boss.
     */
    public void collideWith(MovableObject movableObject) {
        double center = movableObject.getX() + (movableObject.getWidth()) / 2;
        if (this.overlaps(movableObject)) {
            if (center > this.getX() + (this.getWidth()) / 2) {
                moveRightOfUnit(movableObject);
                movableObject.collideWithWall();
            } else if (center < this.getX() + (this.getWidth()) / 2) {
                moveLeftOfUnit(movableObject);
                movableObject.collideWithWall();
            }
        }
    }

    /**
     * Draw the WallUnit on the canvas.
     *
     * @param graphicsContext GraphicsContext type, draw calls to a Canvas using a buffer.
     */
    @Override
    public void drawOn(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Make the movableObject left to the WallUnit.
     *
     * @param movableObject MoveObject type, including hero, monster, boss, fruit, projectile of hero and boss.
     */
    void moveLeftOfUnit(MovableObject movableObject) {
        movableObject.moveTo(new Point2D(getX() - movableObject.getWidth(), movableObject.getY()));
    }

    /**
     * Make the movableObject right to the WallUnit.
     *
     * @param movableObject MoveObject type, including hero, monster, boss, fruit, projectile of hero and boss.
     */
    void moveRightOfUnit(MovableObject movableObject) {
        movableObject.moveTo(new Point2D(getX() + getWidth(), movableObject.getY()));
    }

}
