package de.hhn.it.pp.components.aimtrainer.provider;

public class Settings {

    //Describes the Difficulty for this Session
    private Difficulty difficulty;

    public Settings(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
