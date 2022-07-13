package Java;

import org.junit.jupiter.api.Test;

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



    }

    @Test
    void doesntContain() {
    }

    @Test
    void doesContain() {
    }
}