package de.hhn.it.pp.components.craftingservice.provider;

import de.hhn.it.pp.components.craftingservice.CraftingListener;
import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

/**
 * The callback notificator class which implements the CraftingListener - Interface.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-10
 */
public class Callback implements CraftingListener {

  @Override
  public void craftingStartedNotification(
      CraftingPattern pattern) throws IllegalParameterException {
    if (pattern == null) {
      throw new IllegalParameterException("Crafting pattern was null reference!\n");
    }
    System.out.println("\n'" + pattern.getName() + "' has started crafting!\n");
  }

  @Override
  public void craftingEndedNotification(CraftingPattern pattern) throws IllegalParameterException {
    if (pattern == null) {
      throw new IllegalParameterException("Crafting pattern was null reference!\n");
    }
    System.out.println("\n'" + pattern.getName() + "' has finished crafting!");
  }
}
