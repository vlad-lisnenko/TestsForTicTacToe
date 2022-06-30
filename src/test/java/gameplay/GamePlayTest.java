package gameplay;

import data.Sign;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static utils.Utils.SIZE;


class GamePlayTest {

    @Test
    void checkGameState() {
    }

    @Test
    void game() throws IOException {
        Sign[][] testArray = textToArray("test_data_tie.txt");
        System.out.println(testArray);
    }

    private Sign[][] textToArray(String fileName) throws IOException {
        String str = Files.readString(Paths.get("src", "test", "resources", "test_data_tie.txt"));
        Sign[][] result = new Sign[SIZE][SIZE];
        String[] lines = str.split("\r\n");
        for (int i = 0; i < SIZE; i++) {
            String[] cells = lines[i].split(" ");
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = Sign.getSign(cells[j].charAt(0));
            }
        }
        return result;
    }



}