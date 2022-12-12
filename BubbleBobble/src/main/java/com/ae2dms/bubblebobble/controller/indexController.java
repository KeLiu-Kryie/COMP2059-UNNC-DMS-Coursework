package com.ae2dms.bubblebobble.controller;

import com.ae2dms.bubblebobble.GamePanel;
import com.ae2dms.bubblebobble.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The indexController controls the actions in homepage.
 * This is the controller of index.fxml file.
 *
 * @author Ke Liu
 */

public class indexController {

    @FXML
    private Button start;

    @FXML
    private Button mark;

    @FXML
    private Button help;

    @FXML
    private Button backGround;

    /**
     * If click the help button, then return the help interface.
     *
     * @param event MouseEvent type, here means mouse click the button.
     * @throws IOException If the target fxml file does not exist, then throw IOException.
     */

    @FXML
    void mouseClickedHelp(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/guide.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Main.getSCENE_WIDTH(), Main.getSCENE_HEIGHT());
        Stage stage = Main.stage;
        stage.setTitle("BubbleBobble Help");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * If click the hiScore button, then return the hiScore interface.
     *
     * @param event MouseEvent type, here means mouse click the button.
     * @throws IOException If the target fxml file does not exist, then throw IOException.
     */

    @FXML
    void mouseClickedMark(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/hiScore.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Main.getSCENE_WIDTH(), Main.getSCENE_HEIGHT());
        Stage stage = Main.stage;
        stage.setTitle("BubbleBobble Score Record");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * If click the background button, then return the background interface.
     *
     * @param event MouseEvent type, here means mouse click the button.
     * @throws IOException If the target fxml file does not exist, then throw IOException.
     */

    @FXML
    void mouseClickedBackGround(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/backGround.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Main.getSCENE_WIDTH(), Main.getSCENE_HEIGHT());
        Stage stage = Main.stage;
        stage.setTitle("BubbleBobble Background");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * If click the start button, then return the game interface and play.
     *
     * @param event MouseEvent type, here means mouse click the button.
     * @throws IOException If the target file does not exist, then throw IOException.
     */

    @FXML
    void mouseClickedStart(MouseEvent event) throws IOException {
        Stage stage = Main.stage;
        stage.setTitle("BubbleBobble");
        new GamePanel();

    }

    /**
     * If move the mouse over the help button, then change the color of button to yellow.
     *
     * @param event MouseEvent type, here means mouse moves over the button.
     */

    @FXML
    void mouseEnteredHelp(MouseEvent event) {
        help.setTextFill(Color.YELLOW);
    }

    /**
     * If move the mouse over the background button, then change the color of button to yellow.
     *
     * @param event MouseEvent type, here means mouse moves over the button.
     */

    @FXML
    void mouseEnteredBackGround(MouseEvent event) {
        backGround.setTextFill(Color.YELLOW);
    }

    /**
     * If move the mouse over the start button, then change the color of button to yellow.
     *
     * @param event MouseEvent type, here means mouse moves over the button.
     */

    @FXML
    void mouseEnteredStart(MouseEvent event) {
        start.setTextFill(Color.YELLOW);
    }

    /**
     * If move the mouse over the hiScore button, then change the color of button to yellow.
     *
     * @param event MouseEvent type, here means mouse moves over the button.
     */

    @FXML
    void mouseEnteredMark(MouseEvent event) {
        mark.setTextFill(Color.YELLOW);

    }

    /**
     * If the mouse moves away from the button, then changes the color of the button to white.
     *
     * @param event MouseEvent type, here means mouse moves away from the button.
     */

    @FXML
    void mouseExitedBackGround(MouseEvent event) {
        backGround.setTextFill(Color.WHITE);
    }

    /**
     * If the mouse moves away from the button, then changes the color of the button to white.
     *
     * @param event MouseEvent type, here means mouse moves away from the button.
     */
    @FXML
    void mouseExitedHelp(MouseEvent event) {
        help.setTextFill(Color.WHITE);
    }

    /**
     * If the mouse moves away from the button, then changes the color of the button to white.
     *
     * @param event MouseEvent type, here means mouse moves away from the button.
     */

    @FXML
    void mouseExitedStart(MouseEvent event) {
        start.setTextFill(Color.WHITE);
    }

    /**
     * If the mouse moves away from the button, then changes the color of the button to white.
     *
     * @param event MouseEvent type, here means mouse moves away from the button.
     */

    @FXML
    void mouseExitedMark(MouseEvent event) {
        mark.setTextFill(Color.WHITE);

    }
}
