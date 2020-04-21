package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

/**
 * Admin interface to the OurSnakeService to add / remove a Player to / from the service.
 */
public interface AdminSnakeService {

    /**
     * Adds a new CoffeeMaker to the service.
     * @param descriptor descriptor of the new coffee maker
     * @throws IllegalParameterException if the descriptor is a null reference or incomplete.
     */
    void addPlayer(SnakePlayerDescriptor descriptor) throws IllegalParameterException;

    /**
     * Removes a CoffeeMaker from the service.
     * @param coffeeMakerId id of the coffee maker to be removed
     * @throws IllegalParameterException if the id of the coffee maker does not exist.
     */
    void removePlayer(int coffeeMakerId) throws IllegalParameterException;
}
