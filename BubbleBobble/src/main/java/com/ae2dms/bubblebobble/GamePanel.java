package com.ae2dms.bubblebobble;

import com.ae2dms.bubblebobble.model.removable.hero.Hero;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * The GamePanel is where the entire game is constantly updated and accept keyboard input.
 * After every few milliseconds, GamePanel calls the methods that update its InteractableWorld,
 * then repaints the window to display the new drawn graphics.
 *
 * @author Ke Liu
 */

public class GamePanel {
    InteractableWorld world = new InteractableWorld(Main.WIDTH * Main.getUnitSize(), Main.HEIGHT * Main.getUnitSize());
    Canvas canvas = new Canvas(Main.WIDTH * Main.getUnitSize(), Main.HEIGHT * Main.getUnitSize());
    Group root = new Group();
    Stage stage = Main.stage;
    GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private Refresh refresh = new Refresh();
    public static Hero self;
    private KeyProcess keyProcess = new KeyProcess();


    /**
     * Initialize the game panel and call refresh.
     *
     * @throws IOException If the target game map does not exist, throw the exception.
     */
    public GamePanel() throws IOException {
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();
        stage.getScene().setOnKeyReleased(keyProcess);
        stage.getScene().setOnKeyPressed(keyProcess);
        world.startGame();
        self = world.heroes.get(0);
        world.paintComponent(graphicsContext);
        refresh.start();
    }

    /**
     * Refresh is an inner class of GamePanel in charge of refreshing the game.
     */
    private class Refresh extends AnimationTimer {
        /**
         * Refresh until win the game or game over.
         *
         * @param now long type.
         */
        @Override
        public void handle(long now) {
            if (self.isDeath()) {
                refresh.stop();
                return;
            }
            try {
                world.updatePosition();
            } catch (IOException e) {
                e.printStackTrace();
            }
            graphicsContext.clearRect(0, 0, Main.WIDTH * Main.getUnitSize(), Main.HEIGHT * Main.getUnitSize());
            self = world.heroes.get(0);
            world.paintComponent(graphicsContext);
            if (world.monsters.isEmpty() && world.fruits.isEmpty()) {
                world.level++;
                try {
                    world.startGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (world.win == true) {
                    refresh.stop();
                    return;
                }
            }
        }
    }

    /**
     * KeyProcess is an inner class of GamePanel in charge of accept keyboard input.
     */
    private class KeyProcess implements EventHandler<KeyEvent> {
        /**
         * Monitor What key was pressed and what key was released.
         *
         * @param event KeyEvent type, Press a key and Release a key.
         */
        @Override
        public void handle(KeyEvent event) {
            KeyCode keyCode = event.getCode();
            if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                if (self != null) {
                    self.released(keyCode);
                }
            } else if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                if (self != null) {
                    self.pressed(keyCode);
                }
            }
        }
    }
}
