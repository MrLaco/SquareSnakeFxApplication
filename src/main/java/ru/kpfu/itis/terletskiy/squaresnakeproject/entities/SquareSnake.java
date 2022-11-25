package ru.kpfu.itis.terletskiy.squaresnakeproject.entities;

import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.util.*;

public class SquareSnake extends Rectangle {
    public SquareSnake(double side, double startX, double startY) {
        super(side, side);

        super.setX(startX);
        super.setY(startY);

        super.setFill(Color.BLUEVIOLET);
    }

    public void resizeSnake() {
        double newSide = super.getHeight() + 2;

        super.setHeight(newSide);
        super.setWidth(newSide);
    }

    public Map<String, Double> moveW() {
        double newY = super.getY() - 5;
        super.setY(newY);

        return Map.of(
                "X", super.getX(),
                "Y", super.getY()
        );
    }

    public Map<String, Double> moveS() {
        double newY = super.getY() + 5;
        super.setY(newY);

        return Map.of(
                "X", super.getX(),
                "Y", super.getY()
        );
    }

    public Map<String, Double> moveA() {
        double newX = super.getX() - 5;
        super.setX(newX);

        return Map.of(
                "X", super.getX(),
                "Y", super.getY()
        );
    }

    public Map<String, Double> moveD() {
        double newX = super.getX() + 5;
        super.setX(newX);

        return Map.of(
                "X", super.getX(),
                "Y", super.getY()
        );
    }
}
