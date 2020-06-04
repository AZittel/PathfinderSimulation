package de.hhn.it.pp.components.craftingservice.exceptions;

/**
 * An exception related to the crafting process.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-06-04
 */
public class CraftingNotPossibleException extends Exception {

  /**
   * If user can't craft.
   *
   * @param message information for the user why the crafting isn't possible
   */
  public CraftingNotPossibleException(final String message) {
    super(message);
  }
}

