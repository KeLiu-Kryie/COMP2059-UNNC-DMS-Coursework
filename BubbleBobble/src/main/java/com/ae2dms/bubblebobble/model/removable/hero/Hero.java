package com.ae2dms.bubblebobble.model.removable.hero;

import com.ae2dms.bubblebobble.*;
import com.ae2dms.bubblebobble.factory.HeroProjectileProducer;
import com.ae2dms.bubblebobble.marks.Marks;
import com.ae2dms.bubblebobble.model.MovableObject;
import com.ae2dms.bubblebobble.model.removable.fruit.Fruit;
import com.ae2dms.bubblebobble.sound.SoundEffect;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A Hero is a main.GameObject that is controllable by the player.
 * Of all the main.GameObject, only Hero has KeyBindings.
 * Hero can shoot HeroProjectiles, shield from attacks, trigger a special attack and collect Fruits for points.
 * Hero has three lives. And changing into enduring state after losing a life.
 * Game over once lose three lives.
 *
 * @author Ke Liu
 */
public class Hero extends MovableObject {
    private static final int JUMP_SPEED = 20;
    private static final int TERMINAL_VELOCITY_X = 4;
    private static final int SIZE = 40;
    private static final int WALK = 3;
    private static final int RUN = 7;
    private static final double RUN_ACCEL = 5;
    private static final int SHIELD_TIME = 100;
    private static final int STUN_TIME = 250;
    private static final int ENDURING_TIME = 150;
    private final int heorCircleOffset = 10;
    private final int heroCircleSize = SIZE + 20;
    private final double shieldTimerFactor = 0.009;
    private final double stunTimerFactor = 0.003;
    private final double endureTimerFactor = 0.005;
    private boolean isShielding;
    private int shieldTimer;
    private boolean isStunned;
    private int stunTimer;
    private boolean isEnduring;
    private int enduringTimer;
    private int shootDelay;
    private boolean isOnAPlatform;
    private double jumpSpeed;
    private boolean death = false;
    public static int heroLife = 3;
    public static boolean readyForSpecialAttack = true;

    /**
     * Initialize the hero.
     *
     * @param world  InteractableWorld type, the instance of InteractableWorld.
     * @param colNum int type, the horizontal position of hero.
     * @param rowNum int type, the vertical position of hero.
     */

    public Hero(InteractableWorld world, int colNum, int rowNum) {
        //initializes hero
        super(world, colNum, rowNum, SIZE, SIZE);

        image = new Image(String.valueOf(Main.class.getResource("image/heroRight.jpg")));
        isOnAPlatform = false;
        setTerminal_xVelocity(TERMINAL_VELOCITY_X);
        jumpSpeed = JUMP_SPEED;
        isShielding = false;
        shieldTimer = SHIELD_TIME;
        isStunned = false;
        stunTimer = STUN_TIME;
        shootDelay = 0;
        isEnduring = false;
        enduringTimer = ENDURING_TIME;
    }


    /**
     * Draw the hero on the canvas.
     * Different image for different direction.
     * Golden surrounding bubble circle in shielding state.
     * Red surrounding bubble circle in enduring state.
     * Black surrounding bubble circle in stunned state.
     *
     * @param graphicsContext GraphicsContext type, draw calls to a Canvas using a buffer.
     */

    public void drawOn(GraphicsContext graphicsContext) {
        //draws hero
        graphicsContext.drawImage(image, getX(), getY(), SIZE, SIZE);
        if (isShielding) {
            graphicsContext.setFill(Color.rgb(255, 255, 0, (shieldTimer * shieldTimerFactor)));
            graphicsContext.fillRoundRect(getX() - heorCircleOffset, getY() - heorCircleOffset, heroCircleSize, heroCircleSize, heroCircleSize, heroCircleSize);
        } else if (isEnduring) {
            graphicsContext.setFill(Color.rgb(255, 0, 0, (enduringTimer * endureTimerFactor)));
            graphicsContext.fillRoundRect(getX() - heorCircleOffset, getY() - heorCircleOffset, heroCircleSize, heroCircleSize, heroCircleSize, heroCircleSize);

        } else if (isStunned) {
            graphicsContext.setFill(Color.rgb(0, 0, 0, (stunTimer * stunTimerFactor)));
            graphicsContext.fillRoundRect(getX() - heorCircleOffset, getY() - heorCircleOffset, heroCircleSize, heroCircleSize, heroCircleSize, heroCircleSize);
        }
        graphicsContext.setFill(Color.BLACK);

    }

    /**
     * Hero can shoot projectile.
     * Once shoot, add it to the InteractableWorld.
     */

    public void shootProjectile() {
        //makes hero shoot projectile
        SoundEffect.play("/com/ae2dms/bubblebobble/sfx/shoot.wav");
        world.addHeroProjectile(new HeroProjectileProducer().produce(world, getX(), getY(), getDirection()));

    }

    /**
     * If the hero collide with Enemy in not shileding state or enduring state, then lose one life can back to the birth place.
     * In short enduring state after rebirth.
     *
     * @throws IOException If the target fxml in die function does not exist, then throw exception.
     */

    public void collideWithEnemy() throws IOException {
        //handles colliding with a enemy
        if (!isShielding && !isEnduring) {
            heroLife--;
            this.moveTo(new Point2D(100, 550));
            this.isEnduring = true;
            this.setxVelocity(0);
            this.setyVelocity(0);
            if (heroLife < 1) {
                die();
            }
        }
    }

    /**
     * Hero can jump if on the floor.
     */

    private void jump() {
        //handles jumping
        if (isOnAPlatform) {
            setY(getY() - 1);
            setyVelocity(-jumpSpeed);
            isOnAPlatform = false;
        }
    }

    /**
     * This method bids different actions with the pressing keyboard input.
     *
     * @param keyCode KeyCode type, character code for the value of the key triggered by the pressing on keyboard.
     */

    public void pressed(KeyCode keyCode) {
        switch (keyCode) {
            case UP:
                if (!isShielding && !isStunned) {
                    SoundEffect.play("/com/ae2dms/bubblebobble/sfx/jump.wav");
                    jump();
                }
                break;
            case LEFT:
                if (!isShielding && !isStunned) {
                    setxAccel(-RUN_ACCEL);
                    setDirection(-1);
                    image = new Image(String.valueOf(Main.class.getResource("image/heroLeft.jpg")));
                }
                break;
            case RIGHT:
                if (!isShielding && !isStunned) {
                    setxAccel(RUN_ACCEL);
                    setDirection(1);
                    image = new Image(String.valueOf(Main.class.getResource("image/heroRight.jpg")));
                }
                break;
            case SPACE:
                setTerminal_xVelocity(RUN);
                break;
            case Q:
                if (!isStunned) {
                    setxVelocity(0);
                    setxAccel(0);
                    isShielding = true;
                }
                break;
            case E:
                if (!isShielding && !isStunned) {
                    shootDelay -= 1;
                    if (shootDelay <= 0) {
                        shootProjectile();
                        shootDelay = 10;
                    }
                }
                break;
        }
    }

    /**
     * This method bids different actions with the releasing keyboard input.
     *
     * @param keyCode KeyCode type, character code for the value of the key triggered by the releasing on keyboard.
     */

    public void released(KeyCode keyCode) {
        switch (keyCode) {
            case LEFT:
            case RIGHT:
                setxAccel(0);
                break;
            case SPACE:
                setTerminal_xVelocity(WALK);
                break;
            case W:
                if (readyForSpecialAttack == true) {
                    world.addBubble();
                    readyForSpecialAttack = false;
                }
                break;
            case E:
                shootDelay = 0;
                break;
        }
    }

    /**
     * Set the horizontal velocity of hero to zero if collides with wall.
     */

    @Override
    public void collideWithWall() {
        setxVelocity(0);
    }

    /**
     * Hero dies then returns the game over interface.
     *
     * @throws IOException If the target fxml does not exist, then throw exception.
     */
    public void die() throws IOException {
        //handles death
        SoundEffect.play("/com/ae2dms/bubblebobble/sfx/death.wav");
        world.markToReset();
        death = true;
        Fruit fruit = null;
        new Marks(fruit.score);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/over.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Main.getSCENE_WIDTH(), Main.getSCENE_HEIGHT());
        Stage stage = Main.stage;
        stage.setTitle("Game Over");
        stage.setScene(scene);
        stage.show();
        this.heroLife = 3;
        fruit.score = 0;
        this.readyForSpecialAttack = true;
    }

    /**
     * Lose one life when collide with the projectile of boss if not in shielding or enduring state;
     * Return to the birthplace in enduring state if lose a life;
     * If lose all lives then die.
     *
     * @throws IOException If the target fxml does not exist, then throw exception.
     */

    public void collideWithProjectile() throws IOException {
        //handles collision with projectiles
        if (!isShielding && !isEnduring) {
            heroLife--;
            this.moveTo(new Point2D(100, 550));
            this.isEnduring = true;
            this.setxVelocity(0);
            this.setyVelocity(0);
            if (heroLife < 1) {
                die();
            }
        }
    }

    /**
     * Update the position and state of hero.
     */
    @Override
    public void update() {
        //updates position of hero, according to many variables
        //including whether or not the hero is shielding,
        //or if the hero is stunned
        super.update();
        if (isShielding) {
            shieldTimer -= 1;
            if (shieldTimer <= 0) {
                shieldTimer = 0;
                isShielding = false;
                isStunned = true;
            }
        } else {
            if (shieldTimer < SHIELD_TIME && !isStunned) {
                shieldTimer += 1;
            }
        }
        if (isStunned) {
            stunTimer -= 1;
            if (stunTimer <= 0) {
                isStunned = false;
                stunTimer = STUN_TIME;
                shieldTimer = SHIELD_TIME;
            }
        }
        if (isEnduring) {
            enduringTimer -= 1;
        }
        if (enduringTimer <= 0) {
            isEnduring = false;
            enduringTimer = ENDURING_TIME;
        }
    }

    /**
     * Hero lands on the floor and makes sound.
     */

    @Override
    public void collideWithFloor() {
        //handles collision with floor
        setyVelocity(0);
        if (!isOnAPlatform) {
            isOnAPlatform = true;
            SoundEffect.play("/com/ae2dms/bubblebobble/sfx/land.wav");

        }
    }

    /**
     * Set horizontal velocity to zero when collide with the ceiling;
     */

    @Override
    public void collideWithCeiling() {
        setyVelocity(0);
    }


    /**
     * Determine if it is a state of shielding.
     *
     * @return boolean type, true for shielding, false for unshielding.
     */
    public boolean getShielding() {
        //gets whether or not the hero is shielding on this frame and returns it
        return isShielding;
    }

    /**
     * Determine if it is a state of death.
     *
     * @return boolean type, true for death, false for survival.
     */
    public boolean isDeath() {
        return death;
    }
}