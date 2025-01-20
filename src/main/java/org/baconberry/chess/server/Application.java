package org.baconberry.chess.server;

import org.baconberry.chess.server.domain.Board;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		var board = new Board();

	}

}
