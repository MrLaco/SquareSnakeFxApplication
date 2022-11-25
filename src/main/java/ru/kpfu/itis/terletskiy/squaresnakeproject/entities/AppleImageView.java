package ru.kpfu.itis.terletskiy.squaresnakeproject.entities;

import javafx.scene.image.*;

import java.io.*;

public class AppleImageView extends ImageView {
    private static final String PATH_TO_IMG = "src/main/resources/ru/kpfu/itis/terletskiy/squaresnakeproject/images/apple.png";

    public AppleImageView(double startX, double startY) throws FileNotFoundException {
        super(new Image(new FileInputStream(PATH_TO_IMG)));

        super.setX(startX);
        super.setY(startY);

        super.setFitHeight(30);
        super.setFitWidth(30);
    }
}
