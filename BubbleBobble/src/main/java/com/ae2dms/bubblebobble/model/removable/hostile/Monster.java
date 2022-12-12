package com.ae2dms.bubblebobble.model.removable.hostile;

import com.ae2dms.bubblebobble.*;
import com.ae2dms.bubblebobble.model.removable.hostile.state.BubbledMonsterFalse;
import com.ae2dms.bubblebobble.model.removable.hostile.state.BubbledMonsterTrue;
import com.ae2dms.bubblebobble.model.removable.hostile.strategy.ShootNoWay;
import com.ae2dms.bubblebobble.sound.SoundEffect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Monster inherits from Enemy.
 * Monsters show up in all levels.
 * A monster is the common enemy with all the properties of enemy.
 *
 * @author Ke Liu
 */
public class Monster extends Enemy {
    private static final int SIZE = Main.getUnitSize() * 3;
    private static final int JUMP_SPEED = 20;
    private static final int TERMINAL_VELOCITY_X = 2;
    private final int monsterCircleSize = SIZE + 10;
    private Image leftImage = new Image(String.valueOf(Main.class.getResource("image/monsterLeft.gif")));
    private Image rightImage = new Image(String.valueOf(Main.class.getResource("image/monsterRight.gif")));

    /**
     * Initialize the monster.
     *
     * @param world  InteractableWorld type, the instance of InteractableWorld.
     * @param colNum int type, the horizontal position of monster.
     * @param rowNum int type, the vertical position of monster.
     */
    public Monster(InteractableWorld world, int colNum, int rowNum) {
        //initializes enemy
        super(world, colNum, rowNum, SIZE, SIZE);
        shootBehavior = new ShootNoWay();
        isOnAPlatform = false;
        jumpSpeed = JUMP_SPEED;
        setTerminal_xVelocity(TERMINAL_VELOCITY_X);

        setxAccel(1.5);
        setDirection(1);
        if (Math.random() < 0.5) {
            reverseDirection();
        }
        isBubbled = false;
        timer = BUBBLED_FRAMES;
        turningAwayFromShield = false;
        turningAwayCount = 10;
    }

    /**
     * Draw the monster on the canvas.
     * Different image for different direction.
     * If the enemy is in bubbled, then bubble wraps the enemy.
     *
     * @param graphicsContext GraphicsContext type, draw calls to a Canvas using a buffer.
     */
    @Override
    public void drawOn(GraphicsContext graphicsContext) {
        //draws monster
        if (getDirection() > 0) {
            image = rightImage;
        } else {
            image = leftImage;
        }
        graphicsContext.drawImage(image, getX(), getY(), SIZE, SIZE);
        if (isBubbled) {
            graphicsContext.setFill(Color.rgb(102, 204, 255, (timer * 0.002 + 0.15)));
            graphicsContext.fillRoundRect(getX() - enemyCircleOffset, getY() - enemyCircleOffset, monsterCircleSize, monsterCircleSize, monsterCircleSize, monsterCircleSize);
        }
        graphicsContext.setFill(Color.BLACK);
    }


    /**
     * update the position of monster.
     * Jump and change direction randomly.
     */

    @Override
    public void update() {
        //updates enemy, handling movement
        super.update();
        if (isBubbled) {
            timer -= 1;
            if (timer <= 0) {
                BubbledMonsterFalse bubbledEnemyFalse = new BubbledMonsterFalse();
                bubbledEnemyFalse.changeAttribute(this);
                timer = BUBBLED_FRAMES;
            }
        } else {
            if (Math.random() < CHANGE_MOVEMENT_CHANCE) {
                jump();
            }
            if (Math.random() < CHANGE_MOVEMENT_CHANCE) {
                reverseDirection();

            }
        }

    }

    /**
     * Change the state of monster to bubbled if collide with the projectile of hero.
     */

    public void collideWithProjectile() {
        //handles what to do if hit with a projectile by the hero
        if (!isBubbled) {
            SoundEffect.play("/com/ae2dms/bubblebobble/sfx/bubbled.wav");
            BubbledMonsterTrue bubbledTrue = new BubbledMonsterTrue();
            bubbledTrue.changeAttribute(this);
        }
    }
}

