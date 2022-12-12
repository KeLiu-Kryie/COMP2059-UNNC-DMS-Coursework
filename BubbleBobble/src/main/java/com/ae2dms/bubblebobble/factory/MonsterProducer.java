package com.ae2dms.bubblebobble.factory;

import com.ae2dms.bubblebobble.model.removable.hostile.Monster;
import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * The MonsterProducer is the specific factory of GameObject to create Monster.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */

public class MonsterProducer implements gameObjectProducer {
    /**
     * Initialize Monster.
     *
     * @param world     InteractableWorld type, instance of the InteractableWorld class.
     * @param col       int type, means the horizontal position.
     * @param row       int type, means the vertical position.
     * @param direction int type, means left or right.
     * @return Monster type, create a Monster instance.
     */
    @Override
    public Monster produce(InteractableWorld world, int col, int row, int direction) {
        return new Monster(world, col, row);
    }
}
