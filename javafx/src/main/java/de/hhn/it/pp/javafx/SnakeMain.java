package de.hhn.it.pp.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class SnakeMain extends Application {

  private static final org.slf4j.Logger logger =
          org.slf4j.LoggerFactory.getLogger(de.hhn.it.pp.javafx.Main.class);
private final int width = 1280;
private final int height =720;

  public static void main(String[] args) {
    System.out.println("java version: " + System.getProperty("java.version"));
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("javafx/src/main/resources/fxml/snake/Menu.fxml"));

  }
}
