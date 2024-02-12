package learn.battleship;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Board")
class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board(5);
    }

    // initialize
    @Nested
    @DisplayName("initialize")
    class Initialize {


        @Test
        @DisplayName("sets grid 2D array of dimensions n * n")
        void setGridTo2dArrayOfCorrectDimensions() {
            int width = board.getGrid()[0].length;
            int height = board.getGrid().length;
            assertEquals(5, width);
            assertEquals(5, height);

            board = new Board(2);
            assertEquals(2, board.getGrid()[0].length);
            assertEquals(2, board.getGrid().length);
        }

        @Test
        @DisplayName("sets all elements of the grid to 'N'")
        void shouldSetAllElementsOfGridToCharN() {
            char[] expected = new char[board.getGrid().length];
            for (int i = 0; i < expected.length; i++) {
                expected[i] = 'N';
            }

            for (char[] actual : board.getGrid()) {
                assertArrayEquals(expected, actual);
            }
        }

        @Test
        @DisplayName("sets size to n * n")
        void shouldSetSizeToWidthTimesHeightOfGrid() {
            assertEquals(25, board.getSize());

            int n = 10;
            board = new Board(10);
            assertEquals((n * n), board.getSize());
        }
    }

    // getPosition
    @Nested
    @DisplayName("getPosition")
    class GetPosition {
        @Test
        @DisplayName("returns char value at grid[row][col]")
        void shouldReturnTheValueAtGivenPosition() {
            assertEquals('N', board.getPosition(0, 0));
            board.setPosition(1, 1, 'S');
            assertEquals('S', board.getPosition(1, 1));
        }
    }

    // setPosition
    @Nested
    @DisplayName("setPosition")
    class SetPosition {
        @Test
        @DisplayName("sets position to char value")
        void shouldSetGridRowColToValue() {
            assertEquals('N', board.getPosition(0, 4));
            board.setPosition(0, 4, 'S');
            assertEquals('S', board.getPosition(0, 4));

            board.setPosition(3, 3, 'H');
            assertEquals('H', board.getPosition(3, 3));
        }
    }

    // numShips
    @Nested
    @DisplayName("numShips")
    class NumShips {


        @Test
        @DisplayName("returns number of ships on game grid")
        void shouldReturnNumberOfShipsOnGrid() {
            assertEquals(0, board.numShips());

            board.setPosition(0, 0, 'S');
            assertEquals(1, board.numShips());

            board.setPosition(2, 2, 'S');
            assertEquals(2, board.numShips());

            board.setPosition(0, 0, 'X');
            assertEquals(1, board.numShips());
        }
    }
    // attack
    @Nested
    @DisplayName("attack")
    class Attack {
        @Test
        @DisplayName("sets position to 'H' for hit if it contains a ship char 'S'")
        void shouldSetShipsAtPositionToHitChar() {
            board.setPosition(0, 0, 'S');
            assertEquals('S', board.getPosition(0, 0));

            boolean actual = board.attack(0, 0);
            assertTrue(actual);
            assertEquals('H', board.getPosition(0, 0));
        }

        // should print "You sunk my battleship!"
        @Test
        @DisplayName("sets position to 'X' if there is no ship")
        void shouldSetPositionToMissCharIfNoShip() {
            board.setPosition(0, 0, 'N');
            boolean actual = board.attack(0, 0);
            assertFalse(actual);
            assertEquals('X', board.getPosition(0, 0));
        }

        @Test
        @DisplayName("returns true if attack hits a ship")
        void shouldReturnTrueIfAttackHitAShip() {
            board.setPosition(2, 2, 'S');
            assertTrue(board.attack(2, 2));
        }

        @Test
        @DisplayName("returns false if attack misses")
        void shouldReturnFalseIfAttackMisses() {
            assertFalse(board.attack(0, 0));
        }
        // should call setPosition and getPosition to check and set grid

    }
    // placeRandomShips
    @Nested
    @DisplayName("placeRandomShips")
    class PlaceRandomShips {
        @Test
        @DisplayName("sets 1/4 of the grid to ships, at random positions")
        void shouldSetQuarterOfGridElementsToShipsRandomly() {
            assertEquals(0, board.numShips());
            board.placeRandomShips();
            assertEquals(6, board.numShips());

            board = new Board(20);
        }
        // check if repeat same random position, which happens if grid is small,
        // need to roll the random position again until it is not already
        // a ship
    }

    // hiddenShipsGrid
    @Nested
    @DisplayName("hiddenShipsGrid")
    class HiddenShipsGrid {
        @Test
        @DisplayName("returns a 2D array with ship (S) symbols replaced with (N)")
        void shouldReturn2dArrayWhereEveryShipSymbolIsReplacedWithN() {
            board = new Board(2);
            char[] expected = {'N', 'N'};
            board.setPosition(0, 0, 'S');
            for (char[] arr : board.hiddenShipsGrid()) {
                assertArrayEquals(expected, arr);
            }
        }

        @Test
        @DisplayName("does NOT mutate original grid")
        void shouldNotMutateTheOriginalGrid() {
            board.setPosition(0, 0, 'S');
            board.setPosition(1, 1, 'S');
            char[][] original = board.getGrid();
            board.hiddenShipsGrid();
            for (int i = 0; i < original.length; i++) {
                assertArrayEquals(original[i], board.getGrid()[i]);
            }
        }
    }
    // cheat
    // printGameBoard
}