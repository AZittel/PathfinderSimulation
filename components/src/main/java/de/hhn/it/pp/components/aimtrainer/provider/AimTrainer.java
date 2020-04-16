package de.hhn.it.pp.components.aimtrainer.provider;

import de.hhn.it.pp.components.aimtrainer.AimTrainerService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

public class AimTrainer implements AimTrainerService {


    @Override
    public void startGame(String nickname, Settings settings) throws IllegalParameterException {
        if(nickname.length() > 12){
            throw new IllegalParameterException("Nickname cannot have more than 12 characters");
        } else if (!settings.getDifficulty().toString().equals("AMATEUR")) {
            throw new IllegalParameterException("The chosen difficulty does not exist");
        }
    }

    @Override
    public void createTarget(double xpos, double ypos, int lifetime){

    }

    @Override
    public void breakTarget(double xpos, double ypos){

    }

    @Override
    public void addSessionScore(){

    }

    @Override
    public void showHighscoreList(){

    }
}