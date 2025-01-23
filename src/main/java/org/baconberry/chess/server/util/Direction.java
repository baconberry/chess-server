package org.baconberry.chess.server.util;

public enum Direction {
    N, S, E, W, NE, NW, SE, SW, NONE;

    public static final Direction[] CARDINAL = new Direction[]{N, S, E, W};

    public Point cardinalDiff() {
        return switch (this) {
            case N -> Point.of(0, 1);
            case S -> Point.of(0, -1);
            case E -> Point.of(1, 0);
            case W -> Point.of(-1, 0);
            case NE -> Point.of(1, 1);
            case NW -> Point.of(-1, 1);
            case SW -> Point.of(-1, -1);
            case SE -> Point.of(1, -1);
            case NONE -> Point.of(0, 0);
        };
    }
}
