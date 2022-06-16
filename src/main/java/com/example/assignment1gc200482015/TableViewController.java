package com.example.assignment1gc200482015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable
{

    public static void change_Scenes(ActionEvent event, String fxmlFileName) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Label label;

    @FXML
    private TableColumn<MyntraClothing, String> descriptionColumn;

    @FXML
    private TableColumn<MyntraClothing, String> genderColumn;

    @FXML
    private TableColumn<MyntraClothing, String> priceColumn;

    @FXML
    private TableColumn<MyntraClothing, String> primaryColorColumn;

    @FXML
    private TableColumn<MyntraClothing, String> productBrandColumn;

    @FXML
    private TableColumn<MyntraClothing, Integer> productIDColumn;

    @FXML
    private TableColumn<MyntraClothing, String> productNameColumn;

    @FXML
    private TableView<MyntraClothing> tableView;

    @FXML
    private Button viewChart;

    @FXML
    void viewChartOfMyntraClothing(ActionEvent event) throws IOException
    {
        SceneChangeToChartViewController.changeScenes(event,"sceneChangeToChartView.fxml");

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        // configure the columns to know where to get the information from the MyntraClothing object
        productIDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productBrandColumn.setCellValueFactory(new PropertyValueFactory<>("productBrand"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("priceString"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        primaryColorColumn.setCellValueFactory(new PropertyValueFactory<>("primaryColor"));

        // load the myntraClothings into the tableView
        tableView.getItems().addAll(DBUtility.getMytraClothingFromDB());
    }


}
