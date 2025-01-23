package org.baconberry.chess.server;

import org.baconberry.chess.server.domain.Board;
import org.baconberry.chess.server.domain.Piece;
import org.baconberry.chess.server.domain.PieceColor;
import org.springframework.stereotype.Service;


@Service
public class BoardFactory {

    public Board initBoard() {
        var board = new Board();
        for (int i = 0; i < 8; i++) {
            board.setPiece(i, 1, new PieceColor(Piece.PAWN, true));
            board.setPiece(i, 6, new PieceColor(Piece.PAWN, false));
        }
        board.setPiece(4, 0, new PieceColor(Piece.KING, true));
        board.setPiece(4, 7, new PieceColor(Piece.KING, false));
        board.setPiece(3, 0, new PieceColor(Piece.QUEEN, false));
        board.setPiece(3, 7, new PieceColor(Piece.QUEEN, false));

        board.setPiece(2, 0, new PieceColor(Piece.BISHOP, true));
        board.setPiece(2, 7, new PieceColor(Piece.BISHOP, false));
        board.setPiece(5, 0, new PieceColor(Piece.BISHOP, true));
        board.setPiece(5, 7, new PieceColor(Piece.BISHOP, false));

        board.setPiece(1, 0, new PieceColor(Piece.KNIGHT, true));
        board.setPiece(1, 7, new PieceColor(Piece.KNIGHT, false));
        board.setPiece(6, 0, new PieceColor(Piece.KNIGHT, true));
        board.setPiece(6, 7, new PieceColor(Piece.KNIGHT, false));

        board.setPiece(0, 0, new PieceColor(Piece.ROOK, true));
        board.setPiece(0, 7, new PieceColor(Piece.ROOK, false));
        board.setPiece(7, 0, new PieceColor(Piece.ROOK, true));
        board.setPiece(7, 7, new PieceColor(Piece.ROOK, false));

        return board;
    }
}
