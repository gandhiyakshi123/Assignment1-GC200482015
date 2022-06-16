package com.example.assignment1gc200482015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import javafx.event.ActionEvent;

import javafx.scene.control.Button;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneChangeToChartViewController implements Initializable
{
    @FXML
    private Button viewTable;

    @FXML
    private BarChart<String, Double> barChart;

    @FXML
    void viewTableOfMyntraClothing(ActionEvent event) throws IOException {
        TableViewController.change_Scenes(event,"tableView.fxml");

    }

    public static void changeScenes(ActionEvent event, String fxmlFileName) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.getData().addAll(DBUtility.getBrandByPrice());

    }
}
