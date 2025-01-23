package org.baconberry.chess.server;

import org.baconberry.chess.server.domain.Board;
import org.baconberry.chess.server.domain.Command;
import org.baconberry.chess.server.domain.PieceColor;

import java.util.List;

@FunctionalInterface
public interface CommandGenerator {

    List<Command> generate(Board board, PieceColor piece);
}
