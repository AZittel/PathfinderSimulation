package de.hhn.it.pp.components.craftingservice.provider;

import de.hhn.it.pp.components.craftingservice.CraftingListener;
import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

/**
 * The callback notificator class which implements the CraftingListener - Interface.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-06-29
 */
public class Callback implements CraftingListener {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(CraftingListener.class);

  @Override
  public void craftingStartedNotification(CraftingPattern pattern)
      throws IllegalParameterException {
    logger.info("craftingStartedNotification: pattern = {}", pattern);
    if (pattern == null) {
      throw new IllegalParameterException("Crafting pattern was null reference!");
    }
  }

  @Override
  public void craftingEndedNotification(CraftingPattern pattern) throws IllegalParameterException {
    logger.info("craftingEndedNotification: pattern = {}", pattern);
    if (pattern == null) {
      throw new IllegalParameterException("Crafting pattern was null reference!");
    }
  }
}
