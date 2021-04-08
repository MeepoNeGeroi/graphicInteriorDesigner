package com.ecorp.application.model.entity;

import javax.swing.text.html.ImageView;
import java.util.Objects;

public class Field {
    private int height;
    private int width;
    private int square;
    private ImageView image;

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public Field(){}

    public Field(int height, int width, int square) {
        this.height = height;
        this.width = width;
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return height == field.height &&
                width == field.width &&
                square == field.square;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, square);
    }

    @Override
    public String toString() {
        return "Field{" +
                "height=" + height +
                ", width=" + width +
                ", square=" + square +
                '}';
    }
}
