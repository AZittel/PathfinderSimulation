package de.hhn.it.pp.components.aimtrainer.provider;

import de.hhn.it.pp.components.aimtrainer.AimTrainerService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

import java.util.ArrayList;
import java.util.HashMap;

public class AimTrainer implements AimTrainerService {


    @Override
    public void changeSettings(Difficulty difficulty) throws IllegalStateException {
        if(!difficulty.toString().equals("AMATEUR")){
            throw new IllegalStateException("The chosen difficulty does not exist.");
        }
    }

    @Override
    public void startGame(String nickname, Settings settings) throws IllegalParameterException, IllegalStateException {
        if(nickname.length() > 12){
            throw new IllegalParameterException("Nickname cannot have more than 12 characters.");
        } else if (!settings.getDifficulty().toString().equals("AMATEUR")) {
            throw new IllegalStateException("Used type of Settings is not accessible or does not exist.");
        }
    }

    @Override
    public void createTarget(Difficulty difficulty) throws IllegalStateException {
        if(!difficulty.toString().equals("AMATEUR")){
            throw new IllegalStateException("The chosen difficulty does not exist.");
        }
    }

    @Override
    public void breakTarget(Target target) throws IllegalParameterException {
        if(target == null) {
            throw new IllegalParameterException("Target does not exist and can´t be broken.");
        }
    }

    @Override
    public void calculateSessionScore(ArrayList<TargetState> targetStates) throws IllegalParameterException {
        if(targetStates.isEmpty()){
            throw new IllegalParameterException("Provided list is Empty or does not exist.");
        }
    }

    @Override
    public void addSessionScore(int score) throws IllegalParameterException {
        if(score < 0){
            throw new IllegalParameterException("Parameter has an invalid Value.");
        }
    }

    @Override
    public void showHighScoreList(HashMap<String, Integer> highScores) throws IllegalParameterException{
        if(highScores.isEmpty()){
            throw new IllegalParameterException("Provided list is Empty or does not exist.");
        }
    }
}