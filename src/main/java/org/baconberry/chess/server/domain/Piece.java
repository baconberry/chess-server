package org.baconberry.chess.server.domain;

public enum Piece {
    PAWN, BISHOP, KNIGHT, KING, QUEEN, ROOK;


    String identifier() {
        return switch (this) {
            case PAWN -> "P";
            case BISHOP -> "B";
            case QUEEN -> "Q";
            case KNIGHT -> "N";
            case KING -> "K";
            case ROOK -> "R";
        };
    }
}
