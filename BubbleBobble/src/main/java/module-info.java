module com.ae2dms.bubblebobble {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens com.ae2dms.bubblebobble to javafx.fxml;
    exports com.ae2dms.bubblebobble;
    exports com.ae2dms.bubblebobble.controller;
    opens com.ae2dms.bubblebobble.controller to javafx.fxml;
    exports com.ae2dms.bubblebobble.model.removable.projectile;
    opens com.ae2dms.bubblebobble.model.removable.projectile to javafx.fxml;
    exports com.ae2dms.bubblebobble.model;
    opens com.ae2dms.bubblebobble.model to javafx.fxml;
    exports com.ae2dms.bubblebobble.model.unremovable.environment;
    opens com.ae2dms.bubblebobble.model.unremovable.environment to javafx.fxml;
    exports com.ae2dms.bubblebobble.model.removable.fruit;
    opens com.ae2dms.bubblebobble.model.removable.fruit to javafx.fxml;
    exports com.ae2dms.bubblebobble.model.removable.hostile;
    opens com.ae2dms.bubblebobble.model.removable.hostile to javafx.fxml;
    exports com.ae2dms.bubblebobble.model.removable.hostile.state;
    opens com.ae2dms.bubblebobble.model.removable.hostile.state to javafx.fxml;
    exports com.ae2dms.bubblebobble.marks;
    opens com.ae2dms.bubblebobble.marks to javafx.fxml;
    exports com.ae2dms.bubblebobble.sound;
    opens com.ae2dms.bubblebobble.sound to javafx.fxml;
    exports com.ae2dms.bubblebobble.model.removable.hostile.strategy;
    opens com.ae2dms.bubblebobble.model.removable.hostile.strategy to javafx.fxml;
    exports com.ae2dms.bubblebobble.model.removable.hero;
    opens com.ae2dms.bubblebobble.model.removable.hero to javafx.fxml;
}