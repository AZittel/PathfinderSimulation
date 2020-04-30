package de.hhn.it.pp.components.tetris.provider.io;

import de.hhn.it.pp.components.tetris.provider.logic.Board;

import java.io.*;
import java.util.Scanner;

public class SaveGame {

    //under heavy construction!!!

    public static void load(Board board){
        File file = new File("provider/save/savefile.txt");

        try {
            Scanner sc = new Scanner(file);
            board.setHighscore(sc.nextInt());
            sc.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    public static void save(Board board){
        File file = new File("rsc/data/save.txt");

        try {
            OutputStream stream = new FileOutputStream(file);
            try {
                stream.write(Integer.toString(board.getHighscore()).getBytes());
                stream.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }
}
