package com.ae2dms.bubblebobble.model.removable.fruit;

import com.ae2dms.bubblebobble.InteractableWorld;
import com.ae2dms.bubblebobble.Main;
import com.ae2dms.bubblebobble.model.MovableObject;
import com.ae2dms.bubblebobble.sound.SoundEffect;
import com.ae2dms.bubblebobble.model.removable.hero.Hero;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * The Fruit class handles how the fruit is created and interacts with the hero.
 * The fruits are created after a bubble containing an enemy is popped.
 * Hero only can pick the fruit on the floor.
 * @author  Ke Liu
 */
public class Fruit extends MovableObject {
	private static int SIZE = 25;
	private static final int TERMINAL_VELOCITY_Y = 10;
	private boolean readyToCollect;
	private Image image;
	private double possibility = Math.random();
	public static int score = 0;

	/**
	 * Initialize fruit.
	 * @param x	int type, the horizontal position of the fruit.
	 * @param y	int type, the vertical position of the fruit.
	 * @param world InteractableWold type, instance of the InteractableWorld class.
	 */

	public Fruit(int x, int y, InteractableWorld world) {
		//initializes fruit
		super(x, y, SIZE, SIZE, world);
		setTerminal_yVelocity(TERMINAL_VELOCITY_Y);
		readyToCollect = false;
			if (possibility <= 0.6) {
				image = new Image(String.valueOf(Main.class.getResource("image/apple.gif")));
			} else if (possibility <= 0.9) {
				image = new Image(String.valueOf(Main.class.getResource("image/banana.gif")));
			} else {
				image = new Image(String.valueOf(Main.class.getResource("image/coin.gif")));
			}
	}

	/**
	 * Draw the fruit on the canvas.
	 * @param graphicsContext	GraphicsContext type, draw calls to a Canvas using a buffer.
	 */
	@Override
	public void drawOn(GraphicsContext graphicsContext) {
		//draws fruit
		graphicsContext.drawImage(image, getX(), getY(), SIZE, SIZE);
		graphicsContext.setFill(Color.BLACK);
	}

	/**
	 * Fruits collide with hero, then make sounds, score, and remove.
	 * @param hero	Hero type, the instance of Hero.
	 */
	
	public void collideWith(Hero hero) {
		//checks for collision with hero and tells it what to do if it is colliding
		if (this.overlaps(hero) && readyToCollect) {

			SoundEffect.play("/com/ae2dms/bubblebobble/sfx/fruit.wav");
			if(possibility<=0.6){
				score += 100;
			}
			else if(possibility<=0.9){
				score += 200;
			}
			else{
				score += 500;
			}
			readyToCollect = false;
			markToRemove();
		}
	}

	/**
	 * The fruits land on the ground, set the vertical velocity to zero and change to a pickable state.
	 */

	@Override
	public void collideWithFloor() {
		setyVelocity(0);
		if (!isCanRemove()) {
			readyToCollect = true;
		}
	}

	/**
	 * Fruits collide with ceiling, nothing happens.
	 */

	@Override
	public void collideWithCeiling() {
		// Nothing happens
	}

	/**
	 * Fruits collide with wall, nothing happens.
	 */
	@Override
	public void collideWithWall() {
		// Nothing happens
	}
}
