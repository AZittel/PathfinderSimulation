package de.hhn.it.pp.components.api.src.main.java.api.models;

import java.util.Collection;

public interface Model {

    /**
     * Returns the class name of a model as a String
     */
    String getModelTyp();

    /**
     * Returns the names of all attributes as a collection of strings
     */
    Collection<String> getAttributeNames();

    /**
     * Returns all attributes as a collection of strings
     */
    Collection<String> getAttributes();
}
