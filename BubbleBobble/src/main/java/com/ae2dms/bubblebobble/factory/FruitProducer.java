package com.ae2dms.bubblebobble.factory;

import com.ae2dms.bubblebobble.model.removable.fruit.Fruit;
import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * The FruitProducer is the specific factory of GameObject to create Fruit.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */
public class FruitProducer implements gameObjectProducer {
    /**
     * Initialize Fruit.
     *
     * @param world     InteractableWorld type, instance of the InteractableWorld class.
     * @param col       int type, means the horizontal position.
     * @param row       int type, means the vertical position.
     * @param direction int type, means left or right.
     * @return Fruit type, create a Fruit instance.
     */
    @Override
    public Fruit produce(InteractableWorld world, int col, int row, int direction) {
        return new Fruit(col, row, world);
    }
}
