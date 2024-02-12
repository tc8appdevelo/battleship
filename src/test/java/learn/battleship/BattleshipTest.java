package learn.battleship;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Battleship")
class BattleshipTest {
    private Battleship game;

    @BeforeEach
    void setup() {
        game = new Battleship(5);
    }

    @Nested
    @DisplayName("initialize")
    class Initialize {


        @Test
        @DisplayName("sets player to new instance of Player class")
        public void shouldSetPlayerToNewPlayerInstance() {
            assertEquals(Player.class, new Battleship(5).getPlayer().getClass());
        }

        @Test
        @DisplayName("sets board to new instance of Board passing it n")
        void shouldCallBoardNewWithGivenLengthN() {
            assertEquals(5, game.getBoard().getGrid().length);
        }

        @Test
        @DisplayName("sets board size to n * n")
        void shouldSetBoardToInstanceWithSizeNTimesN() {
            assertEquals(100, new Battleship(10).getBoard().getSize());
        }

        @Test
        @DisplayName("sets remainingMisses int to half of board size")
        void shouldSetRemainingMissesToHalfBoardSize() {
            int misses = game.getBoard().getSize() / 2;
            assertEquals(misses, game.getRemainingMisses());
        }
    }
    // getBoard
    @Nested
    @DisplayName("getter methods")
    class ShouldGet {


        @Test
        @DisplayName("getBoard should return a Board instance")
        void shouldReturnBoardInstance() {
            assertEquals(Board.class, game.getBoard().getClass());
        }

        // getPlayer
        @Test
        @DisplayName("getPlayer should return a Player instance")
        void shouldReturnAPlayerInstance() {
            assertEquals(Player.class, game.getPlayer().getClass());
        }
    }
    // startGame
    @Nested
    @DisplayName("startGame")
    class StartGame {



        @Test
        @DisplayName("randomly places ships on board")
        void shouldRandomlyPlaceShipsOnTheBoard() {

        }


        @Test
        @DisplayName("prints the number of ships placed on the board")
        void shouldPrintNumberOfShipsPlacedOnBoard() {

        }
    }

}