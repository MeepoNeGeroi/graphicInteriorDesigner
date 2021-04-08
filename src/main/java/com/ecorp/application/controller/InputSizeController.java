package com.ecorp.application.controller;

import com.ecorp.application.model.StaticFields;
import com.ecorp.application.model.entity.Furniture;
import com.ecorp.application.model.service.SetFurnitureSizeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class InputSizeController {

    @FXML
    TextField width;
    @FXML
    TextField height;

    public void getSizes(ActionEvent event){
        try {
            int width = Integer.parseInt(this.width.getText());
            int height = Integer.parseInt(this.height.getText());

            SetFurnitureSizeService.INSTANCE.setSize(width, height);

            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        catch (Exception e){
            height.setText("");
            width.setText("");
        }
    }
}
