package com.ae2dms.bubblebobble.model.removable.hostile.strategy;

import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * Shoot class demonstrates that does not have the ability to shoot.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */
public class ShootNoWay implements ShootBehavior {
    /**
     * Do nothing, which means the enemy cannot shoot.
     *
     * @param world      InteractableWorld type, the instance of InteractableWorld.
     * @param x          int type, the initial horizontal position of projectile.
     * @param y          int type, the initial vertical position of projectile.
     * @param direction, int type, the direction of the enemy and the direction of projectile.
     */
    @Override
    public void shoot(InteractableWorld world, int x, int y, int direction) {

    }
}
