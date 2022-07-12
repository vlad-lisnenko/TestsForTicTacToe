package gameplay;

import static data.GameStates.*;
import static data.Sign.*;
import static draw.Draw.drawField;
import static gameplay.TestUtils.textToArray;
import static org.junit.jupiter.api.Assertions.*;

import data.GameStates;
import data.Sign;
import org.junit.jupiter.api.Test;
import java.io.IOException;




class GamePlayTest {

    @Test
    void checkGameState() {
    }

    @Test
    void game_FillsFieldWithSignsChecksWinner_Field3X3_ReturnTie(){
        final int size = 3;
        //Arrange

        Sign[][] field = new Sign[size][size];

        field[0][0] = CROSS;
        field[0][1] = ZERO;
        field[0][2] = CROSS;

        field[1][0] = ZERO;
        field[1][1] = CROSS;
        field[1][2] = CROSS;

        field[2][0] = ZERO;
        field[2][1] = CROSS;
        field[2][2] = ZERO;

        GamePlay gamePlay = new GamePlay(field, size);

        drawField(field);

        GameStates expected = TIE;
        String expectedMessage = TIE.getGameStateMessage();

        // Act
        GameStates actual = gamePlay.checkGameState(CROSS);
        String actualMessage = gamePlay.checkGameState(CROSS).getGameStateMessage();

        // Assert
        assertEquals(expected, actual, "Game state wrong");
        assertEquals(expectedMessage, actualMessage, "Game state message wrong");
    }

    @Test
    void game_FillsFieldWithSignsChecksWinner_Field3X3_ReturnTie_LoadFile() throws IOException {
        // Arrange
        final int size = 3;
        Sign[][] testArray = textToArray("3x3/test_data_cross_wins.txt", size);

        GamePlay gamePlay = new GamePlay(testArray, size);
        drawField(testArray);

        GameStates expected = WINNER_X;
        String expectedMessage = WINNER_X.getGameStateMessage();

        // Act
        GameStates actual = gamePlay.checkGameState(CROSS);
        String actualMessage = gamePlay.checkGameState(CROSS).getGameStateMessage();

        // Assert
        assertEquals(expected, actual, "Game state wrong");
        assertEquals(expectedMessage, actualMessage, "Game state message wrong");

    }

    @Test
    void game_FillsFieldWithSignsChecksWinner_Field5X5_ReturnZerosWins_LoadFile() throws IOException {
        // Arrange
        final int size = 5;
        Sign[][] testArray = textToArray("5x5/test_data_zeros_wins.txt", size);

        GamePlay gamePlay = new GamePlay(testArray, size);
        drawField(testArray);

        GameStates expected = WINNER_0;
        String expectedMessage = WINNER_0.getGameStateMessage();

        // Act
        GameStates actual = gamePlay.checkGameState(ZERO);
        String actualMessage = gamePlay.checkGameState(ZERO).getGameStateMessage();

        // Assert
        assertEquals(expected, actual, "Game state wrong");
        assertEquals(expectedMessage, actualMessage, "Game state message wrong");

    }
    @Test
    void game_inputCorrectCoordinates_returnTrue() {
        //Arrange

        final int size = 3;
        GamePlay gamePlay = new GamePlay(size);

        //Act
        boolean actual = gamePlay.inputTurnsCoordinates(0, 0, Sign.getSign('x'));

        //Assert
        assertTrue(actual, "Incorrect data entry format");
    }

    @Test
    void game_inputIncorrectCoordinates_returnTrue() {
        //Arrange

        final int size = 3;
        GamePlay gamePlay = new GamePlay(size);

        //Act
        boolean actual = gamePlay.inputTurnsCoordinates(15, 0, Sign.getSign('x'));

        //Assert
        assertFalse(actual, "Incorrect data entry format");
    }

    @Test
    void game_getField_returnCorrectField() {
        // Arrange
        final int size = 3;
        GamePlay gamePlay = new GamePlay(size);

        Sign[][] expected = new Sign[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                expected[i][j] = EMPTY;
            }
        }

        // Act
        Sign[][] result = gamePlay.getField();

        // Assert
        assertArrayEquals(expected, result);
    }

}
