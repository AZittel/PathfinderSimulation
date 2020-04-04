package de.hhn.it.pp.components.spaceinvaders;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Controlling extends Rectangle {
    boolean alive = true;
    final String type;
    String direction;

    Controlling(int x, int y, int w, int h, String type, Color color){
        super(w, h, color);
        this.type = type;
        setTranslateX(x);
        setTranslateY(y);
    }
    void movement(ActionEvent event){
      /*  switch (direction){
            with Enum if its possible (input= object(key input) , objects cant be used with switch but the if statement sucks)
            case up:
            case down:
            case left:
            case right:

              }*/

        }
    }

