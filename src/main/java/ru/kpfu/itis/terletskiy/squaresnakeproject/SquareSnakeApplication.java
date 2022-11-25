package ru.kpfu.itis.terletskiy.squaresnakeproject;

import javafx.application.*;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.stage.*;
import ru.kpfu.itis.terletskiy.squaresnakeproject.entities.*;
import ru.kpfu.itis.terletskiy.squaresnakeproject.utils.*;

import java.io.*;
import java.util.*;

public class SquareSnakeApplication extends Application {

    private int SCORE = 0;

    static List<AppleImageView> apples = new LinkedList<>();
    static SquareSnake snake;
    static Text scoreText;
    static Scene mainScene;
    static ObservableList<Node> children;

    public SquareSnakeApplication() throws FileNotFoundException {
        snake = new SquareSnake(30, RandomUtil.getRandomDouble(500), RandomUtil.getRandomDouble(500));

        for (int i = 0; i < 5; i++) {
            apples.add(new AppleImageView(RandomUtil.getRandomDouble(500), RandomUtil.getRandomDouble(500)));
        }
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        Group group = new Group();

        children = group.getChildren();
        children.addAll(snake);
        children.addAll(apples);

        scoreText = new Text();
        scoreText.setText("Score: ");
        scoreText.setFont(new Font(40));
        scoreText.setX(30);
        scoreText.setY(50);
        scoreText.setStyle("-fx-font-weight: bold");

        children.add(scoreText);

        mainScene = new Scene(group, 600, 600);

        String pathToSnakeIcon = "src/main/resources/ru/kpfu/itis/terletskiy/squaresnakeproject/images/snake.png";

        primaryStage.setTitle("Welcome to SquareSnakeGame");
        primaryStage.getIcons()
                .add(new Image(new FileInputStream(pathToSnakeIcon))
        );
        primaryStage.setScene(mainScene);
        primaryStage.show();

        loadGame();
    }

    private void loadGame() {
        mainScene.setOnKeyPressed(key -> {
            switch (key.getCode()) {
                case W -> {
                    if (canMove("W")) {
                        try {
                            if (checkAndEatApple()) {
                                snake.resizeSnake();
                                updateScore();
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        snake.moveW();
                    }
                }
                case A -> {
                    if (canMove("A")) {
                        try {
                            if (checkAndEatApple()) {
                                snake.resizeSnake();
                                updateScore();
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        snake.moveA();
                    }
                }
                case S -> {
                    if (canMove("S")) {
                        try {
                            if (checkAndEatApple()) {
                                snake.resizeSnake();
                                updateScore();
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        snake.moveS();
                    }
                }
                case D -> {
                    if (canMove("D")) {
                        try {
                            if (checkAndEatApple()) {
                                snake.resizeSnake();
                                updateScore();
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        snake.moveD();
                    }
                }
            }
        });
    }

    private boolean checkAndEatApple() throws FileNotFoundException {
        AppleImageView tempApple = null;

        for (AppleImageView apple : apples) {
            if (Math.abs(apple.getX() - snake.getX()) <= 10 && Math.abs(apple.getY() - snake.getY()) <= 10) {
                tempApple = apple;
            }
        }

        if (tempApple != null) {
            children.remove(tempApple);
            apples.remove(tempApple);

            AppleImageView newApple =
                    new AppleImageView(RandomUtil.getRandomDouble(500), RandomUtil.getRandomDouble(500));

            children.add(newApple);
            apples.add(newApple);

            return true;
        }
        return false;
    }

    private boolean canMove(String moveTo) {
        double step = 5;

        double currentX = snake.getX();
        double currentY = snake.getY();

        switch (moveTo) {
            case "W" -> {
                return currentY - step > 0;
            }
            case "A" -> {
                return currentX - step > 0;
            }
            case "S" -> {
                return currentY + 35 < mainScene.getHeight();
            }
            case "D" -> {
                return currentX + 35 < mainScene.getWidth();
            }
            default -> {
                return false;
            }
        }
    }

    private void updateScore() {
        this.SCORE += 1;
        scoreText.setText("Score: " + SCORE);
    }
}
