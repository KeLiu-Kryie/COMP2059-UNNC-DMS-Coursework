package com.ae2dms.bubblebobble.model.removable.projectile;

import com.ae2dms.bubblebobble.InteractableWorld;
import com.ae2dms.bubblebobble.model.MovableObject;

/**
 * Projectile is a abstract class.
 * Projectile is shooted by a hero or a boss.
 * Enemy will be wrapped if collide with projectile of hero.
 * Hero will lose a life if collide with projectile of boss.
 *
 * @author Ke Liu
 */
public abstract class Projectile extends MovableObject {
    static final int TERMINAL_VELOCITY_Y = 5;
    boolean isActive;
    int activeFrames;
    int timer;

    /**
     * Initialize the project.
     *
     * @param x      int type, the initial horizontal position of the projectile.
     * @param y      int type, the initial vertical position of the projectile.
     * @param width  int type, the width of the projectile.
     * @param height int type, the height of the projectile.
     * @param world  InteractableWorld type, the instance of InteractableWorld.
     */


    Projectile(int x, int y, int width, int height, InteractableWorld world) {
        super(x, y, width, height, world);
    }

    /**
     * update the velocity of projectile.
     */
    void updateVelocity() {
        if (getxVelocity() > 0) {
            setxVelocity(getxVelocity() - 0.25);
        } else {
            setxVelocity(0);
        }

        if (Math.abs(getyVelocity()) < TERMINAL_VELOCITY_Y && !isActive) {
            setyVelocity(getyVelocity() - 0.1);
        }
    }

    @Override
    public void collideWithFloor() {
        // Nothing happen
    }

    @Override
    public void collideWithCeiling() {
        // Nothing happen
    }

    @Override
    public void collideWithWall() {
        // Nothing happen
    }

}

