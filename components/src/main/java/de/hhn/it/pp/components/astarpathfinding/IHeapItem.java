package de.hhn.it.pp.components.astarpathfinding;

import java.util.Comparator;

public interface IHeapItem<T> extends Comparable {
  int getHeapIndex();
  void setHeapIndex(int heapIndex);
}
