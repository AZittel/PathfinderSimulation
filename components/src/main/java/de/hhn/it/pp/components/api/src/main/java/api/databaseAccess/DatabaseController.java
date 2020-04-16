package de.hhn.it.pp.components.api.src.main.java.api.databaseAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import de.hhn.it.pp.components.api.src.main.java.api.models.*;

/**
 * This class communicates with and handles all internal request to the database
 */
public class DatabaseController implements Database {

    private static Connection connection;
    private static String dbPath = "/home/mmk/projects/PP_Project/gaming-pp-20-ss/components/src/main/java/de/hhn/it/pp/components/api/InventoryDatabase.db";

    /**
     *
     */
    public DatabaseController() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }

    /**
     *
     */
    @Override
    public void setup() {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Inventory" +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT NOT NULL, MAXWEIGHT INT NOT NULL, " +
                    "MAXVOLUME INT NOT NULL, CURRENTVALUE INT)";
            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS Item" +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT NOT NULL, WEIGHT INT NOT NULL, " +
                    "VOLUME INT NOT NULL, VALUE INT NOT NULL, " +
                    "INVENTORYID INT, FOREIGN KEY(INVENTORYID) " +
                    "REFERENCES INVENTORY(ID))";
            statement.executeUpdate(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @param name      name of the inventory e.g. "Freddys Inventory"
     * @param maxWeight maxWeight this inventory can handle
     * @param maxVolume maxVolume this inventory can handle
     */
    @Override
    public void addInventory(String name, int maxWeight, int maxVolume) {
        try {
            String sql = "INSERT INTO INVENTORY (NAME, MAXWEIGHT, MAXVOLUME) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, maxWeight);
            statement.setInt(3, maxVolume);
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @param id id of the inventory to be removed
     */
    @Override
    public void removeInventory(int id) {
        try {
            String sql = "DELETE FROM INVENTORY WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * @param inventory
     */
    @Override
    public void editInventory(Inventory inventory) {
        try {
            String sql = "UPDATE INVENTORY SET NAME = ?, MAXWEIGHT = ?, MAXVOLUME = ? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            //set fields to edit
            statement.setString(1, inventory.getName());
            statement.setInt(2, inventory.getMaxWeight());
            statement.setInt(3, inventory.getMaxVolume());
            //set ID of te inventory to edit
            statement.setInt(4, inventory.getId());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @param ids
     * @return
     */
    @Override
    public Collection<Inventory> retrieveInventories(Collection<Integer> ids) {
        ArrayList<Inventory> result = new ArrayList<Inventory>();

        try {
            String sql = "SELECT * FROM INVENTORY WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            for (Integer identifier : ids) {
                statement.setInt(1, identifier);
                try {
                    ResultSet resultSet = statement.executeQuery();
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("NAME");
                    int maxWeight = resultSet.getInt("MAXWEIGHT");
                    int maxVolume = resultSet.getInt("MAXVOLUME");
                    int currentValue;
                    try {
                        currentValue = resultSet.getInt("CURRENTVALUE");
                    } catch (NullPointerException exception) {
                        currentValue = 0;
                    }
                    result.add(new Inventory(id, name, maxWeight, maxVolume, currentValue));
                } catch (SQLException entryNotFound) {
                    //ignored
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
        return result;
    }

    /**
     * @param name   name of the Item
     * @param weight weight of this item
     * @param volume volume of this item
     * @param value  value of this item
     */
    @Override
    public void addItem(String name, int weight, int volume, int value, int inventoryId) {
        try {
            String sql = "INSERT INTO ITEM (NAME, WEIGHT, VOLUME, VALUE, INVENTORYID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, weight);
            statement.setInt(3, volume);
            statement.setInt(4, value);
            statement.setInt(5, inventoryId);
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @param id id of the item to be removed
     */
    @Override
    public void removeItem(int id) {
        try {
            String sql = "DELETE FROM ITEM WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @param item
     */
    @Override
    public void editItem(Item item) {
        try {
            String sql = "UPDATE ITEM SET NAME = ?, WEIGHT = ?, VOLUME = ?, VALUE = ?, INVENTORYID = ? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            //set fields to edit
            statement.setString(1, item.getName());
            statement.setInt(2, item.getWeight());
            statement.setInt(3, item.getVolume());
            statement.setInt(4, item.getValue());
            statement.setInt(5, item.getInventoryId());
            //set ID of te inventory to edit
            statement.setInt(6, item.getId());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @param ids a collection of id's of the items to be retrieved
     * @return
     */
    @Override
    public Collection<Item> retrieveItems(Collection<Integer> ids) {
        ArrayList<Item> result = new ArrayList<Item>();

        try {
            String sql = "SELECT * FROM ITEM WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            for (Integer identifier : ids) {
                statement.setInt(1, identifier);
                try {
                    ResultSet resultSet = statement.executeQuery();
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("NAME");
                    int weight = resultSet.getInt("WEIGHT");
                    int volume = resultSet.getInt("VOLUME");
                    int value = resultSet.getInt("VALUE");
                    int inventoryId = resultSet.getInt("INVENTORYID");
                    result.add(new Item(id, name, weight, volume, value, inventoryId));
                } catch (SQLException entryNotFound) {
                    //ignored
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
        return result;
    }
}
