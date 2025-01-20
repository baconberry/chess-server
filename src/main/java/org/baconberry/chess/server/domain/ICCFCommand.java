package org.baconberry.chess.server.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ICCFCommand implements Command {
    final int command;

    public int startX() {
        return (command / 1000) % 10;
    }

    public int startY() {
        return (command / 100) % 10;
    }

    public int endX() {
        return (command / 10) % 10;
    }

    public int endY() {
        return command % 10;
    }
}
