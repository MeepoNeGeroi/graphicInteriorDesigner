package com.ecorp.application.model;

import com.ecorp.application.model.entity.Field;
import com.ecorp.application.model.entity.Furniture;
import javafx.scene.image.ImageView;

import java.util.List;

public class StaticFields {
    public static Furniture furniture;
    public static Field field = new Field(1, 1, 1);
    public static List<Furniture> furnitures;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    public static final int METER = 50;
    public static final int DEFAULT_ROTATION = 10;
    public static final int DEFAULT_X_SPAWN = 120;
    public static final int DEFAULT_Y_SPAWN = 30;
    public static final int WINDOW_WIDTH = 200;
    public static final int WINDOW_HEIGHT = 300;
    public static int newFurnitureX = 30;
    public static int newFurnitureY = 230;
    public static ImageView img;
}
