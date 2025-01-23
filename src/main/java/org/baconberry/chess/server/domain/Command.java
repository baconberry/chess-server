package org.baconberry.chess.server.domain;

public interface Command {
    int startX();

    int startY();

    int endX();

    int endY();
}
