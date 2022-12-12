package com.ae2dms.bubblebobble.factory;

import com.ae2dms.bubblebobble.model.unremovable.environment.CeilingUnit;
import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * The CeilingUnitProducer is the specific factory of GameObject to create CeilingUnit.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */
public class CeilingUnitProducer implements gameObjectProducer {
    /**
     * Initialize CeilingUnit.
     *
     * @param world     InteractableWorld type, instance of the InteractableWorld class.
     * @param col       int type, means the horizontal position.
     * @param row       int type, means the vertical position.
     * @param direction int type, means left or right.
     * @return CeilingUnit type, create a CeilingUnit instance.
     */
    @Override
    public CeilingUnit produce(InteractableWorld world, int col, int row, int direction) {
        return new CeilingUnit(world, col, row);
    }
}
