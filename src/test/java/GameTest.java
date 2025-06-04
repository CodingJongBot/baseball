import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");
    }


    @Test
    void returnSolvedResultIfMatchedNumber() {
        generateQuestion("123");
        assetMatchedNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    void returnSolvedResultIfUnMatchedNumber() {
        generateQuestion("123");
        assetMatchedNumber(game.guess("456"), false, 0, 0);
    }

    private void generateQuestion(String questionNumber) {
        game.question = questionNumber;
    }

    private static void assetMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }

    @Test
    void return2Strike0Ball() {
        generateQuestion("123");
        assetMatchedNumber(game.guess("124"), false, 2, 0);
    }


    //TODO 2.   1 Stirkes, 2 Ball 테스트 코드 추가 후, Balls을 구하는 코드 구현
    @Test
    void return1Strike2Ball() {
        generateQuestion("123");
        assetMatchedNumber(game.guess("132"), false, 1, 2);
    }

}
