package com.ae2dms.bubblebobble.model.removable.hostile.state;

import com.ae2dms.bubblebobble.model.removable.hostile.Boss;

/**
 *  BubbledBossTrue demonstrates the behavior of Boss after changing state from bubbled to not bubbled.
 *  It must implement the abstract method in the interface.
 * @author  Ke Liu
 */
public class BubbledBossTrue implements StateOfBoss {

    /**
     * Change the state of boss from not bubbled state to bubbled state.
     * Set initial velocity zero. And float up.
     * @param boss Boss type, the instance of Boss.
     */
    @Override
    public void changeAttribute(Boss boss) {
        boss.setBubbled(true);
        boss.setxAccel(0);
        boss.setyVelocity(0);
        boss.setyAccel(-0.1);
    }
}
