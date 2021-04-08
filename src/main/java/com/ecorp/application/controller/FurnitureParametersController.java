package com.ecorp.application.controller;

import com.ecorp.application.model.StaticFields;
import com.ecorp.application.model.entity.Furniture;
import com.ecorp.application.model.service.AddNewFurnitureService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class FurnitureParametersController {
    @FXML
    Button addNewFurniture;
    @FXML
    TextField height;
    @FXML
    TextField width;
    @FXML
    TextField id;
    @FXML
    TextField imagePath;

    public void addNewFurniture(ActionEvent actionEvent) throws FileNotFoundException {
        try {
            ImageView imageView = AddNewFurnitureService.INSTANCE.addNewFurniture(imagePath.getText(),
                    Integer.parseInt(height.getText()),
                    Integer.parseInt(width.getText()),
                    id.getText());

            Furniture furniture = new Furniture((int) imageView.getFitHeight(), (int) imageView.getFitWidth(),
                    (int) (imageView.getFitHeight() * imageView.getFitWidth()));
            furniture.setImage(imageView);
            furniture.setName(imageView.getId());

            StaticFields.furniture = furniture;

            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        }
        catch (Exception e){
            height.setText("");
            width.setText("");
            id.setText("");
        }
    }
}
