package de.hhn.it.pp.components.aimtrainer.provider;

public class Settings {

    //Describes the Difficulty for this Session
    private Difficulty difficulty;

    public Settings(){
        this.difficulty = Difficulty.AMATEUR;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
