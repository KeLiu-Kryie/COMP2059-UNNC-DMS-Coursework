package com.ae2dms.bubblebobble.controller;

import com.ae2dms.bubblebobble.Main;
import com.ae2dms.bubblebobble.marks.Marks;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The hiScoreController controls the actions in hiScore interface.
 * This is the controller of hiScore.fxml file.
 *
 * @author Ke Liu
 */

public class hiScoreController {

    @FXML
    private Button back;

    @FXML
    private Label one;

    @FXML
    private Label two;

    @FXML
    private Label four;

    @FXML
    private Label three;

    @FXML
    private Label five;

    /**
     * Initialize the High Score List interface and list the top five score.
     *
     * @throws IOException If the target score list file does not exist, then throws exception.
     */

    @FXML
    private void initialize() throws IOException {
        Marks marks = new Marks();
        marks.readMarks();
        marks.order();
        one.setText("1st: " + marks.ranklist.get(0));
        two.setText("2nd: " + marks.ranklist.get(1));
        three.setText("3rd: " + marks.ranklist.get(2));
        four.setText("4th: " + marks.ranklist.get(3));
        five.setText("5th: " + marks.ranklist.get(4));

    }

    /**
     * If click back button, return to the homepage.
     *
     * @param event MouseEvent type, here means mouse click the button.
     * @throws IOException If the target fxml file does not exist, then throw IOException.
     */

    @FXML
    void onMouseClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/index.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Main.getSCENE_WIDTH(), Main.getSCENE_HEIGHT());
        Stage stage = Main.stage;
        stage.setTitle("BubbleBobble HomePage");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * If the mouse moves over the button, then changes the color of the button to yellow.
     *
     * @param event MouseEvent type, here means mouse moves over the button.
     */

    @FXML
    void onMouseEntered(MouseEvent event) {
        back.setTextFill(Color.YELLOW);
    }

    /**
     * If the mouse moves away from the button, then changes the color of the button to white.
     *
     * @param event MouseEvent type, here means mouse moves away from the button.
     */

    @FXML
    void onMouseExited(MouseEvent event) {
        back.setTextFill(Color.WHITE);
    }

}
