package com.ecorp.application.model.service;

import com.ecorp.application.controller.MainController;
import com.ecorp.application.model.StaticFields;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public enum AddNewFurnitureService {
    INSTANCE;

    public ImageView addNewFurniture(String imagePath, int height, int width, String id) throws FileNotFoundException {
        InputStream stream = new FileInputStream(imagePath);
        Image image = new Image(stream);

        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setId(id);
        imageView.setFitWidth(width * StaticFields.METER);
        imageView.setFitHeight(height * StaticFields.METER);
        imageView.setX(StaticFields.newFurnitureX);
        imageView.setY(StaticFields.newFurnitureY);

        StaticFields.newFurnitureY += height * StaticFields.METER;

        return imageView;
    }
}