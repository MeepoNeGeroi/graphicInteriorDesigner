package com.ecorp.application.controller;

import com.ecorp.application.model.StaticFields;
import com.ecorp.application.model.entity.Field;
import com.ecorp.application.model.entity.Furniture;
import com.ecorp.application.model.service.CreateFurnitureService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    Button addFurniture;
    @FXML
    Button delete;
    @FXML
    AnchorPane pane;
    @FXML
    ImageView bed;
    @FXML
    ImageView cupboard;
    @FXML
    ImageView chest;
    @FXML
    ImageView fon;
    @FXML
    Button ok;
    @FXML
    TextField height;
    @FXML
    TextField width;
    @FXML
    Label label1;
    @FXML
    Label label2;


    public void initialize() {
        fieldInit();
    }

    public void fieldInit() {
        fon.setFitHeight(StaticFields.field.getHeight());
        fon.setFitWidth(StaticFields.field.getWidth());
        fon.setX(StaticFields.WIDTH - (fon.getFitWidth() / 2));
        fon.setY(StaticFields.HEIGHT - (fon.getFitHeight() / 2));
    }

    public void createField(ActionEvent actionEvent) {
        try {
            int h = StaticFields.METER * Integer.parseInt(height.getText());
            int w = StaticFields.METER * Integer.parseInt(width.getText());

            Field field = new Field(h, w, h * w);
            StaticFields.field = field;

            ok.setVisible(false);
            height.setVisible(false);
            width.setVisible(false);
            label1.setVisible(false);
            label2.setVisible(false);
            bed.setDisable(false);
            cupboard.setDisable(false);
            chest.setDisable(false);
            addFurniture.setVisible(true);

            fieldInit();
        } catch (Exception e) {
            System.out.println("Incorrect input!");
        }
    }

    public void mousePressed(MouseEvent mouseEvent) throws IOException {
        StaticFields.img = (ImageView) mouseEvent.getSource();
        if(StaticFields.img.getId() != null) {
            openWindow(FXMLPath.INPUT_SIZE);
            if (StaticFields.furniture != null) {
                ImageView imageView = CreateFurnitureService.INSTANCE.createFurniture(StaticFields.img).getImage();
                imageView.setOnMousePressed(e -> {
                    delete.setVisible(true);
                    delete.setOnMousePressed(event -> {
                        imageView.setVisible(false);
                        delete.setVisible(false);
                    });
                    StaticFields.img = imageView;
                });
//            imageView.setOnKeyPressed(event -> {
//                System.out.println("1");
//                KeyCode key = event.getCode();
//                if(key.toString().toLowerCase().equals("a")){
//                    imageView.setRotate(imageView.getRotate() - StaticFields.DEFAULT_ROTATION);
//                }
//                if(key.toString().toLowerCase().equals("d")){
//                    imageView.setRotate(imageView.getRotate() + StaticFields.DEFAULT_ROTATION);
//                }
//            });
                pane.getChildren().add(imageView);
            }
        }
        StaticFields.furniture = null;
    }

    public void rotateFurniture(ActionEvent actionEvent){
        Button btn = (Button) actionEvent.getSource();

        if(btn.getText().equals("<-") && StaticFields.img.getId() == null){
            StaticFields.img.setRotate(StaticFields.img.getRotate() - StaticFields.DEFAULT_ROTATION);
        }
        if(btn.getText().equals("->") && StaticFields.img.getId() == null){
            StaticFields.img.setRotate(StaticFields.img.getRotate() + StaticFields.DEFAULT_ROTATION);
        }
    }

    private void openWindow(String fxml) throws IOException {
        Stage stage = new Stage();
        Parent rootNode = new FXMLLoader().load(getClass().getResourceAsStream(fxml));
        Scene scene = new Scene(rootNode, StaticFields.WINDOW_WIDTH, StaticFields.WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void addFurniture(ActionEvent actionEvent) throws IOException {
        StaticFields.furniture = null;

        openWindow(FXMLPath.ADD_NEW_FURNITURE);

        if(StaticFields.furniture != null){
            StaticFields.furniture.getImage().setOnMousePressed(event -> {
                try {
                    mousePressed(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            pane.getChildren().add(StaticFields.furniture.getImage());
            StaticFields.furniture = null;
        }
    }
}