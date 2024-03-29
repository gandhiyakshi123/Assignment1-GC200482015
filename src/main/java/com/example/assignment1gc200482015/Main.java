package com.example.assignment1gc200482015;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tableView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image(getClass().getResourceAsStream("/cloth.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Mytra clothing hub");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        //DBUtility.getMytraClothingFromDB();
        launch();
    }
}