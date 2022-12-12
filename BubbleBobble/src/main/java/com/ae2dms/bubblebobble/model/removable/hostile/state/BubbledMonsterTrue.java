package com.ae2dms.bubblebobble.model.removable.hostile.state;

import com.ae2dms.bubblebobble.model.removable.hostile.Monster;

/**
 *  BubbledMonsterTrue demonstrates the behavior of Monster after changing state from bubbled to not bubbled.
 *  It must implement the abstract method in the interface.
 *  @author  Ke Liu
 */

public class BubbledMonsterTrue implements StateOfMonster {
    /**
     * Change the state of monster from not bubbled state to bubbled state.
     * Set initial velocity zero. And float up.
     * @param monster Monster type, the instance of Monster.
     */
    @Override
    public void changeAttribute(Monster monster) {
        monster.setBubbled(true);
        monster.setxAccel(0);
        monster.setyVelocity(0);
        monster.setyAccel(-0.1);
    }
}
