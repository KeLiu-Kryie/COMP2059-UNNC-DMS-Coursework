package com.ae2dms.bubblebobble.factory;

import com.ae2dms.bubblebobble.model.removable.projectile.EnemyProjectile;
import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * The EnemyProjectileProducer is the specific factory of GameObject to create EnemyProjectile.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */
public class EnemyProjectileProducer implements gameObjectProducer {
    /**
     * Initialize EnemyProjectile.
     *
     * @param world     InteractableWorld type, instance of the InteractableWorld class.
     * @param col       int type, means the horizontal position.
     * @param row       int type, means the vertical position.
     * @param direction int type, means left or right.
     * @return EnemyProjectile type, create a EnemyProjectile instance.
     */
    @Override
    public EnemyProjectile produce(InteractableWorld world, int col, int row, int direction) {
        return new EnemyProjectile(world, col, row, direction);
    }
}
