package com.ae2dms.bubblebobble.factory;

import com.ae2dms.bubblebobble.model.unremovable.environment.FloorUnit;
import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * The FloorUnitProducer is the specific factory of GameObject to create FloorUnit.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */
public class FloorUnitProducer implements gameObjectProducer {
    /**
     * Initialize FloorUnit.
     *
     * @param world     InteractableWorld type, instance of the InteractableWorld class.
     * @param col       int type, means the horizontal position.
     * @param row       int type, means the vertical position.
     * @param direction int type, means left or right.
     * @return FloorUnit type, create a FloorUnit instance.
     */
    @Override
    public FloorUnit produce(InteractableWorld world, int col, int row, int direction) {
        return new FloorUnit(world, col, row);
    }
}
