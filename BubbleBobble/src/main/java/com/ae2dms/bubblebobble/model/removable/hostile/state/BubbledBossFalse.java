package com.ae2dms.bubblebobble.model.removable.hostile.state;

import com.ae2dms.bubblebobble.model.GameObject;
import com.ae2dms.bubblebobble.model.removable.hostile.Boss;


/**
 * BubbledBossFalse demonstrates the behavior of Boss after changing state from bubbled to not bubbled.
 * It must implement the abstract method in the interface.
 *
 * @author Ke Liu
 */
public class BubbledBossFalse implements StateOfBoss {

    /**
     * Change the state of boss from bubbled to not bubbled.
     * Set horizontal velocity, vertical velocity and direction.
     *
     * @param boss Boss type, the instance of Boss.
     */
    @Override
    public void changeAttribute(Boss boss) {
        boss.setBubbled(false);
        boss.setxAccel(1.5);
        boss.setDirection(1);
        if (Math.random() < 0.5) {
            boss.reverseDirection();
        }
        boss.setyAccel(GameObject.getGRAVITY());
    }
}
