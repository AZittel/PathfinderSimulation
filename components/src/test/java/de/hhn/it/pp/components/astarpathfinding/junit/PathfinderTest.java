package de.hhn.it.pp.components.astarpathfinding.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import de.hhn.it.pp.components.astarpathfinding.provider.Pathfinder;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PathfinderTest {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(PathfinderTest.class);

  Pathfinder pathfinder;

  @BeforeEach
  void setup() {
    pathfinder = new Pathfinder();
  }

  @Nested
  @DisplayName("Tests for changeTerrainTypeModifier")
  class PathfinderTest_changeTerrainTypeModifier {

    @Nested
    @DisplayName("Good Cases for changeTerrainTypeModifier")
    class PathfinderTest_changeTerrainTypeModifier_goodCases {
      @Test
      @DisplayName("Successful change TerrainType value")
      public void changeTerrainTypeModifier_successful() throws IllegalParameterException {
        pathfinder.changeTerrainTypeModifier(TerrainType.WATER, 0.7);
        assertEquals(0.7, TerrainType.WATER.getModifier());
      }
    }

    @Nested
    @DisplayName("Bad Cases for changeTerrainTypeModifier")
    class PathfinderTest_changeTerrainTypeModifier_badCases {
      @Test
      @DisplayName("Change TerrainType value below the minimum")
      public void changeTerrainTypeModifier_belowMinValue() throws IllegalParameterException {
        IllegalParameterException e =
            assertThrows(
                IllegalParameterException.class,
                () -> pathfinder.changeTerrainTypeModifier(TerrainType.WATER, -1));
        assertEquals(
            String.format(
                "Invalid modifier value! Modifier must not be lower than %f!",
                TerrainType.MIN_VALUE),
            e.getMessage());
      }

      @Test
      @DisplayName("Change TerrainType value above the maximum")
      public void changeTerrainTypeModifier_aboveMaxValue() throws IllegalParameterException {
        IllegalParameterException e =
            assertThrows(
                IllegalParameterException.class,
                () -> pathfinder.changeTerrainTypeModifier(TerrainType.WATER, 150));
        assertEquals(
            String.format(
                "Invalid modifier value! Modifier must not be greater than %f!",
                TerrainType.MAX_VALUE),
            e.getMessage());
      }
    }
  }
}
