package de.hhn.it.pp.components.craftingservice.exceptions;

/**
 * An exception related to the crafting process.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-09
 */
public class CraftingNotPossibleException extends Exception {
  /**
   * Standard constructor with no arguments.
   */
  public CraftingNotPossibleException() {
  }

  /**
   * If user can't craft.
   *
   * @param message information for the user why the crafting isn't possible
   */
  public CraftingNotPossibleException(final String message) {
    super(message);
  }

  /**
   * Overloaded constructor.
   *
   * @param message information for the user why the crafting isn't possible
   * @param cause   additional cause
   */
  public CraftingNotPossibleException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * Overloaded constructor.
   *
   * @param cause additional cause
   */
  public CraftingNotPossibleException(final Throwable cause) {
    super(cause);
  }

  /**
   * Overloaded constructor.
   *
   * @param message            information for the user why the crafting isn't possible
   * @param cause              additional cause
   * @param enableSuppression  true or false
   * @param writableStackTrace true or false
   */
  public CraftingNotPossibleException(final String message, final Throwable cause,
                                      final boolean enableSuppression,
                                      final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

