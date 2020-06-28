package de.hhn.it.pp.components.craftingservice.provider;

import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.Inventory;
import de.hhn.it.pp.components.craftingservice.exceptions.NoActiveListenerException;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

/**
 * The crafting process which works independent from the rest of the program as an own Thread.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-09
 */
public class Crafting extends CraftingImplementation implements Runnable {
  private Inventory inventory;
  private CraftingPattern craftingPattern;

  /**
   * Constructor of the Crafting class.
   *
   * @param inventory       the used inventory
   * @param craftingPattern the used crafting pattern
   */
  public Crafting(Inventory inventory, CraftingPattern craftingPattern) {
    this.inventory = inventory;
    this.craftingPattern = craftingPattern;
  }

  @Override
  public void run() {
    // wait some time (crafting time)
    try {
      Thread.sleep(craftingPattern.getCraftingTime());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // add provided items into the inventory
    for (int i = 0; i < craftingPattern.getProvidedItems().size(); i++) {
      try {
        inventory.add(craftingPattern.getProvidedItems().get(i));
      } catch (IllegalParameterException e) {
        System.err.println(e.getMessage() + "\n");
      }
    }
    // crafting process has ended (callback notification)
    try {
      getListener().craftingEndedNotification(craftingPattern);
      removeListener(getCallbackNotificator());
    } catch (IllegalParameterException | NoActiveListenerException e) {
      System.err.println(e.getMessage() + "\n");
    }
    CraftingImplementation.setCraftingActive(false);
  }
}