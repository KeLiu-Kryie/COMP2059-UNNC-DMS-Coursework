package com.ae2dms.bubblebobble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Main class starts the program and open the homepage.
 *
 * @author Ke Liu
 */
public class Main extends Application {
    private static final int UNIT_SIZE = 20;
    static final int WIDTH = 40;
    static final int HEIGHT = 34;
    private final static int SCENE_WIDTH = 855;
    private final static int SCENE_HEIGHT = 680;
    public static Stage stage;

    /**
     * Load the homepage of the program.
     *
     * @param stage Stage type
     * @throws IOException If the target fxml file does not exist, then throw exception.
     */

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/index.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), SCENE_WIDTH, SCENE_HEIGHT);
        stage.setTitle("BubbleBobble Homepage");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Program starts here.
     *
     * @param args
     */

    public static void main(String[] args) {
        launch();
    }

    /**
     * Get the width of the scene.
     *
     * @return int type, the height of the scene.
     */

    public static int getSCENE_WIDTH() {
        return SCENE_WIDTH;
    }

    /**
     * Get the height of the scene.
     *
     * @return int type, the height of the scene.
     */
    public static int getSCENE_HEIGHT() {
        return SCENE_HEIGHT;
    }

    /**
     * Get the unit size.
     *
     * @return int type, the unit size.
     */
    public static int getUnitSize() {
        return UNIT_SIZE;
    }
}
