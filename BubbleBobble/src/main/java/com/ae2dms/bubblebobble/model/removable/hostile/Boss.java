package com.ae2dms.bubblebobble.model.removable.hostile;

import com.ae2dms.bubblebobble.Main;
import com.ae2dms.bubblebobble.InteractableWorld;
import com.ae2dms.bubblebobble.model.removable.hostile.state.BubbledBossFalse;
import com.ae2dms.bubblebobble.model.removable.hostile.state.BubbledBossTrue;
import com.ae2dms.bubblebobble.model.removable.hostile.strategy.Shoot;
import com.ae2dms.bubblebobble.sound.SoundEffect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Boss inherits from Enemy.
 * Boss is a special enemy with larger size, faster moving speed and a special attack way --shooting.
 * If hero collides with the projectile of boss, the hero will lose one life.
 * The Boss shows up in the third level.
 *
 * @author Ke Liu
 */
public class Boss extends Enemy {
    private static final int SIZE = Main.getUnitSize() * 4;
    private static final int TERMINAL_VELOCITY_X = 3;
    private static int bossLife = 15;
    private final int bossCircleSize = SIZE + 10;
    private Image leftImage;
    private Image rightImage;

    /**
     * Initialize the Boss.
     *
     * @param world  InteractableWorld type, the instance of InteractableWorld.
     * @param colNum int type, the horizontal position of monster.
     * @param rowNum int type, the vertical position of monster.
     */

    public Boss(InteractableWorld world, int colNum, int rowNum) {
        //initializes enemy
        super(world, colNum, rowNum, SIZE, SIZE);
        shootBehavior = new Shoot();
        isOnAPlatform = false;
        jumpSpeed = JUMP_SPEED;
        setTerminal_xVelocity(TERMINAL_VELOCITY_X);
        leftImage = new Image(String.valueOf(Main.class.getResource("image/iceDragonRight.gif")));
        rightImage = new Image(String.valueOf(Main.class.getResource("image/iceDragonLeft.gif")));
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
     * Draw the boss on the canvas.
     * Different image for different direction.
     * If the boss is in bubbled, then bubble wraps the boss.
     *
     * @param graphicsContext GraphicsContext type, draw calls to a Canvas using a buffer.
     */
    @Override
    public void drawOn(GraphicsContext graphicsContext) {
        //draws boss
        if (getDirection() > 0) {
            image = leftImage;
        } else {
            image = rightImage;
        }
        graphicsContext.drawImage(image, getX(), getY(), SIZE, SIZE);
        if (isBubbled) {
            graphicsContext.setFill(Color.rgb(102, 204, 255, (timer * 0.002 + 0.15)));
            graphicsContext.fillRoundRect(getX() - enemyCircleOffset, getY() - enemyCircleOffset, bossCircleSize, bossCircleSize, bossCircleSize, bossCircleSize);
        }
        graphicsContext.setFill(Color.BLACK);
    }

    /**
     * Update the position of boss.
     * Jump and change direction randomly.
     */

    @Override
    public void update() {
        //updates enemy, handling movement
        super.update();
        if (isBubbled) {
            timer -= 1;
            if (timer <= 0) {
                bossLife = 15;
                timer = BUBBLED_FRAMES;
                BubbledBossFalse bubbledBossFalse = new BubbledBossFalse();
                bubbledBossFalse.changeAttribute(this);
            }
        } else {
            if (Math.random() < CHANGE_MOVEMENT_CHANCE) {
                jump();
            }
            if (Math.random() < CHANGE_MOVEMENT_CHANCE) {
                reverseDirection();
            }
            if (Math.random() < CHANGE_MOVEMENT_CHANCE) {
                performShoot();
            }
        }

    }

    /**
     * Lose a life if collide with the projectile of hero.
     * Change the state of monster to bubbled if has no life.
     */

    public void collideWithProjectile() {
        //handles what to do if hit with a projectile by the hero
        if (!isBubbled) {
            SoundEffect.play("/com/ae2dms/bubblebobble/sfx/bubbled.wav");
            bossLife--;
            if (bossLife < 0) {
                BubbledBossTrue bubbledBossTrue = new BubbledBossTrue();
                bubbledBossTrue.changeAttribute(this);
            }
        }
    }
}

