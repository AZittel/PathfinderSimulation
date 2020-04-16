package de.hhn.it.pp.components.aimtrainer.provider;

import java.awt.*;


public class Target {

    //Location of Target defined in x and y
    private final Point location;

    //Dimension of Target defined in width and height
    private final Dimension scale;

    //Duration of Target defined in seconds
    private final int lifetime;

    private TargetState state;

    public Target(Point location, Dimension scale, int lifetime) {
        this.location = location;
        this.scale = scale;
        this.lifetime = lifetime;
        this.state = TargetState.ALIVE;
    }

    public void setState(TargetState state) {
        this.state = state;
    }

    public int getLifetime() {
        return lifetime;
    }

    public Point getLocation() {
        return location;
    }

    public Dimension getScale() {
        return scale;
    }

    public TargetState getState() {
        return state;
    }
}
