package de.hhn.it.pp.components.spaceinvaders;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Random;

public class SpaceInvaders extends Application {
    //Variables
    private static final Random RDM = new Random();

    //Picture Delorean (Protagonist)
    static final Image Player_1 = new Image("java/de/hhn/it/pp/components/spaceinvaders/images/delorean.jpg");

    //Picture AlienEye (Antagonist)
    static final Image Enemy_1 = new Image("java/de/hhn/it/pp/components/spaceinvaders/images/AlienEye1.png");

    //GIF for killing Antagonist
    static final Image Explosion_1 = new Image("file:java/de/hhn/it/pp/components/spaceinvaders/images/Explosion.gif");


    @Override
    public void start(Stage stage) {
    }

}
