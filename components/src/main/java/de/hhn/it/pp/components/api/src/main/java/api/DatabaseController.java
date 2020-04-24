package de.hhn.it.pp.components.api.src.main.java.api;

import de.hhn.it.pp.components.api.src.main.java.api.models.Inventory;
import de.hhn.it.pp.components.api.src.main.java.api.models.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * This class handles all complex operations on our models,
 * exchanging Items between different inventories, or solving the Knap Sack Problem
 * for an inventory and a all items.
 *
 * @author Dennis Schies
 * @version 1.0
 */
class DatabaseController {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(DatabaseController.class);

    private Database database;

    DatabaseController(Database database) {
        this.database = database;
    }

    /**
     * Moves an item from its current inventory to another inventory
     * if the weight and volume limits will not be exceeded.
     *
     * @param inventoryId the id of the inventory you want to move the item to
     */
    void moveItem(Item item, int inventoryId) {
        int id = item.getId();
        String name = item.getName();
        int weight = item.getWeight();
        int volume = item.getVolume();
        int value = item.getValue();
        int oldInventoryId = item.getInventoryId();

        if (database.getItemInventoryAllocation(weight, volume, inventoryId)) {
            database.editItem(new Item(id, name, weight, volume, value, inventoryId));
        }
    }

    /**
     * Returns a Collection of items which grant the greatest value by staying within the limitations of the inventory
     *
     * @param id the id of the inventory you want to solve the knap sack problem for
     */
    Collection<Item> knapSack(int id) {
        Inventory currentKnapSack = database.retrieveInventory(id);
        ArrayList<Item> itemSet = new ArrayList<>(database.retrieveAllItems());
        int itemNumber = itemSet.size();
        int maxWeight = currentKnapSack.getMaxWeight();
        int maxVolume = currentKnapSack.getMaxVolume();
        int[] weights = new int[itemNumber];
        int[] volumes = new int[itemNumber];
        int[] values = new int[itemNumber];
        int[][][] knapSackTable = new int[itemNumber + 1][maxWeight + 1][maxVolume + 1];
        int resultValue;
        ArrayList<Item> result = new ArrayList<>();

        //initializing the arrays
        for (int x = 0; x < itemNumber; x++) {
            weights[x] = itemSet.get(x).getWeight();
            volumes[x] = itemSet.get(x).getVolume();
            values[x] = itemSet.get(x).getValue();
        }

        if (itemNumber <= 0 || maxWeight <= 0 || maxVolume <= 0) {
            logger.info("no items or limitations set");
            return null;
        }

        //iterating over the 3-dimensional array to calculate the maximum possible value for this knap sack
        int icount;
        int wcount;
        int vcount;
        for (icount = 0; icount <= itemNumber; icount++) {
            for (wcount = 0; wcount <= maxWeight; wcount++) {
                for (vcount = 0; vcount <= maxVolume; vcount++)

                    if (icount == 0 || wcount == 0 || vcount == 0) {
                        knapSackTable[icount][wcount][vcount] = 0;
                    } else if (weights[icount - 1] <= wcount && volumes[icount - 1] <= vcount) {

                        knapSackTable[icount][wcount][vcount] = Math.max(knapSackTable[icount - 1][wcount][vcount], knapSackTable[icount - 1]
                                [wcount - weights[icount - 1]][vcount - volumes[icount - 1]] + values[icount - 1]);

                    } else {
                        knapSackTable[icount][wcount][vcount] = knapSackTable[icount - 1][wcount][vcount];
                    }
            }
        }

        //backtracking to determine the items which give the max value
        resultValue = knapSackTable[itemNumber][maxWeight][maxVolume];
        wcount = maxWeight;
        vcount = maxVolume;
        for (icount = itemNumber; icount > 0 && resultValue > 0; icount--) {

            if (resultValue == knapSackTable[icount - 1][wcount][vcount])
                continue;
            else {

                // This item is included.
                result.add(itemSet.get(icount - 1));

                // Since this weight is included its
                // value is deducted
                resultValue = resultValue - values[icount - 1];
                wcount = wcount - weights[icount - 1];
                vcount = vcount - volumes[icount - 1];
            }
        }
        return result;
    }
}
