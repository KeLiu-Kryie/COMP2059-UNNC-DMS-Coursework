package com.ae2dms.bubblebobble.model.removable.hostile.state;

import com.ae2dms.bubblebobble.model.GameObject;
import com.ae2dms.bubblebobble.model.removable.hostile.Monster;

/**
 * BubbledBossFalse demonstrates the behavior of Mock after changing state from bubbled to not bubbled.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */

public class BubbledMonsterFalse implements StateOfMonster {
    /**
     * Change the state of monster from bubbled to not bubbled.
     * Set horizontal velocity, vertical velocity and direction.
     * @param monster Monster type, the instance of Monster.
     */
    @Override
    public void changeAttribute(Monster monster) {
        monster.setBubbled(false);
        monster.setxAccel(1.5);
        monster.setDirection(1);
        if (Math.random() < 0.5) {
            monster.reverseDirection();
        }
        monster.setyAccel(GameObject.getGRAVITY());
    }
}
