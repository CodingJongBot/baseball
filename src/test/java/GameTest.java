import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    @Test
    void name() {
        Game game = new Game();
        assertNotNull(game);
    }

    @Test
    void throwExceptionWhenInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.guess(null);
        });
    }
}
