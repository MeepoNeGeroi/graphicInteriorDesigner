package com.ecorp.application.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private static Stage mainStage;
    private static Scene mainScene;

    private final int WIDTH = 600;
    private final int HEIGHT = 400;


    public void init() throws IOException {
        //log.debug("Loading FXML for main view from: {}", FXMLPath.MAIN);
        Parent rootNode = new FXMLLoader().load(getClass().getResourceAsStream(FXMLPath.MAIN));
        mainScene = new Scene(rootNode, WIDTH, HEIGHT);
    }

    public void start(Stage stage) throws Exception {
        mainStage = stage;
        stage.setTitle("Graphic Interior Designer");
        mainStage.setScene(mainScene);
        stage.show();
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static Scene getMainScene() {
        return mainScene;
    }

    public void changeScene(String fxml) {
        try {
            mainStage.getScene().setRoot((Parent) FXMLLoader.load(getClass().getResource(fxml)));
        } catch (IOException e) {

        }
    }
}
