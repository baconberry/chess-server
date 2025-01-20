package org.baconberry.chess.server.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class Match {
    final UUID id;
    final Board board;
    final Player whitePlayer;
    final Player blackPlayer;
    final List<PieceColor> capturedPieces;
    boolean isWhiteTurn = true;

    boolean applyCommand(Command command) {
        if (!isValidCommand(command)) {
            return false;
        }
        var startPiece = board.getPiece(command.startX(), command.startY()).get();
        board.setPiece(command.startX(), command.startY(), null);
        var endPiece = board.getPiece(command.endX(), command.endY());
        endPiece.ifPresent(this::capturePiece);
        board.setPiece(command.endX(), command.endY(), startPiece);
        isWhiteTurn = !isWhiteTurn;
        return true;
    }

    private void capturePiece(PieceColor pieceColor) {
        capturedPieces.add(pieceColor);
    }

    private boolean isValidCommand(Command command) {
        throw new UnsupportedOperationException();
    }
}
