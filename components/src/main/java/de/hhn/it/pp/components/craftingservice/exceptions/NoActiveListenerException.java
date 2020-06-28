package de.hhn.it.pp.components.craftingservice.exceptions;

/**
 * An exception related to the crafting listener.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-06-28
 */
public class NoActiveListenerException extends Exception {
  
  /**
   * If there is no active listener.
   */
  public NoActiveListenerException() {
  }
}