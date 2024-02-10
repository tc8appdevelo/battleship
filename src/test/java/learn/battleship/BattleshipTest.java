package learn.battleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.util.Scanner;

class BattleshipTest {
//    private InputStream originalSystemIn;
//    private Scanner scanner;
    private Battleship game;

    @BeforeEach
    void setup() {
        game = new Battleship(5);
    }

//    @AfterEach
//    public void tearDown() {
//
//    }

    // initialize
    @Test
    public void shouldSetPlayerToNewPlayerInstance() {
        assertEquals(Player.class, new Battleship(5).getPlayer().getClass());
    }
    @Test
    void shouldCallBoardNewWithGivenLengthN() {
        assertEquals(5, game.getBoard().getGrid().length);
    }
    @Test
    void shouldSetBoardToInstanceWithSizeNTimesN() {
        assertEquals(100, new Battleship(10).getBoard().getSize());
    }
    @Test
    void shouldSetRemainingMissesToHalfBoardSize() {
        int misses = game.getBoard().getSize()/2;
        assertEquals(misses, game.getRemainingMisses());
    }

    // getBoard
    @Test
    void shouldReturnBoardInstance() {
        assertEquals(Board.class, game.getBoard().getClass());
    }

    // getPlayer
    @Test
    void shouldReturnAPlayerInstance() {
        assertEquals(Player.class, game.getPlayer().getClass());
    }

    // startGame
    @Disabled
    @Test
    void shouldRandomlyPlaceShipsOnTheBoard() {

    }
    @Disabled
    @Test
    void shouldPrintNumberOfShipsPlacedOnBoard() {

    }


}