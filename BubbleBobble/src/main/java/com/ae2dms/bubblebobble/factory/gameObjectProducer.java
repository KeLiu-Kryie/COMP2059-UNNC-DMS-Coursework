package com.ae2dms.bubblebobble.factory;

import com.ae2dms.bubblebobble.model.GameObject;
import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * This gameObjectProducer is the interface to initialize the specific  GameObject.
 * All the game object class should implement the interface to create instance.
 *
 * @author Ke Liu
 */

public interface gameObjectProducer {
    /**
     * abstract method: Initialize the specific GameObject.
     *
     * @param world     InteractableWorld type, instance of the InteractableWorld class.
     * @param col       int type, means the horizontal position.
     * @param row       int type, means the vertical position.
     * @param direction int type, means left or right.
     * @return GameObject type, create a GameObject instance.
     */
    GameObject produce(InteractableWorld world, int col, int row, int direction);
}
