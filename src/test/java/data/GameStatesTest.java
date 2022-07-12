package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStatesTest {

    @Test
    void getGameStateMessage_returnCorrectGameStatesMessageForWinnerX() {
        //Act
        String actual = GameStates.WINNER_X.getGameStateMessage();
        //Assert
        assertEquals("X won's!", actual);
    }

    @Test
    void getGameStateMessage_returnCorrectGameStatesMessageForWinner0() {
        //Act
        String actual = GameStates.WINNER_0.getGameStateMessage();
        //Assert
        assertEquals("0 won's!", actual);
    }

    @Test
    void getGameStateMessage_returnCorrectGameStatesMessageForTie() {
        //Act
        String actual = GameStates.TIE.getGameStateMessage();
        //Assert
        assertEquals("Tie!", actual);
    }

    @Test
    void getGameStateMessage_returnCorrectGameStatesMessageForContinuingGame() {
        //Act
        String actual = GameStates.GAME_IS_CONTINUE.getGameStateMessage();
        //Assert
        assertEquals("Waiting for your move:", actual);
    }
}