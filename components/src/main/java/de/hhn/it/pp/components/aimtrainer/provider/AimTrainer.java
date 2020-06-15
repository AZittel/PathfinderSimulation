package de.hhn.it.pp.components.aimtrainer.provider;

import de.hhn.it.pp.components.aimtrainer.AimTrainerService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

public class AimTrainer implements AimTrainerService {

    private Player player;
    public Settings settings;
    public Target target;
    public int score;

    public ArrayList<TargetState> targetStates;
    public HashMap<String, Integer> highScores;

    public AimTrainer() {
        targetStates = new ArrayList<>();
        highScores = new HashMap<>();
        settings = new Settings(Difficulty.BEGINNER);
    }

    @Override
    public void startGame(String nickname, Settings settings) throws IllegalParameterException, IllegalStateException {
        if(nickname.length() <= 12){
           this.player =  new Player(nickname);
        } else {
            throw new IllegalParameterException("Nickname cannot have more than 12 characters.");
        } if (!settings.getDifficulty().toString().equals("AMATEUR")) {
            throw new IllegalStateException("Used type of Settings is not accessible or does not exist.");
        }
    }

    @Override
    public void createTarget(Difficulty difficulty) throws IllegalStateException {

        this.target = new Target(new Point(0,0), new Dimension(100,100), 2);
        if(!difficulty.toString().equals("AMATEUR")){
            throw new IllegalStateException("The chosen difficulty does not exist.");
        }
    }

    @Override
    public void breakTarget(Target target) throws IllegalParameterException {
        if(target == null) {
            throw new IllegalParameterException("Target does not exist and can´t be broken.");
        }
        target.setState(TargetState.HIT);
        targetStates.add(target.getState());
    }

    public void missedTarget(Target target) throws IllegalParameterException {
        if(target == null){
            throw new IllegalParameterException("Target does not exst and can´t be broken.");
        }
        target.setState(TargetState.DEAD);
        targetStates.add(target.getState());
    }
    @Override
    public void calculateSessionScore(ArrayList<TargetState> targetStates) throws IllegalParameterException {
        if(targetStates.isEmpty()){
            throw new IllegalParameterException("Provided list is Empty or does not exist.");
        }
        this.score = 2;
    }

    @Override
    public void addSessionScore(int score) throws IllegalParameterException {
        if(score < 0){
            throw new IllegalParameterException("Parameter has an invalid Value.");
        }

        highScores.put(this.player.getNickname(), score);
    }

    @Override
    public void showHighScoreList(HashMap<String, Integer> highScores) throws IllegalParameterException{
        if(highScores.isEmpty()){
            throw new IllegalParameterException("Provided list is Empty or does not exist.");
        }
    }
}