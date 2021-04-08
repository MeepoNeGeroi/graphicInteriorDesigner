package com.ecorp.application.model.service;

import com.ecorp.application.model.StaticFields;
import com.ecorp.application.model.entity.Furniture;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public enum CreateFurnitureService {
    INSTANCE;

    public Furniture createFurniture(ImageView prototype){
        ImageView furniture = new ImageView();
        furniture.setFitWidth(StaticFields.furniture.getWidth());
        furniture.setFitHeight(StaticFields.furniture.getHeight());
        furniture.setImage(prototype.getImage());
        furniture.setX(StaticFields.DEFAULT_X_SPAWN);
        furniture.setY(StaticFields.DEFAULT_Y_SPAWN);
        furniture.setOnMouseDragged(e -> {
            StaticFields.img.setX(e.getSceneX());
            StaticFields.img.setY(e.getSceneY());
        });

        Furniture fr = new Furniture((int)furniture.getFitHeight(), (int)furniture.getFitWidth(),
                (int)(furniture.getFitHeight() * furniture.getFitWidth()));

        fr.setImage(furniture);
        fr.setName(prototype.getId());

        if(StaticFields.furnitures == null){
            StaticFields.furnitures = new ArrayList<>();
        }
        StaticFields.furnitures.add(fr);
        return fr;
    }
}