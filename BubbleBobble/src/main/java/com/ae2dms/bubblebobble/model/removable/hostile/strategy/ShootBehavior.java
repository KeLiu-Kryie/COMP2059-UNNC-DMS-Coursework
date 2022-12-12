package com.ae2dms.bubblebobble.model.removable.hostile.strategy;

import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * ShotBehaviour is the interface about a enemy can shoot or not.
 * The Shoot object should implement the abstract method in the interface.
 *
 * @author  Ke Liu
 */

public interface ShootBehavior {
    /**
     * Abstract method: the shoot behavior of enemy.
     * @param world InteractableWorld type, the instance of InteractableWorld.
     * @param x int type, the initial horizontal position of projectile.
     * @param y int type, the initial vertical position of projectile.
     * @param direction, int type, the direction of the enemy and the direction of projectile.
     */
    void shoot(InteractableWorld world, int x, int y, int direction);
}
