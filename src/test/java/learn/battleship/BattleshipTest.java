package learn.battleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
        assertEquals(Player.class, game.getPlayer().getClass());
    }
    @Test
    void shouldCallBoardNewWithGivenLengthN() {
        assertEquals(5, game.getBoard().getGrid().length);
    }
    @Test
    void shouldSetBoardToInstanceWithSizeNTimesN() {

    }
    @Test
    void shouldSetRemainingMissesToHalfBoardSize() {
        int misses = game.getBoard().getSize()/2;
        assertEquals(misses, game.getRemainingMisses());
    }

    // getBoard
    @Test
    void shouldReturnBoardInstance() {
        // check if it is the class board
    }

    // getPlayer
    @Test
    void shouldReturnAPlayerInstance() {
        // check if class player
    }

    // startGame
    @Test
    void shouldRandomlyPlaceShipsOnTheBoard() {
        // expect it to use placeRandomShips method
    }
    @Test
    void shouldPrintNumberOfShipsPlacedOnBoard() {
        // need to check standard output here for number
    }


}