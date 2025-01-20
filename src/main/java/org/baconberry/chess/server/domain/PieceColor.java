package org.baconberry.chess.server.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PieceColor {
    Piece piece;
    boolean isWhite;
}
