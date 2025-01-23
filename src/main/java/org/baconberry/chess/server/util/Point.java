package org.baconberry.chess.server.util;

public record Point(int x, int y) {
    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public Point plusDir(Direction direction) {
        var diff = direction.cardinalDiff();
        return Point.of(x + diff.x, y + diff.y);
    }
}
