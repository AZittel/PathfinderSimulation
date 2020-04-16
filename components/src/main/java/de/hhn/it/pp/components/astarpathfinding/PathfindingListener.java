package de.hhn.it.pp.components.astarpathfinding;

/** Callback for pathfinding algorithms to share information of their current state. */
public interface PathfindingListener {

  /**
   * Pushes the latest pathfinding algorithm information.
   *
   * @param info the current pathfinding information.
   */
  void updateInformation(PathfindingInformation info);
}
