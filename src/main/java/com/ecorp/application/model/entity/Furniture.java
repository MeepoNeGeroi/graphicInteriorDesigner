package com.ecorp.application.model.entity;

import javafx.scene.image.ImageView;

import java.util.Objects;

public class Furniture {
    private int height;
    private int width;
    private int square;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Furniture(){}

    public Furniture(int height, int width, int square) {
        this.height = height;
        this.width = width;
        this.square = square;
    }

    public Furniture(int height, int width, int square, String name) {
        this.height = height;
        this.width = width;
        this.square = square;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return height == furniture.height &&
                width == furniture.width &&
                square == furniture.square &&
                Objects.equals(name, furniture.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, square, name);
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "height=" + height +
                ", width=" + width +
                ", square=" + square +
                ", name='" + name + '\'' +
                '}';
    }
}
