package org.baconberry.chess.server.impl;

import org.baconberry.chess.server.CommandGenerator;
import org.baconberry.chess.server.domain.Board;
import org.baconberry.chess.server.domain.Command;
import org.baconberry.chess.server.domain.ICCFCommand;
import org.baconberry.chess.server.domain.Piece;
import org.baconberry.chess.server.domain.PieceColor;
import org.baconberry.chess.server.util.Direction;
import org.baconberry.chess.server.util.Point;

import java.util.ArrayList;
import java.util.List;

public class RookCommandGenerator implements CommandGenerator {
    @Override
    public List<Command> generate(Board board, PieceColor piece) {
        if (piece.getPiece() != Piece.ROOK) {
            throw new IllegalArgumentException("Piece is not a ROOK");
        }
        var pos = board.findLocation(piece);
        if (pos.isEmpty()) {
            throw new IllegalArgumentException("Piece not in board");
        }
        var list = new ArrayList<Command>(32);
        for (Direction direction : Direction.CARDINAL) {
            list.addAll(generateStraightMoves(board, pos.get(), direction));
        }
        return list;
    }

    private List<Command> generateStraightMoves(Board board, Point point, Direction direction) {
        var list = new ArrayList<Command>(8);
        var newPos = point.plusDir(direction);
        while (!board.isEmpty(newPos)) {
            var commandText = "%d%d%d%d".formatted(point.x(), point.y(), newPos.x(), newPos.y());
            list.add(new ICCFCommand(Integer.parseInt(commandText)));
            newPos = newPos.plusDir(direction);
        }
        return list;
    }
}
