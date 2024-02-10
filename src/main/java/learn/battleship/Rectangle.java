package learn.battleship;

import java.util.HashMap;

public class Rectangle {
    private int width;
    private int height;
    private int x;
    private int y;
    private int borderWidth;
    private char fillChar = '#';

    public Rectangle(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(int width, int height, int x, int y, char fillChar) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.fillChar = fillChar;
    }

}
