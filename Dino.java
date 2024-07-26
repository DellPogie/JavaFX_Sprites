
/* DellPogie 2024
   Java Portfolio using JavaFX Library
   Chrome Dino Runner Sprites */

package com.dellpogie.dino;

// add reference to javafx library
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

// dino class inherits from application class
public class Dino extends Application {

    private static final int FRAME_WIDTH = 96;  // set width of each frame
    private static final int FRAME_HEIGHT = 102; // set height of each frame
    private static final int NUM_FRAMES = 6;   // set maximum number of frames in the sprite
    private static final int FRAME_DURATION = 50; // set time duration of each frame in milliseconds

    private static final String strDinoName = "Little Red Dino";
    private static final int intDinoNameSpace = 20;

    private int currentFrame = 0;
    private Image imgDinoSprite;

    @Override
    public void start(Stage primaryStage) {

        // edited image file from my local desktop
        imgDinoSprite = new Image("file:C:/Users/dellp/OneDrive/Desktop/Java/DellPogie JavaFX/src/main/resources/com/dellpogie/dino/imgDinoSprites.png");

        Canvas canvas = new Canvas(FRAME_WIDTH, FRAME_HEIGHT + intDinoNameSpace);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(FRAME_DURATION), e -> {
            drawFrame(gc);
            currentFrame = (currentFrame + 1) % NUM_FRAMES;
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 300, 200);
        root.setStyle("-fx-background-color: black;");

        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/dellpogie/dino/dino.ico"))));

        primaryStage.setTitle("DellPogie JavaFX Sprites");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawFrame(GraphicsContext gc) {
        int frameX = currentFrame * FRAME_WIDTH;
        gc.clearRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT + intDinoNameSpace); // clear the canvas
        gc.setFill(Color.RED);
        gc.fillText(strDinoName, 0, 10); // draw dino name
        gc.drawImage(imgDinoSprite, frameX, 0, FRAME_WIDTH, FRAME_HEIGHT, 0, intDinoNameSpace, FRAME_WIDTH, FRAME_HEIGHT);
    }

    // this is the entry point
    public static void main(String[] args) {
        launch(args);
    }
}
