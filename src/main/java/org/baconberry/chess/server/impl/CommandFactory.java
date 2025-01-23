package org.baconberry.chess.server.impl;

import org.baconberry.chess.server.CommandGenerator;
import org.baconberry.chess.server.domain.Board;
import org.baconberry.chess.server.domain.Command;
import org.baconberry.chess.server.domain.Piece;
import org.baconberry.chess.server.domain.PieceColor;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CommandFactory implements CommandGenerator {
    final Map<Piece, CommandGenerator> commandGeneratorMap = new EnumMap<>(Piece.class);

    public CommandFactory() {
        commandGeneratorMap.put(Piece.ROOK, new RookCommandGenerator());
    }

    @Override
    public List<Command> generate(Board board, PieceColor piece) {
        return Optional.ofNullable(commandGeneratorMap.get(piece.getPiece()))
                .map(g -> g.generate(board, piece))
                .orElse(Collections.emptyList());
    }
}
