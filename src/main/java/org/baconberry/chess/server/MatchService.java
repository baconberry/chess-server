package org.baconberry.chess.server;

import org.baconberry.chess.server.domain.Board;
import org.baconberry.chess.server.domain.Command;
import org.baconberry.chess.server.impl.CommandFactory;
import org.baconberry.chess.server.util.Point;

import java.util.Comparator;

public record MatchService(CommandFactory commandFactory,
                           Comparator<Command> commandComparator) {

    public boolean isValidCommand(Board board, Command command) {
        var point = Point.of(command.startX(), command.startY());
        if (board.isEmpty(point)) {
            return false;
        }
        // always present
        var piece = board.getPiece(point).get();
        var validCommands = commandFactory.generate(board, piece);
        for (Command validCommand : validCommands) {
            if (commandComparator.compare(validCommand, command) == 0) {
                return true;
            }
        }
        return false;
    }
}
