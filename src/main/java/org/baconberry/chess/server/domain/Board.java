package org.baconberry.chess.server.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.baconberry.chess.server.util.Point;

import java.util.Optional;

@Slf4j
public class Board {
    final Square[][] state = new Square[8][8];

    public void setPiece(int x, int y, PieceColor val) {
        state[y][x] = new Square(val);
    }

    public Optional<PieceColor> getPiece(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return Optional.empty();
        }
        return Optional.ofNullable(state[x][y])
                .map(Square::getPiece);
    }

    public void printToConsole() {
        StringBuilder sb = new StringBuilder("\n");
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                var c = getPiece(x, y)
                        .map(PieceColor::getPiece)
                        .map(Piece::identifier)
                        .orElse(".");
                sb.append(c);
            }
            sb.append("\n");
        }
        log.error(sb.toString());
    }

    public Optional<Point> findLocation(PieceColor piece) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                var locP = getPiece(x, y);
                if (locP.isEmpty()) {
                    continue;
                }
                if (locP.get().equals(piece)) {
                    return Optional.of(Point.of(x, y));
                }
            }
        }
        return Optional.empty();
    }

    public boolean isEmpty(Point pos) {
        return getPiece(pos.x(), pos.x()).isEmpty();
    }

    public Optional<PieceColor> getPiece(Point point) {
        return getPiece(point.x(), point.y());
    }

    @AllArgsConstructor
    @Getter
    public class Square {
        PieceColor piece;
    }
}
