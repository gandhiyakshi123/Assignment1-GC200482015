package com.example.assignment1gc200482015;

import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility
{
    private static String user = DBCrendentials.user;
    private static String password = DBCrendentials.password;
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/Yakshi200482015";

    public static ArrayList<MyntraClothing> getMytraClothingFromDB()
    {
        ArrayList<MyntraClothing> myntraClothings = new ArrayList<>();

        String sql = "SELECT * FROM myntraDataset;";

        try(
                Connection conn = DriverManager.getConnection(connectURL,user,password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
            )
        {
            while(resultSet.next())
            {
                 int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName");
                String productBrand = resultSet.getString("ProductBrand");
                String gender = resultSet.getString("Gender");
                String description = resultSet.getString("Description");
                String primaryColor = resultSet.getString("PrimaryColor");
                double price = resultSet.getDouble("price");

                myntraClothings.add(new MyntraClothing(productID, productName, productBrand, gender, description, primaryColor, price));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return myntraClothings;
    }

    //**********************************************************************************************************************************

    public static XYChart.Series<String, Double> getBrandByPrice() {
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName("Brand");

        String sql = "SELECT productBrand, price " +
                " FROM myntraDataset " +
                " WHERE productBrand IN('Gini and Jony','Highlander','spykar','parx');";

        try(
                Connection conn = DriverManager.getConnection(connectURL,user,password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next())
            {
                String productBrand = resultSet.getString("productBrand");
                double price = resultSet.getDouble("price");

                series.getData().add(new XYChart.Data<>(productBrand, price));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return series;
    }
}