package de.hhn.it.pp.components.api.src.main.java.api;

import de.hhn.it.pp.components.api.src.main.java.api.Database;
import de.hhn.it.pp.components.api.src.main.java.api.DatabaseController;

/**
 * This classes purpose is to setup the database tables if needed
 */
public abstract class AdminApiService {

    public static Database dbController;

    public static void initilizeDatabase(){
        dbController = new DatabaseController();
        dbController.setup();
    }
}
