package com.ae2dms.bubblebobble.model.removable.hostile;

import com.ae2dms.bubblebobble.InteractableWorld;
import com.ae2dms.bubblebobble.factory.FruitProducer;
import com.ae2dms.bubblebobble.model.MovableObject;
import com.ae2dms.bubblebobble.model.removable.hero.Hero;
import com.ae2dms.bubblebobble.model.removable.hostile.strategy.ShootBehavior;
import com.ae2dms.bubblebobble.model.unremovable.environment.CeilingUnit;
import com.ae2dms.bubblebobble.model.unremovable.environment.FloorUnit;
import com.ae2dms.bubblebobble.model.unremovable.environment.WallUnit;
import com.ae2dms.bubblebobble.sound.SoundEffect;

import java.io.IOException;

/**
 * Enemy is an abstract class.
 * An Enemy is a non-controllable main.GameObject that kills the main.Hero a life whenever it or its projectile comes in contact.
 * Enemies are able to be bubbled and free themselves from these bubbles after a period of time.
 * Enemies change direction at random intervals, when hitting a wall, and when hitting the main.Hero's shield.
 * Enemies jump at random intervals as well.
 * Fruit is generated when enemies are destroyed.
 *
 * @author Ke Liu
 */

public abstract class Enemy extends MovableObject {
    static final int JUMP_SPEED = 20;
    static final int BUBBLED_FRAMES = 300;
    static final double CHANGE_MOVEMENT_CHANCE = 0.01;
    boolean isBubbled;
    int timer;
    boolean turningAwayFromShield;
    int turningAwayCount;
    boolean isOnAPlatform;
    double jumpSpeed;
    protected ShootBehavior shootBehavior;
    final int enemyCircleOffset = 5;

    /**
     * All enemies can jump if on floor.
     */

    void jump() {
        //handles jumping
        if (isOnAPlatform) {
            setY(getY() - 1);
            setyVelocity(-jumpSpeed);
            isOnAPlatform = false;
        }
    }

    /**
     * Changing the direction of enemies after colliding with wall.
     */

    public void collideWithWall() {
        //handles what to do on collision with a wall
        setxVelocity(0);
        reverseDirection();
    }

    /**
     * Fruit is generated when enemies are destroyed.
     */

    void die() {
        //handles what to do on death
        world.addFruit(new FruitProducer().produce(world, getX(), getY(), 0));
        markToRemove();
    }

    /**
     * If enemies collide with a hero in shielding state then reverse the direction.
     * If enemies collide with a hero in normal state then make the hero lose a life.
     * If enemies collide with a hero with one life, then make hero die.
     *
     * @param hero Hero type, the instance of Hero.
     * @throws IOException If the target fxml file does not exist, then throw exception.
     */

    public void collideWith(Hero hero) throws IOException {
        //handles collision with hero and what to do
        if (this.overlaps(hero)) {
            if (!isBubbled) {
                hero.collideWithEnemy();
                if (hero.getShielding() && !turningAwayFromShield) {
                    turningAwayFromShield = true;
                    reverseDirection();
                }
            } else if (!isCanRemove()) {
                SoundEffect.play("/com/ae2dms/bubblebobble/sfx/pop.wav");
                die();

            }
        }
        if (turningAwayFromShield) {
            if (turningAwayCount <= 0) {
                turningAwayCount = 10;
                turningAwayFromShield = false;
            }
            turningAwayCount -= 1;
        }
    }

    /**
     * If the bubbled enemies collide with ceiling, stop moving.
     *
     * @param ceilingUnit CeilingUnit type, the instance of ceilingUnit.
     */
    public void collideWith(CeilingUnit ceilingUnit) {
        //handles unit collision
        if (this.overlaps(ceilingUnit)) {
            if (isBubbled) {
                setyVelocity(0);
                setyAccel(0);
            }
        }
    }

    /**
     * If the bubbled enemies collide with floor, stop moving.
     *
     * @param floorUnit FloorUnit type, the instance of FloorUnit.
     */

    public void collideWith(FloorUnit floorUnit) {
        //handles unit collision
        if (this.overlaps(floorUnit)) {
            if (isBubbled) {
                setyVelocity(0);
                setyAccel(0);
            }
        }
    }

    /**
     * If the bubbled enemies collide with floor, stop moving.
     *
     * @param wallUnit WallUnit type, the instance of WallUnit.
     */

    public void collideWith(WallUnit wallUnit) {
        //handles unit collision
        if (this.overlaps(wallUnit)) {
            if (isBubbled) {
                setyVelocity(0);
                setyAccel(0);
            }
        }
    }

    /**
     * Set state of Enemy bubbled.
     *
     * @param bubbled boolean type, true for bubbled , false for not bubbled.
     */
    public void setBubbled(boolean bubbled) {
        isBubbled = bubbled;
    }

    /**
     * Set the vertical velocity to zero when the enemies collide with floor.
     */
    @Override
    public void collideWithFloor() {
        //handles floor collision values
        setyVelocity(0);
        if (!isOnAPlatform) {
            isOnAPlatform = true;
        }
    }

    /**
     * Set the vertical velocity to zero when the enemies collide with ceiling.
     */

    @Override
    public void collideWithCeiling() {
        //handles ceiling collision values
        setyVelocity(0);
    }

    /**
     * Decides the enemy shoot or not.
     */
    public void performShoot() {
        shootBehavior.shoot(world, getX(), getY(), getDirection());
    }

    /**
     * Initialize the enemy.
     *
     * @param world  InteractableWorld type, the instance of InteractableWorld.
     * @param colNum int type, the horizontal position of enemy.
     * @param rowNum int type, the vertical position of enemy.
     * @param width  int type, the width of enemy.
     * @param height int type, the height of enemy.
     */

    public Enemy(InteractableWorld world, int colNum, int rowNum, int width, int height) {
        super(world, colNum, rowNum, width, height);
    }

}
