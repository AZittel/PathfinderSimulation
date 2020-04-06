package de.hhn.it.pp.components.api.src.main.java.api.services;

import de.hhn.it.pp.components.api.src.main.java.api.databaseAccess.DatabaseController;

/**
 * This classes purpose is to setup the database tables if needed
 */
public class AdminApiService {

    public static DatabaseController dbController;

    public void initilizeDatabase(){
        dbController = new DatabaseController();
        dbController.setup();
    }
}
