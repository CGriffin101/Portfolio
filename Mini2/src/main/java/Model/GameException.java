package Model;

import java.io.IOException;

/**Class: Model.GameException
 * @author Rick Price
 * @version 1.0
 * Course: ITEC 3860 Fall 2023
 * Written: July 28, 2023
 *
 * This class – is the custom exception for the game.
 */
public class GameException extends IOException {
    public GameException() {
        super();
    }

    public GameException(String message) {
        super(message);
    }
}
