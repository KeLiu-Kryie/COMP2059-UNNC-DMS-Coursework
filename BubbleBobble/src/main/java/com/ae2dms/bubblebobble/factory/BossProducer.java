package com.ae2dms.bubblebobble.factory;

import com.ae2dms.bubblebobble.model.removable.hostile.Boss;
import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * The BossProducer is the specific factory of GameObject to create Boss.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */
public class BossProducer implements gameObjectProducer {

    /**
     * Initialize Boss.
     *
     * @param world     InteractableWorld type, instance of the InteractableWorld class.
     * @param col       int type, means the horizontal position.
     * @param row       int type, means the vertical position.
     * @param direction int type, means left or right.
     * @return Boss type, create a Boss instance.
     */
    @Override
    public Boss produce(InteractableWorld world, int col, int row, int direction) {
        return new Boss(world, col, row);
    }
}
