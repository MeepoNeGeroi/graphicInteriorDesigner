package com.ecorp.application.model.service;

import com.ecorp.application.model.StaticFields;
import com.ecorp.application.model.entity.Furniture;

public enum SetFurnitureSizeService {
    INSTANCE;

    public void setSize(int width, int height){
        StaticFields.furniture = new Furniture();
        StaticFields.furniture.setHeight(height * StaticFields.METER);
        StaticFields.furniture.setWidth(width * StaticFields.METER);
        StaticFields.furniture.setSquare(width * height * StaticFields.METER * StaticFields.METER);
    }
}
