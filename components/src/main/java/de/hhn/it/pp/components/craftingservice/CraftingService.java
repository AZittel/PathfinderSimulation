package de.hhn.it.pp.components.craftingservice;

import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.OperationNotSupportedException;

import java.util.List;

/**
 * The component.CraftingService interface, which contains all relevant methods
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-09
 */
public interface CraftingService {

  /**
   * Adds a specific crafting pattern.
   *
   * @param pattern the pattern which will be added
   * @throws IllegalParameterException if null reference
   */
  void addCraftingPattern(CraftingPattern pattern) throws IllegalParameterException;

  /**
   * Removes a specific crafting pattern.
   *
   * @param patternName the name of the pattern, which will be removed
   * @throws IllegalParameterException      if null reference, or
   *                                        if a pattern with this name doesn't exist
   * @throws OperationNotSupportedException if there are no patterns
   */
  void removeCraftingPattern(
      String patternName) throws IllegalParameterException, OperationNotSupportedException;

  /**
   * Getter for the name of all patterns.
   *
   * @return a list with the names of all patterns
   */
  List<String> getPatternNames();

  /**
   * Getter for a specific crafting pattern.
   *
   * @param patternName the name of the pattern
   * @return the pattern with the given name
   * @throws IllegalParameterException if null reference, or
   *                                    if a pattern with this name doesn't exist
   */
  CraftingPattern getPattern(String patternName) throws IllegalParameterException;

  /**
   * Craft a specific pattern if possible and add it to the inventory.
   *
   * @param inventory       the provided inventory
   * @param craftingPattern the provided pattern
   * @throws CraftingNotPossibleException if inventory or craftingPattern are null, or
   *                                       if items in inventory don't match crafting Pattern, or
   *                                       if an item is already being crafted
   */
  void craft(
      Inventory inventory, CraftingPattern craftingPattern) throws CraftingNotPossibleException;

  /**
   * Adds a listener for a certain crafting process.
   *
   * @param listener listener which has information about the current crafting pattern
   * @throws IllegalParameterException if null reference
   */
  void addListener(CraftingListener listener) throws IllegalParameterException;

  /**
   * Removes a listener from a certain crafting process.
   *
   * @param listener listener which has information about the current crafting pattern
   * @throws IllegalParameterException if null reference, or
   *                                    if the given listener is not the current listener
   */
  void removeListener(CraftingListener listener) throws IllegalParameterException;
}