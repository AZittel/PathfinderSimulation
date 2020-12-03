package de.hhn.it.pp.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller extends Application {


  /**
   * the main method.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    System.out.println("java version: " + System.getProperty("java.version"));
    launch(args);
  }
  /**
   * The main entry point for all JavaFX applications. The start method is called after the init
   * method has returned, and after the system is ready for the application to begin running.
   *
   * <p>
   * NOTE: This method is called on the JavaFX Application Thread.
   * </p>
   *
   * @param primaryStage the primary stage for this application, onto which the application scene
   *                     can be set. Applications may create other stages, if needed, but they will
   *                     not be primary stages.
   * @throws Exception if something goes wrong
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AStarPathfinder.fxml"));
    AnchorPane pane = loader.<AnchorPane>load();
    primaryStage.setTitle("Pathfinder");

    Scene scene = new Scene(pane, pane.getPrefWidth(), pane.getPrefHeight());
    primaryStage.setMinWidth( pane.getPrefWidth());
    primaryStage.setMinHeight(pane.getPrefHeight());
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
