package com.ae2dms.bubblebobble.controller;

import com.ae2dms.bubblebobble.*;
import com.ae2dms.bubblebobble.model.unremovable.environment.Background;
import com.ae2dms.bubblebobble.model.unremovable.environment.CeilingUnit;
import com.ae2dms.bubblebobble.model.unremovable.environment.FloorUnit;
import com.ae2dms.bubblebobble.model.unremovable.environment.WallUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The backGroundController controls the actions in background selection.
 * This is the controller of backGround.fxml file.
 * The selection of background, floor, ceiling and wall should follow the backGroundController.
 *
 * @author Ke Liu
 */

public class backGroundController {

    @FXML
    private Button back;

    @FXML
    private CheckBox snowField;

    @FXML
    private CheckBox prairie;

    @FXML
    private CheckBox rock;

    @FXML
    private CheckBox volcano;

    @FXML
    private CheckBox woods;

    @FXML
    private CheckBox desert;

    @FXML
    private CheckBox ocean;

    @FXML
    private CheckBox fantasy;


    /**
     * Initialize the background interface.
     * Select snowfield theme(background, wall, floor and ceiling) in default.
     */

    @FXML
    private void initialize() {
        snowField.setSelected(true);
        WallUnit.setWallSnowField();
        FloorUnit.setFloorSnowField();
        CeilingUnit.setCeilingSnowField();
        Background.setBackSnowField();
    }

    /**
     * If click the Desert checkbox, then select the Desert theme(background, wall, floor and ceiling).
     *
     * @param event ActionEvent type, here means mouse click.
     */

    @FXML
    void clickDesert(ActionEvent event) {
        desert.setSelected(true);
        if (desert.isSelected() == true) {
            snowField.setSelected(false);
            prairie.setSelected(false);
            volcano.setSelected(false);
            rock.setSelected(false);
            woods.setSelected(false);
            ocean.setSelected(false);
            fantasy.setSelected(false);
        }
        if (desert.isSelected() == true) {
            WallUnit.setWallDesert();
            FloorUnit.setFloorDesert();
            CeilingUnit.setCeilingDesert();
            Background.setBackDesert();
        }
    }

    /**
     * If click the Fantasy checkbox, then select the fantasy theme(background, wall, floor and ceiling).
     *
     * @param event ActionEvent type, here means mouse click.
     */

    @FXML
    void clickFantasy(ActionEvent event) {
        fantasy.setSelected(true);
        if (fantasy.isSelected() == true) {
            snowField.setSelected(false);
            prairie.setSelected(false);
            volcano.setSelected(false);
            rock.setSelected(false);
            woods.setSelected(false);
            ocean.setSelected(false);
            desert.setSelected(false);
        }
        if (fantasy.isSelected() == true) {
            WallUnit.setWallFantasy();
            FloorUnit.setFloorFantasy();
            CeilingUnit.setCeilingFantasy();
            Background.setBackFantasy();
        }
    }

    /**
     * If click the Ocean checkbox, then select the Ocean theme(background, wall, floor and ceiling).
     *
     * @param event ActionEvent type, here means mouse click.
     */

    @FXML
    void clickOcean(ActionEvent event) {
        ocean.setSelected(true);
        if (ocean.isSelected() == true) {
            snowField.setSelected(false);
            prairie.setSelected(false);
            volcano.setSelected(false);
            rock.setSelected(false);
            woods.setSelected(false);
            desert.setSelected(false);
            fantasy.setSelected(false);
        }
        if (ocean.isSelected() == true) {
            WallUnit.setWallOcean();
            FloorUnit.setFloorOcean();
            CeilingUnit.setCeilingOcean();
            Background.setBackOcean();
        }
    }

    /**
     * If click the Prairie checkbox, then select the Prairie theme(background, wall, floor and ceiling).
     *
     * @param event ActionEvent type, here means mouse click.
     */

    @FXML
    void clickPrairie(ActionEvent event) {
        prairie.setSelected(true);
        if (prairie.isSelected() == true) {
            snowField.setSelected(false);
            desert.setSelected(false);
            volcano.setSelected(false);
            rock.setSelected(false);
            woods.setSelected(false);
            ocean.setSelected(false);
            fantasy.setSelected(false);
        }
        if (prairie.isSelected() == true) {
            WallUnit.setWallPrairie();
            FloorUnit.setFloorPrairie();
            CeilingUnit.setCeilingPrairie();
            Background.setBackPrairie();
        }

    }

    /**
     * If click the Rock checkbox, then select the Rock theme(background, wall, floor and ceiling).
     *
     * @param event ActionEvent type, here means mouse click.
     */

    @FXML
    void clickRock(ActionEvent event) {
        rock.setSelected(true);
        if (rock.isSelected() == true) {
            snowField.setSelected(false);
            prairie.setSelected(false);
            volcano.setSelected(false);
            desert.setSelected(false);
            woods.setSelected(false);
            ocean.setSelected(false);
            fantasy.setSelected(false);
        }
        if (rock.isSelected() == true) {
            WallUnit.setWallRock();
            FloorUnit.setFloorRock();
            CeilingUnit.setCeilingRock();
            Background.setBackRock();
        }
    }

    /**
     * If click the Snowfield checkbox, then select the Snowfield theme(background, wall, floor and ceiling).
     *
     * @param event ActionEvent type, here means mouse click.
     */

    @FXML
    void clickSnowFiled(ActionEvent event) {
        snowField.setSelected(true);
        if (snowField.isSelected() == true) {
            desert.setSelected(false);
            prairie.setSelected(false);
            volcano.setSelected(false);
            rock.setSelected(false);
            woods.setSelected(false);
            ocean.setSelected(false);
            fantasy.setSelected(false);
        }

        if (snowField.isSelected() == true) {
            WallUnit.setWallSnowField();
            FloorUnit.setFloorSnowField();
            CeilingUnit.setCeilingSnowField();
            Background.setBackSnowField();
        }
    }

    /**
     * If click the Volcano checkbox, then select the Volcano theme(background, wall, floor and ceiling).
     *
     * @param event ActionEvent type, here means mouse click.
     */

    @FXML
    void clickVolcano(ActionEvent event) {
        volcano.setSelected(true);
        if (volcano.isSelected() == true) {
            snowField.setSelected(false);
            prairie.setSelected(false);
            desert.setSelected(false);
            rock.setSelected(false);
            woods.setSelected(false);
            ocean.setSelected(false);
            fantasy.setSelected(false);
        }
        if (volcano.isSelected() == true) {
            WallUnit.setWallVolcano();
            FloorUnit.setFloorVolcano();
            CeilingUnit.setCeilingVolcano();
            Background.setBackVolcano();
        }
    }

    /**
     * If click the Woods checkbox, then select the Woods theme(background, wall, floor and ceiling).
     *
     * @param event ActionEvent type, here means mouse click.
     */


    @FXML
    void clickWoods(ActionEvent event) {
        woods.setSelected(true);
        if (woods.isSelected() == true) {
            snowField.setSelected(false);
            prairie.setSelected(false);
            volcano.setSelected(false);
            rock.setSelected(false);
            desert.setSelected(false);
            ocean.setSelected(false);
            fantasy.setSelected(false);
        }
        if (woods.isSelected() == true) {
            WallUnit.setWallWoods();
            FloorUnit.setFloorWoods();
            CeilingUnit.setCeilingWoods();
            Background.setBackWoods();
        }

    }

    /**
     * If click back button, return to the homepage.
     *
     * @param event ActionEvent type, here means mouse click.
     * @throws IOException If the target fxml file does not exist, then throw IOException.
     */

    @FXML
    void onMouseClickedBack(MouseEvent event) throws IOException {
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
    void onMouseEnteredBack(MouseEvent event) {
        back.setTextFill(Color.YELLOW);
    }

    /**
     * If the mouse moves away from the button, then changes the color of the button to white.
     *
     * @param event MouseEvent type, here means mouse moves away from the button.
     */

    @FXML
    void onMouseExitedBack(MouseEvent event) {
        back.setTextFill(Color.WHITE);
    }
}
