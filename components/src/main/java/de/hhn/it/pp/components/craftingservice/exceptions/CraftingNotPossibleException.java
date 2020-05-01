package de.hhn.it.pp.components.craftingservice.exceptions;

public class CraftingNotPossibleException extends Exception {
    public CraftingNotPossibleException() {
    }

    public CraftingNotPossibleException(final String message) {
        super(message);
    }

    public CraftingNotPossibleException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CraftingNotPossibleException(final Throwable cause) {
        super(cause);
    }

    public CraftingNotPossibleException(final String message, final Throwable cause,
                                        final boolean enableSuppression,
                                        final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

