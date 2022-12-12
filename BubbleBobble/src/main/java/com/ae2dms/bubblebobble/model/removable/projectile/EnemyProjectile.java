package com.ae2dms.bubblebobble.model.removable.projectile;

import com.ae2dms.bubblebobble.*;
import com.ae2dms.bubblebobble.model.removable.hero.Hero;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.IOException;


/**
 * The EnemyProjectile class handles the specificities with the projectile being shot from an boss.
 * For ae2dms, the boss's projectile has a different color than the projectile of a hero.
 * It also can only hurt a hero.
 */
public class EnemyProjectile extends Projectile {
    private static final int SIZE = 35;
    private static final int SPEED = 15;

    private Image image;

    /**
     * Initialize the projectile of boss.
     *
     * @param world     InteractableWorld type, the instance of InteractableWorld.
     * @param x         int type, the initial horizontal position of the projectile of boss.
     * @param y         int type, the initial vertical position of the projectile of boss.
     * @param direction int type, the direction of the boss and the direction of the projectile.
     */

    public EnemyProjectile(InteractableWorld world, int x, int y, int direction) {
        super(x, y, SIZE, SIZE, world);
        this.setDirection(direction);
        setxVelocity(SPEED);
        setyAccel(0);

        isActive = true;
        activeFrames = 50;
        timer = activeFrames;
    }

    /**
     * Draw the projectile of boss on the canvas.
     *
     * @param graphicsContext GraphicsContext type, draw calls to a Canvas using a buffer.
     */

    @Override
    public void drawOn(GraphicsContext graphicsContext) {
        if (!isActive) {
            markToRemove();
        }
        graphicsContext.drawImage(image, getX(), getY(), SIZE, SIZE);
        graphicsContext.setFill(Color.BLACK);
    }

    /**
     * Update the position of the projectile of boss.
     */

    @Override
    public void update() {
        setY((int) (getY() + getyVelocity()));
        setX((int) (getX() + getxVelocity() * getDirection()));
        updateVelocity();

        if (getY() < 25) {
            setY(25);
        }

        if (timer < 0) {
            isActive = false;
        }
        timer -= 1;
        if (getDirection() > 0) {

            image = new Image(String.valueOf(Main.class.getResource("image/fireRight.jpg")));
        } else {
            image = new Image(String.valueOf(Main.class.getResource("image/fireLeft.jpg")));
        }
    }

    /**
     * EnemyProjectile collides with hero.
     *
     * @param hero Hero type, the instance of Hero.
     */


    public void collideWith(Hero hero) throws IOException {
        if (this.overlaps(hero) && isActive) {
            hero.collideWithProjectile();
        }
    }

    /**
     * Projectile of boss collides with the projectile of hero and then both disappear.
     *
     * @param heroProjectile HeroProjectile type, the projectile of the hero.
     */

    public void collideWith(HeroProjectile heroProjectile) {
        if (this.overlaps(heroProjectile)) {
            markToRemove();
        }
    }

}
