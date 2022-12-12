package com.ae2dms.bubblebobble.factory;

import com.ae2dms.bubblebobble.model.removable.projectile.HeroProjectile;
import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * The HeroProjectileProducer is the specific factory of GameObject to create HeroProjectile.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */

public class HeroProjectileProducer implements gameObjectProducer {
    /**
     * Initialize HeroProjectile.
     *
     * @param world     InteractableWorld type, instance of the InteractableWorld class.
     * @param col       int type, means the horizontal position.
     * @param row       int type, means the vertical position.
     * @param direction int type, means left or right.
     * @return HeroProjectile type, create a HeroProjectile instance.
     */
    @Override
    public HeroProjectile produce(InteractableWorld world, int col, int row, int direction) {
        return new HeroProjectile(world, col, row, direction);
    }
}
