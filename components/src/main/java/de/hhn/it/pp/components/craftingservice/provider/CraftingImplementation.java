package de.hhn.it.pp.components.craftingservice.provider;

import de.hhn.it.pp.components.craftingservice.CraftingListener;
import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.CraftingService;
import de.hhn.it.pp.components.craftingservice.Inventory;
import de.hhn.it.pp.components.craftingservice.Item;
import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.OperationNotSupportedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the component.CraftingService.
 * Contains everything which is needed to craft new objects.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-06-11
 */
public class CraftingImplementation implements CraftingService {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(CraftingImplementation.class);
  // stores all crafting patterns
  private Map<String, CraftingPattern> craftingPatterns;
  // initialize the callback notificator
  private static CraftingListener callbackNotificator = new Callback();
  // references a current crafting listener
  private static CraftingListener listener;
  // secures that only one Crafting - Thread can be active at a time
  private static boolean craftingActive;
  // no list for Threads needed because implementation allows only 1 Crafting - Thread at a time
  private static Thread currentThread;

  /**
   * The standard constructor for the implementation of the CraftingService.
   */
  public CraftingImplementation() {
    craftingPatterns = new HashMap<>();
  }

  @Override
  public void addCraftingPattern(CraftingPattern pattern) throws IllegalParameterException {
    if (pattern == null) {
      throw new IllegalParameterException("Crafting pattern was null reference!\n");
    }
    craftingPatterns.put(pattern.toString(), pattern);
    logger.info("addCraftingPattern: pattern = {}", pattern);
  }

  @Override
  public void removeCraftingPattern(String patternName) throws IllegalParameterException,
      OperationNotSupportedException {
    if (patternName == null) {
      throw new IllegalParameterException("Pattern-name was null reference!\n");
    }
    if (craftingPatterns.isEmpty()) {
      throw new OperationNotSupportedException("There are no patterns to remove!\n");
    }
    if (craftingPatterns.get(patternName) == null) {
      throw new IllegalParameterException("'" + patternName + "' doesn't exist!\n");
    } else {
      craftingPatterns.remove(patternName);
      logger.info("removeCraftingPattern: patternName = {}", patternName);
    }
  }

  @Override
  public List<String> getPatternNames() {
    return new ArrayList<>(craftingPatterns.keySet());
  }

  @Override
  public CraftingPattern getPattern(String patternName) throws IllegalParameterException {
    logger.info("getPattern: patternName = {}", patternName);
    if (patternName == null) {
      throw new IllegalParameterException("Pattern-name was null reference!\n");
    }
    if (craftingPatterns.get(patternName) == null) {
      throw new IllegalParameterException("'" + patternName + "' doesn't exist!\n");
    } else {
      return craftingPatterns.get(patternName);
    }
  }

  @Override
  public void craft(
      Inventory inventory, CraftingPattern craftingPattern) throws CraftingNotPossibleException {
    logger.info("craft: inventory = {}, craftingPattern = {}", inventory, craftingPattern);
    if (craftingActive) {
      throw new CraftingNotPossibleException("An item is already being crafted!\n");
    }
    if (inventory == null || craftingPattern == null) {
      throw new CraftingNotPossibleException("Inventory or Crafting Pattern was null reference!\n");
    }
    craftingPattern.printCraftingPattern();
    ArrayList<Item> usedItems = new ArrayList<>();
    // check if the inventory matches the crafting pattern
    for (int i = 0; i < craftingPattern.getNeededItems().size(); i++) {
      for (int j = 0; j < inventory.getItems().size(); j++) {
        if (craftingPattern.getNeededItems().get(i).toString()
            .equals(inventory.getItems().get(j).toString())) {
          usedItems.add(inventory.getItems().get(j));
          try {
            inventory.remove(inventory.getItems().get(j));
          } catch (IllegalParameterException | OperationNotSupportedException e) {
            logger.error(e.getMessage());
          }
          j = inventory.getItems().size();
        }
      }
    }
    // if the pattern implies the inventory:
    // create the crafted object/s and add it/them to the inventory
    if (craftingPattern.getNeededItems().size() == usedItems.size()) {
      // start crafting process (callback notification)
      try {
        addListener(callbackNotificator);
        listener.craftingStartedNotification(craftingPattern);
      } catch (IllegalParameterException e) {
        logger.error(e.getMessage());
      }
      // initialize a crafting thread
      Crafting crafting = new Crafting(inventory, craftingPattern);
      Thread craftingThread = new Thread(crafting);
      // start crafting
      craftingActive = true;
      craftingThread.start();
      currentThread = craftingThread;
    } else { // if not: throw exception
      inventory.getItems().addAll(usedItems);
      throw new CraftingNotPossibleException("Items in inventory don't match '"
          + craftingPattern.toString() + "'!\n");
    }
  }

  @Override
  public void addListener(CraftingListener listener) throws IllegalParameterException {
    logger.info("addListener: listener = {}", listener);
    if (listener == null) {
      throw new IllegalParameterException("Listener was null reference!\n");
    }
    CraftingImplementation.listener = listener;
  }

  @Override
  public void removeListener(CraftingListener listener) throws IllegalParameterException {
    logger.info("removeListener: listener = {}", listener);
    if (listener == null) {
      throw new IllegalParameterException("Listener was null reference!\n");
    }
    if (listener != CraftingImplementation.listener) {
      throw new IllegalParameterException("Listener can't be found!");
    }
    CraftingImplementation.listener = null;
  }

  public static CraftingListener getCallbackNotificator() {
    return callbackNotificator;
  }

  public static CraftingListener getListener() {
    return listener;
  }

  public static Thread getCurrentThread() {
    return currentThread;
  }

  public static boolean isCraftingActive() {
    return craftingActive;
  }

  public static void setCraftingActive(boolean crafting) {
    craftingActive = crafting;
  }
}
