package com.ae2dms.bubblebobble.factory;

import com.ae2dms.bubblebobble.model.removable.hero.Hero;
import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * The HeroProducer is the specific factory of GameObject to create Hero.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */

public class HeroProducer implements gameObjectProducer {
    /**
     * Initialize Hero.
     *
     * @param world     InteractableWorld type, instance of the InteractableWorld class.
     * @param col       int type, means the horizontal position.
     * @param row       int type, means the vertical position.
     * @param direction int type, means left or right.
     * @return Hero type, create a Hero instance.
     */
    @Override
    public Hero produce(InteractableWorld world, int col, int row, int direction) {
        return new Hero(world, col, row);
    }
}
