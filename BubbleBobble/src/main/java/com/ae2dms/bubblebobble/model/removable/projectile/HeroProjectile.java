package com.ae2dms.bubblebobble.model.removable.projectile;

import com.ae2dms.bubblebobble.*;
import com.ae2dms.bubblebobble.model.removable.hostile.Boss;
import com.ae2dms.bubblebobble.model.removable.hero.Hero;
import com.ae2dms.bubblebobble.model.removable.hostile.Monster;
import com.ae2dms.bubblebobble.model.unremovable.environment.FloorUnit;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The HeroProjectile class handles the specificities with the projectile being shot from a hero.
 * For ae2dms, the hero's projectile has a different color than the projectile of an enemy.
 * It also can hurt an enemy and a boss.
 * Hero can stand on the project and float with the projectile.
 * If the projectiles from hero and boss overlap, then both disappear.
 *
 * @author Ke Liu
 */
public class HeroProjectile extends Projectile {
    private static final int SIZE = 20;
    private static final int SPEED = 15;
    private final int bubbleLeftHorizantal = 35;
    private final int bubbleRightHorizantal = 20;
    private final int bubbleVertical = 20;
    private final int bubbleHeroDistance = 40;

    /**
     * Initialize the projectile of hero.
     *
     * @param world     InteractableWorld type, the instance of InteractableWorld.
     * @param x         int type, the initial horizontal position of the projectile of hero.
     * @param y         int type, the initial vertical position of the projectile of hero.
     * @param direction int type, the direction of the hero and the direction of the projectile.
     */
    public HeroProjectile(InteractableWorld world, int x, int y, int direction) {
        super(x, y, SIZE, SIZE, world);
        this.setDirection(direction);
        setxVelocity(SPEED);
        setyAccel(0);

        isActive = true;
        activeFrames = 35;
        timer = activeFrames;
    }

    /**
     * Draw the projectile of hero on the canvas.
     *
     * @param graphicsContext GraphicsContext type, draw calls to a Canvas using a buffer.
     */

    @Override
    public void drawOn(GraphicsContext graphicsContext) {
        if (isActive) {
            graphicsContext.setFill(Color.rgb(102, 204, 255));
        } else {
            graphicsContext.setFill(Color.rgb(102, 204, 255, 0.6));
        }
        graphicsContext.fillOval(getX(), getY(), getWidth(), getHeight());
        graphicsContext.setFill(Color.BLACK);
    }

    /**
     * Update the position of the projectile of hero.
     */

    @Override
    public void update() {
        setY((int) (getY() + getyVelocity()));
        setX((int) (getX() + getxVelocity() * getDirection()));
        updateVelocity();

        if (getY() < 25) {
            setY(25);
        }

        if (timer < 0) {
            isActive = false;
        }

        if (timer < -200) {
            markToRemove();
        }
        timer -= 1;
    }

    /**
     * Hero can stand on the projectile of hero and float with the bubble.
     *
     * @param hero Hero type, the instance of Hero.
     */

    public void collideWith(Hero hero) {
        if ((this.getX() - bubbleLeftHorizantal < hero.getX() && this.getX() + bubbleRightHorizantal > hero.getX()) && this.getY() > hero.getY() + bubbleVertical && this.overlaps(hero)) {
            hero.setyVelocity(getyVelocity());
            hero.setY(getY() - bubbleHeroDistance);
            setyAccel(-0.5);
        }
    }

    /**
     * The vertical velocity of the projectile of hero will be zero if collide with floor.
     *
     * @param floorUnit
     */

    public void collideWith(FloorUnit floorUnit) {
        if (this.overlaps(floorUnit)) {
            setyVelocity(0);
        }
    }

    /**
     * Projectile of hero  collides with monster.
     *
     * @param monster Monster type, the common enemy.
     */

    public void collideWith(Monster monster) {
        if (this.overlaps(monster) && isActive) {
            monster.collideWithProjectile();
            markToRemove();
        }
    }

    /**
     * Projectile of hero collides with boss.
     *
     * @param boss Boss type, the special enemy.
     */
    public void collideWith(Boss boss) {
        if (this.overlaps(boss) && isActive) {
            boss.collideWithProjectile();
            markToRemove();
        }

    }

    /**
     * Projectile of hero collides with the projectile of boss and then both disappear.
     *
     * @param enemyProjectile EnemyProjectile type, the projectile of the boss.
     */

    public void collideWith(EnemyProjectile enemyProjectile) {
        if (this.overlaps(enemyProjectile)) {
            markToRemove();
        }
    }

}
