package de.hhn.it.pp.components.tetris;

import de.hhn.it.pp.components.tetris.provider.logic.BoardState;

public interface TetrisListener {

    void newState(BoardState state);
}
