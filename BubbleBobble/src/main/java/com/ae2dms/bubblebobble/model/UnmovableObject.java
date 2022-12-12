package com.ae2dms.bubblebobble.model;

import com.ae2dms.bubblebobble.InteractableWorld;

/**
 * UnmovableObject is an abstract class inheriting  from GameObject.
 * UnmovableObject does not have a velocity, acceleration,direction, and dimensions.
 * UnmovableObject includes WallUnit, CeilingUnit and FloorUnit.
 *
 * @author Ke Liu
 */
public abstract class UnmovableObject extends GameObject {
    /**
     * Initialize the UnmovableObject in input file.
     *
     * @param world  InteractableWorld type, the instanec of InteractableWorld.
     * @param colNum int type, the horizontal position of UnmovableObject.
     * @param rowNum int type, the vertical position of UnmovableObject.
     * @param width  int type, the width of UnmovableObject.
     * @param height int type, the height of UnmovableObject.
     */
    public UnmovableObject(InteractableWorld world, int colNum, int rowNum, int width, int height) {
        super(world, colNum, rowNum, width, height);
    }
}
