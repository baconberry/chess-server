package org.baconberry.chess.server;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardFactoryTest {

    @Test
    void initBoard() {
        var factory = new BoardFactory();
        var board = factory.initBoard();
        board.printToConsole();
    }
}