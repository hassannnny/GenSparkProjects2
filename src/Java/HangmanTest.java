package Java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @Test
    void randomWord() {

        String actual = "";
        int random = 5;

        assertEquals("few", Hangman.randomWord(actual, random));

        random = 10;

        assertEquals("now", Hangman.randomWord(actual, random));

        random = 50;

        assertEquals("rug", Hangman.randomWord(actual, random));


    }

    @Test
    void lettersMissed() {

        String actual = "text";
        String guess = "y";
        String missedLetters = "";


        assertEquals("y", Hangman.lettersMissed(guess, missedLetters));

    }

    @Test
    void doesntContain() {

        String[][] grid = new String[10][21];

        //building og grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {

                grid[row][col] = " ";

                if ((col == 10 || col == 20) && row == 0) {
                    grid[row][col] = "+";
                }

                if ((row == 0) && (col >= 11 && col <= 19)) {
                    grid[row][col] = "-";
                }

                if (col == 20 && (row >= 1 && row <= 9)) {
                    grid[row][col] = "|";
                }

                if (row == 9 && col >= 17) {
                    grid[row][col] = "=";
                }
            }
        }



        String[][] testingGrid = new String[10][21];

        int i = 1;

        //building test grid
        for (int row = 0; row < testingGrid.length; row++) {
            for (int col = 0; col < testingGrid[row].length; col++) {

                testingGrid[row][col] = " ";

                if ((col == 10 || col == 20) && row == 0) {
                    testingGrid[row][col] = "+";
                }

                if ((row == 0) && (col >= 11 && col <= 19)) {
                    testingGrid[row][col] = "-";
                }

                if (col == 20 && (row >= 1 && row <= 9)) {
                    testingGrid[row][col] = "|";
                }

                if (row == 9 && col >= 17) {
                    testingGrid[row][col] = "=";
                }
            }
        }

        testingGrid[2][10] = "O";


        
        assertEquals(Arrays.deepToString(testingGrid),Arrays.deepToString( Hangman.doesntContain(grid, i)));


    }

    @Test
    void doesContain() {

        String guess = "t";
        int winCounter = 0;

        ArrayList<String> word = new ArrayList<>();
        word.add("_");
        word.add("_");
        word.add("_");
        word.add("_");

        ArrayList<String> actualHolder = new ArrayList<>();
        actualHolder.add("t");
        actualHolder.add("e");
        actualHolder.add("x");
        actualHolder.add("t");

        ArrayList<String> expected = new ArrayList<>();
        word.add("t");
        word.add("_");
        word.add("_");
        word.add("t");

        assertEquals(2, Hangman.doesContain(guess, word, actualHolder, winCounter));


    }
}