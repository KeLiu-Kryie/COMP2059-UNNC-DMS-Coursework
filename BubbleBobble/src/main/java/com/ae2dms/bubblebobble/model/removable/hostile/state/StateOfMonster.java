package com.ae2dms.bubblebobble.model.removable.hostile.state;

import com.ae2dms.bubblebobble.model.removable.hostile.Monster;

/**
 * StateOfMonster is the interface of Monster to change the attribute.
 * The Monster object should implement the abstract method in the interface.
 *
 * @author Ke Liu
 */

public interface StateOfMonster {
    /**
     * Abstract method: change the state of the Monster.
     *
     * @param monster Monster type, the instance of Monster.
     */
    void changeAttribute(Monster monster);
}
