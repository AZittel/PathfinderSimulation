package de.hhn.it.pp.components.api.src.main.java.api.models;

import java.util.Collection;

public interface Model {

    /**
     * Returns the class name of a model as a String
     */
    public String getModelTyp();

    /**
     * Returns the names of all attributes as a collection of strings
     */
    public Collection<String> getAttributeNames();

    /**
     * Returns all attributes as a collection of strings
     */
    public Collection<String> getAttributes();
}
