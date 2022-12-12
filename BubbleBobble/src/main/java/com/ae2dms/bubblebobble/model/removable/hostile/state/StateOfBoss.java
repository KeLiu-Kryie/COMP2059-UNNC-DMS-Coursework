package com.ae2dms.bubblebobble.model.removable.hostile.state;

import com.ae2dms.bubblebobble.model.removable.hostile.Boss;

/**
 * StateOfBoss is the interface of Boss to change the attribute.
 * The Boss object should implement the abstract method in the interface.
 *
 * @author Ke Liu
 */
public interface StateOfBoss {
    /**
     * Abstract method: change the state of the Boss.
     *
     * @param boss Boss type, the instance of Boss.
     */
    void changeAttribute(Boss boss);
}
