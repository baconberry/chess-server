package org.baconberry.chess.server.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

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
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                var c = getPiece(x,y)
                        .map(PieceColor::getPiece)
                        .map(Piece::identifier)
                        .orElse(".");
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    @AllArgsConstructor
    @Getter
    public class Square {
        PieceColor piece;
    }
}
