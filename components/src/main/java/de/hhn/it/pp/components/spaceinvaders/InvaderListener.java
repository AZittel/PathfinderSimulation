package de.hhn.it.pp.components.spaceinvaders;

public interface InvaderListener {

  void strike(int x, int y);

  void newPlayerPosition(Position position);

  void newEnemyPosition(Position position);
}
