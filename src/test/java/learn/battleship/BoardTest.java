package learn.battleship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board(5);
    }

    // initialize
    @Test
    void shouldSetGridTo2dArrayOfCorrectDimensions() {
        int width = board.getGrid()[0].length;
        int height = board.getGrid().length;
        assertEquals(5, width);
        assertEquals(5, height);

        board = new Board(2);
        assertEquals(2, board.getGrid()[0].length);
        assertEquals(2, board.getGrid().length);
    }
    @Test
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
    void shouldSetSizeToWidthTimesHeightOfGrid() {
        assertEquals(25, board.getSize());

        int n = 10;
        board = new Board(10);
        assertEquals((n*n), board.getSize());
    }

    // getPosition
    @Test
    void shouldReturnTheValueAtGivenPosition() {
        assertEquals('N', board.getPosition(0, 0));
        board.setPosition(1, 1, 'S');
        assertEquals('S', board.getPosition(1, 1));
    }

    // setPosition
    @Test
    void shouldSetGridRowColToValue() {
        assertEquals('N', board.getPosition(0, 4));
        board.setPosition(0, 4, 'S');
        assertEquals('S', board.getPosition(0, 4));

        board.setPosition(3, 3, 'H');
        assertEquals('H', board.getPosition(3, 3));
    }


    // numShips
    @Test
    void shouldReturnNumberOfShipsOnGrid() {
        assertEquals(0, board.numShips());

        board.setPosition(0, 0, 'S');
        assertEquals(1, board.numShips());

        board.setPosition(2, 2, 'S');
        assertEquals(2, board.numShips());

        board.setPosition(0, 0, 'X');
        assertEquals(1, board.numShips());
    }

    // attack
    @Test
    void shouldSetShipsAtPositionToHitChar() {
        board.setPosition(0, 0, 'S');
        assertEquals('S', board.getPosition(0, 0));

        boolean actual = board.attack(0, 0);
        assertTrue(actual);
        assertEquals('H', board.getPosition(0, 0));
    }
    // should print "You sunk my battleship!"
    @Test
    void shouldSetPositionToMissCharIfNoShip() {
        board.setPosition(0, 0, 'N');
        boolean actual = board.attack(0, 0);
        assertFalse(actual);
        assertEquals('X', board.getPosition(0, 0));
    }
    @Test
    void shouldReturnTrueIfAttackHitAShip() {
        board.setPosition(2, 2, 'S');
        assertTrue(board.attack(2, 2));
    }
    @Test
    void shouldReturnFalseIfAttackMisses() {
        assertFalse(board.attack(0, 0));
    }
    // should call setPosition and getPosition to check and set grid


    // placeRandomShips
    @Test
    void shouldSetQuarterOfGridElementsToShipsRandomly() {
        assertEquals(0, board.numShips());
        board.placeRandomShips();
        assertEquals(5, board.numShips());

        board = new Board(20);
    }

    // hiddenShipsGrid
    @Test
    void shouldReturn2dArrayWhereEveryShipSymbolIsReplacedWithN() {
        board = new Board(2);
        char[] expected = {'N', 'N'};
        board.setPosition(0, 0, 'S');
        for (char[] arr : board.hiddenShipsGrid()) {
            assertArrayEquals(expected, arr);
        }
    }
    @Test
    void shouldNotMutateTheOriginalGrid() {
        board.setPosition(0, 0, 'S');
        board.setPosition(1, 1, 'S');
        char[][] original = board.getGrid();
        board.hiddenShipsGrid();
        for (int i = 0; i < original.length; i++) {
            assertArrayEquals(original[i], board.getGrid()[i]);
        }
    }

    // cheat
    // printGameBoard
}