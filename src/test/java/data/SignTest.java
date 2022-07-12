package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignTest {

    @Test
    void getSign_returnCorrectSignForCharX() {
        //Act
        Sign actual = Sign.getSign('X');
        //Assert
        assertEquals(Sign.CROSS, actual, "Error");
    }

    @Test
    void getSign_returnCorrectSignForChar0() {
        Sign actual = Sign.getSign('0');

        assertEquals(Sign.ZERO, actual, "Error");
    }

    @Test
    void getOppositeSign_returnCorrectOppositeSign() {
        Sign actual = Sign.getOppositeSign(Sign.ZERO);

        assertEquals(Sign.CROSS, actual, "Error");
    }

    @Test
    void shouldReturnFirstSign() {
        var crossSign = Sign.CROSS;

        assertEquals('X', crossSign.getSign1());
    }

    @Test
    void shouldReturnSecondSign() {
        var crossSign = Sign.CROSS;

        assertEquals('x', crossSign.getSign2());
    }

    @Test
    void getSign1_returnFirstSign() {
        char firstSign = Sign.CROSS.getSign1();

        assertEquals('X', firstSign);
    }

    @Test
    void getSign2_returnSecondSign() {
        char secondSign = Sign.ZERO.getSign1();

        assertEquals('0', secondSign);
    }
}