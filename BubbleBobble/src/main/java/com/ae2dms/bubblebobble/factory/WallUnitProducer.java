package com.ae2dms.bubblebobble.factory;

import com.ae2dms.bubblebobble.InteractableWorld;
import com.ae2dms.bubblebobble.model.unremovable.environment.WallUnit;

/**
 * The WallProducer is the specific factory of GameObject to create WallUnit.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */

public class WallUnitProducer implements gameObjectProducer {

    /**
     * create a WallUnit instance.
     *
     * @param world     InteractableWorld type, instance of the InteractableWorld class.
     * @param col       int type, means the horizontal position.
     * @param row       int type, means the vertical position.
     * @param direction int type, means left or right.
     * @return WallUnit type, create a WallUnit instance.
     */
    @Override
    public WallUnit produce(InteractableWorld world, int col, int row, int direction) {
        return new WallUnit(world, col, row);
    }
}
