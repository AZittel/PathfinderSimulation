package de.hhn.it.pp.components.craftingservice;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;

/**
 * Callback notification mechanism, which informs about the current crafting state.
 *
 * @author Oliver Koch, Philipp Alessndrini
 * @version 2020-05-09
 */

public interface CraftingListener {

  /**
   * Notification callback, if the crafting process has started.
   *
   * @param pattern the specific pattern, the notification is about
   * @throws IllegalParameterException if null reference
   */
  void craftingStartedNotification(CraftingPattern pattern) throws IllegalParameterException;

  /**
   * Notification callback, if the crafting process has ended.
   *
   * @throws IllegalParameterException if null reference
   */
  void craftingEndedNotification(CraftingPattern pattern) throws IllegalParameterException;
}
