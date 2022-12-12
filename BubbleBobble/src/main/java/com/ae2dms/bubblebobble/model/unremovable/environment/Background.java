package com.ae2dms.bubblebobble.model.unremovable.environment;

import com.ae2dms.bubblebobble.Main;
import javafx.scene.image.Image;

/**
 * The BackGround class creates the background image.
 *
 * @author Ke Liu
 */
public class Background {
    private static Background instance = new Background();
    private Background(){};

    /**
     * Get the background instance.
     *
     * @return Background type, the Background instance.
     */
    public static Background getInstance() {
        return instance;
    }

    /**
     * Set the default background -- snowfield.
     */

    private static Image image = new Image(String.valueOf(Main.class.getResource("image/ice.jpg")));

    /**
     * Set the background of prairie.
     */

    public static void setBackPrairie() {
        image = new Image(String.valueOf(Main.class.getResource("image/prairie.jpg")));
    }

    /**
     * Set the background of snowfield.
     */
    public static void setBackSnowField() {
        image = new Image(String.valueOf(Main.class.getResource("image/ice.jpg")));
    }

    /**
     * Set the background of rock.
     */
    public static void setBackRock() {
        image = new Image(String.valueOf(Main.class.getResource("image/rock.jpg")));
    }

    /**
     * Set the background of desert.
     */
    public static void setBackDesert() {
        image = new Image(String.valueOf(Main.class.getResource("image/desert.jpg")));
    }

    /**
     * Set the background of ocean.
     */
    public static void setBackOcean() {
        image = new Image(String.valueOf(Main.class.getResource("image/ocean.jpg")));
    }

    /**
     * Set the background of woods.
     */
    public static void setBackWoods() {
        image = new Image(String.valueOf(Main.class.getResource("image/woods.jpg")));
    }

    /**
     * Set the background of volcano
     */
    public static void setBackVolcano() {
        image = new Image(String.valueOf(Main.class.getResource("image/volcano.jpg")));
    }

    /**
     * Set the background of fantasy.
     */
    public static void setBackFantasy() {
        image = new Image(String.valueOf(Main.class.getResource("image/fantasy.jpg")));
    }

    /**
     * Get the image of the background.
     *
     * @return Image type, the image of background.
     */
    public Image getBackground() {
        return image;
    }
}
