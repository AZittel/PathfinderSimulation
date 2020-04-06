package de.hhn.it.pp.components.api.src.main.java.api.databaseAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import de.hhn.it.pp.components.api.src.main.java.api.models.*;

/**
 * This class communicates with and handles all internal request to the database
 */
public class DatabaseController {

    private static Connection connection;

    public DatabaseController(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:components/src/main/java/de/hhn/it/pp/components/api/InventoryDatabase.db");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void setup(){
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Inventory" +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT NOT NULL, MAXWEIGHT INT NOT NULL, " +
                    "MAXVOLUME INT NOT NULL, CURRENTVALUE INT)";
            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Item" +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT NOT NULL, INT WEIGHT NOT NULL, " +
                    "INT VOLUME NOT NULL, INT VALUE NOT NULL, " +
                    "INT INVENTORYID, FOREIGN KEY(INVENTORYID) " +
                    "REFERENCES INVENTORY(ID))";
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void addInventory(String name, int maxWeight, int maxVolume){
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO INVENTORY (NAME, MAXWEIGHT, MAXVOLUME) " +
                    "VALUES (" + name + ", " + Integer.toString(maxWeight) + ", " +
                    Integer.toString(maxVolume) + ")";
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static Collection<Inventory> retrieveInventories(){
        ArrayList<Inventory> result = new ArrayList<Inventory>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM INVENTORY;");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                int maxWeight = resultSet.getInt("");
                int maxVolume = resultSet.getInt("");
                int currentValue;
                try {
                    currentValue = resultSet.getInt("CURRENTVALUE");
                }
                catch (NullPointerException exception) {
                    currentValue = 0;
                }
                result.add(new Inventory(id, name, maxWeight, maxVolume, currentValue));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }
}
