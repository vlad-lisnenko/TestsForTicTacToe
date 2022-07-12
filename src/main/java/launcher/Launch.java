package launcher;

import gameplay.GamePlay;

import static utils.Utils.*;

public class  Launch {

    public static void main(String[] args) {
        GamePlay gamePlay = new GamePlay(SIZE);
        gamePlay.game();
    }
}
